package com.mtsmarkets.sdp.ssp;


import com.mtsmarkets.components.logging.AbstractLogFactory;
import com.mtsmarkets.components.logging.ILog;
import com.mtsmarkets.sdp.common.FileLogFactorySDP;
import com.mtsmarkets.sdp.common.SDPException;
import com.mtsmarkets.sdp.common.SDPResultCode;
import com.mtsmarkets.sdp.sap.SAPHeader;
import com.mtsmarkets.sdp.sap.SAPMessage;
import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.UShort;
import com.mtsmarkets.io.xdr.XDRByteBuffer;
import com.mtsmarkets.io.xdr.XDRable;


public abstract class SSPMessage implements XDRable

{

	protected SSPHeader sspHeader = new SSPHeader();

	public abstract int writeBodyXDR(XDRByteBuffer byteBuff) throws Exception;
	public abstract void readXDR(XDRByteBuffer byteBuff) throws Exception;
	public abstract void readBodyXDR(XDRByteBuffer byteBuff) throws Exception;
	public SAPMessage getSapMessage(){return null;}

	

	private static ILog log = AbstractLogFactory.getLoggerByName(FileLogFactorySDP.SSP);


	static
	{				
        AbstractLogFactory.registerFactory(FileLogFactorySDP.getInstance());
	}
	

	public SSPMessage(SSPHeader sspHeader)
	{
		this.sspHeader = sspHeader;
	}

	public int sizeHeader()
	{
		return sspHeader.size();
	}

	public ULong getPduId()
	{
		return sspHeader.getPduId();
	}

	public void setPduId(UShort pduId)
	{
		sspHeader.getPduId().setValue(pduId.getValue());
	}

	public void setPduId(int pduId)
	{
		sspHeader.setPduId(pduId);
	}

	public ULong getPduLen()
	{
		return sspHeader.getPduLen();
	}

	public void setPduLen(ULong pduLen)
	{
		sspHeader.setPduLen(pduLen);
	}

	public void setPduLen(int pduLen)
	{
		sspHeader.setPduLen(pduLen);
	}

	public void writePduLen(XDRByteBuffer byteBuff, int size) throws Exception
	{
		// SSP.HEADER.SIZE = 8, SSP.HEADER.FIELD.LENGHT.OFFSET = 4
		byteBuff.writeInt(byteBuff.position() - size + 4 , size - 8);
		sspHeader.setPduLen(size - 8); 
	}

	public void writeHeaderXDR(XDRByteBuffer byteBuff) throws Exception
	{
		byteBuff.writeInt((int) sspHeader.getPduId().getValue());
		byteBuff.writeInt((int) sspHeader.getPduLen().getValue());
	}
        
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception
	{
		int size = sspHeader.writeXDR(byteBuff);
		size += writeBodyXDR(byteBuff);
		// set field size of header ssp
		writePduLen(byteBuff, size);
		return size;
	}

	public void readHeaderXDR(XDRByteBuffer byteBuffer) throws Exception
	{
            try {
		sspHeader.setPduId(byteBuffer.readInt());
		sspHeader.setPduLen(byteBuffer.readInt());            
            } catch (Exception e)
            {
                String msg = "SSPMessage::readHeaderXDR xdr error <" + e.getMessage() 
                        + "> decoding smpMessage in " + toString() 
                        + " position " + byteBuffer.position() + " limit " 
                        + byteBuffer.limit() + " capacity " + byteBuffer.capacity();
                throw new SDPException(SDPResultCode.XDR_DECODING_FAILED, msg, e);
            }
	}

	public static SSPMessage create(XDRByteBuffer byteBuffer, MarketFactory mktFactory) throws Exception 
	{
		SSPMessage sspMessage = null;
		SAPHeader sapHeader = null;
		SAPMessage sapMessage = null;
		SSPHeader sspHeader = new SSPHeader();
		
		sspHeader.readXDR(byteBuffer);

		long sspMsgType = sspHeader.getPduId().value;
		//log.debug("SSPMessage create: creating sspMsgType: %d", sspMsgType);

		if(sspMsgType == SSPConCloseRes.PDU_ID)
		{
			sspMessage =  new SSPConCloseRes(sspHeader);
		}
		else if(sspMsgType == SSPConCloseReq.PDU_ID)
		{
			sspMessage =  new SSPConCloseReq(sspHeader);
		}
		else if (sspMsgType == SSPConModifyReq.PDU_ID)
		{
			sspMessage =  new SSPConModifyReq(sspHeader);
		}
		else if (sspMsgType == SSPConModifyRes.PDU_ID)
		{
			sspMessage =  new SSPConModifyRes(sspHeader);
		}
		else if (sspMsgType == SSPConOpenReq.PDU_ID)
		{
			sspMessage =  new SSPConOpenReq(sspHeader);
		}
		else if (sspMsgType == SSPConOpenRes.PDU_ID)
		{
			sspMessage =  new SSPConOpenRes(sspHeader);
		}
        else if (sspMsgType == SSPConProbeReq.PDU_ID)
		{
			sspMessage =  new SSPConProbeReq(sspHeader);
		}
        else if (sspMsgType == SSPConProbeRes.PDU_ID)
		{
			sspMessage =  new SSPConProbeRes(sspHeader);
		}
		else if (sspMsgType == SSPSendMsg.PDU_ID)
		{
			sapHeader = new SAPHeader();
			sapHeader.readXDR(byteBuffer);
			sapMessage = SAPMessage.create(sapHeader, mktFactory);
			sspMessage =  new SSPSendMsg(sspHeader, sapMessage);
		}
		else if (sspMsgType == SSPSendMsgAck.PDU_ID)
		{
			sapHeader = new SAPHeader();
			sapHeader.readXDR(byteBuffer);
			sapMessage = SAPMessage.create(sapHeader, mktFactory);
			sspMessage =  new SSPSendMsgAck(sspHeader, sapMessage);
		}
		else if (sspMsgType == SSPSendData.PDU_ID)
		{
			sapHeader = new SAPHeader();
			sapHeader.readXDR(byteBuffer);
			sapMessage = SAPMessage.create(sapHeader, mktFactory);
			sspMessage =  new SSPSendData(sspHeader, sapMessage);
		}
		else if (sspMsgType == SSPErrorMsg.PDU_ID)
		{
			sspMessage =  new SSPErrorMsg(sspHeader);
		}
		else if (sspMsgType == SSPConAlive.PDU_ID)
		{
			sspMessage =  new SSPConAlive(sspHeader);
		}
		else
		{
			//TODO viene perso stack trace eccezione originale.
			// Verificare il perche. Momentaneamente loggo stack trace 
			//dell'eccezzione prima di wrapparla e rilanciarla
			log.error("SSPMessage create: Fatal error: Unknow SSPMessage: %d", sspMsgType);
			throw new SDPException(SDPResultCode.SSP_RECEIVE_UNEXPECTED_PDU, "Fatal error: Unknow SSPMessage: " + sspMsgType);
		}
		sspMessage.readBodyXDR(byteBuffer);

		return sspMessage;
	}

}

