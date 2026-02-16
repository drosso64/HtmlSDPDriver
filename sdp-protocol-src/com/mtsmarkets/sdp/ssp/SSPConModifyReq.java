package com.mtsmarkets.sdp.ssp;


import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SSPConModifyReq extends SSPMessage

{
	public static final int  PDU_ID = 105;

	
	private ULong reqId = new ULong(0);
	private short comunicWindowSize = 0;
	private ULong connectionFlags = new ULong(0);

	
	public SSPConModifyReq()
	{
    	super(new SSPHeader(PDU_ID, 0));
	}

    public SSPConModifyReq(SSPHeader sspHeader)
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

	public short getComunicWindowSize()
	{
		return comunicWindowSize;
	}

	public void setComunicWindowSize(short comunicWindowSize)
	{
		this.comunicWindowSize = comunicWindowSize;
	}

	public ULong getConnectionFlags()
	{
		return connectionFlags;
	}

	public void setConnectionFlags(ULong connectionFlags)
	{
		this.connectionFlags = connectionFlags;
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
		comunicWindowSize = (short) byteBuff.readInt();
		connectionFlags.setValue(byteBuff.readInt());
	}

	@Override
	public int writeBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		throw new Exception("SSPConModifyReq can only read from client side");
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SSPConModifyReq::")
		.append(sspHeader.toString())
		.append("ReqID(").append(reqId.getValue()).append(")")
		.append("ComunicWindowSize(").append(comunicWindowSize).append(")")
		.append("ConnectionFlags(").append(connectionFlags.getValue()).append(")");
		
		return str.toString();
	}
}

