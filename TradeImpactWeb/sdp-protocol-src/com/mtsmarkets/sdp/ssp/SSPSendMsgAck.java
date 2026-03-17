package com.mtsmarkets.sdp.ssp;


import com.mtsmarkets.sdp.sap.SAPMessage;
import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SSPSendMsgAck extends SSPMessage

{
	public static final int  PDU_ID = 111;

	
	private SAPMessage sapMessage = null;


	public SAPMessage getSapMessage()
	{
		return sapMessage;
	}

	public SSPSendMsgAck(SSPHeader sspHeader, SAPMessage sapMessage)
	{
		super(sspHeader);
		this.sapMessage = sapMessage;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuff) throws Exception
	{
		sspHeader.readXDR(byteBuff);
		readBodyXDR(byteBuff);
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		sapMessage.readBodyXDR(byteBuff);
	}

	@Override
	public int writeBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		int sizeBody = sapMessage.writeXDR(byteBuff);
		this.sspHeader.setPduLen(sizeBody);
		return sizeBody;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SSPSendMsgAck::")
		.append(sspHeader.toString());
		return str.toString();
	}

}

