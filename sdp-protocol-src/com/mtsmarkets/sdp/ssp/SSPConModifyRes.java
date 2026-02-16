package com.mtsmarkets.sdp.ssp;


import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SSPConModifyRes extends SSPMessage
{
	public static final int  PDU_ID = 106;


	private ULong reqId = new ULong(0);


	public SSPConModifyRes()
	{
		super(new SSPHeader(PDU_ID, 0));
	}

	public SSPConModifyRes(SSPHeader sspHeader)
	{
		super(sspHeader);
	}

	public ULong getReqId()
	{
		return reqId;
	}

	public void setReqId(ULong reqId)
	{
		this.reqId = reqId;
	}

	public void setReqId(long reqId)
	{
		this.reqId.setValue(reqId);
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
		reqId.setValue(byteBuff.readInt());		
	}

	@Override
	public int writeBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		// body pdu
		int init = byteBuff.position();
		byteBuff.writeInt((int)reqId.getValue());
		int sizeBody = (byteBuff.position() - init);
		this.sspHeader.setPduLen(sizeBody);

		return sizeBody;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SSPConModifyRes::")
		.append(sspHeader.toString())
		.append("ReqID(").append(reqId.getValue()).append(")");
		return str.toString();
	}
}

