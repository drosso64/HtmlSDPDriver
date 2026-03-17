package com.mtsmarkets.sdp.ssp;



import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SSPConCloseRes extends SSPMessage

{
	public static final int  PDU_ID = 104;
	

	public SSPConCloseRes()
	{
    	super(new SSPHeader(PDU_ID, 0));
	}

    public SSPConCloseRes(SSPHeader sspHeader)
    {
    	super(sspHeader);
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuff) throws Exception
	{
		sspHeader.readXDR(byteBuff);
	}

    @Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
	}

	@Override
	public int writeBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		return 0;
	}

	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(64)
		.append("SSPConCloseRes::")
		.append(sspHeader.toString());
		return stringBuilder.toString();
	}
}

