package com.mtsmarkets.sdp.ssp;


import com.mtsmarkets.sdp.sap.SAPMessage;
import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SSPSendMsg extends SSPMessage
{

	public static final int PDU_ID = 110;


	private SAPMessage sapMessage = null;

	
	public SSPSendMsg()

	{
		super(new SSPHeader(PDU_ID, 0));
	}

	public SSPSendMsg(SAPMessage pSapMessage)

	{
		super(new SSPHeader(PDU_ID, 0));
		this.sapMessage = pSapMessage;
	}
	
	public SSPSendMsg(SSPHeader sspHeader, SAPMessage sapMessage)

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
		.append("SSPSendMsg::")
		.append(sspHeader.toString());
		return str.toString();
	}

	@Override
	public SAPMessage getSapMessage() {
		return sapMessage;
	}

}

