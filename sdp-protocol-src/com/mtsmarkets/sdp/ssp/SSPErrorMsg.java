package com.mtsmarkets.sdp.ssp;


import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SSPErrorMsg extends SSPMessage
{
	public static final int  PDU_ID = 113;


	public enum ErrorCode
	{
		None(0),
		WrongBlocking(1),
		WrongPacking(2),
		UnknownPacket(3),
		WindowOverFlow(4),
		AliveTimeOut(5),
		ProtocolError(6),
		UnexpectedCompressBlock(7),
		QueueSizeOverflow(8);

		ErrorCode(int value)
		{
		}
	}
	
	private ErrorCode errorCode = ErrorCode.None;

	
	public SSPErrorMsg()
	{
		super(new SSPHeader(PDU_ID, 0));
	}

	public SSPErrorMsg(SSPHeader sspHeader)
	{
    	super(sspHeader);
	}

	public ErrorCode getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode)
	{
		this.errorCode = errorCode;
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
		errorCode = ErrorCode.values()[byteBuff.readInt()];
	}

	@Override
	public int writeBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		return 0;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SSPErrorMsg::")
		.append(sspHeader.toString())
		.append("ErrorCode(").append(errorCode).append(")");

		return str.toString();
	}
}

