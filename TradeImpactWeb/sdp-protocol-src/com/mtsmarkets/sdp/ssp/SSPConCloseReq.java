package com.mtsmarkets.sdp.ssp;


import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SSPConCloseReq extends SSPMessage
{
	public static final int  PDU_ID = 103;


	public enum Reason
	{
		Normal(0),
		AliveTimeOut(1),
		Other(2);
		Reason(int value)
		{
		}
	}
	
	Reason reason = Reason.Normal;


	public Reason getReason()
	{
		return reason;
	}

	public void setReason(Reason reason)
	{
		this.reason = reason;
	}

	public SSPConCloseReq()
	{
    	super(new SSPHeader(PDU_ID, 0));
	}

    public SSPConCloseReq(SSPHeader sspHeader)
    {
    	super(sspHeader);
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
		reason = Reason.values()[byteBuff.readInt()];
	}

	@Override
	public int writeBodyXDR(XDRByteBuffer byteBuff) throws Exception 
	{
		// body pdu
		int init = byteBuff.position();
	
		byteBuff.writeInt(reason.ordinal());
		int sizeBody = (byteBuff.position() - init);
		this.sspHeader.setPduLen(sizeBody);

		return sizeBody;
	}

	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(64)
		.append("SSPConCloseReq::")
		.append(sspHeader.toString())
		.append("Reason(").append(reason).append(")");
		return stringBuilder.toString();
	}
}

