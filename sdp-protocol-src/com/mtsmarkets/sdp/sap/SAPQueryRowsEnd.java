package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.ULong;

import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPQueryRowsEnd extends SAPMessage {



	public static final int  MSG_TYPE = 245;

	

	public enum Result

	{

		SAP_QueryEndedOK(0),

		SAP_QueryEndedError(1),

		SAP_QueryEndedAliveError(2),

		SAP_QueryEndedByClient(3);



		Result(int value)

		{

		}

	}

	

	protected ULong queryKey = new ULong(0);

	protected Result errorCode = Result.SAP_QueryEndedOK;

	

	public SAPQueryRowsEnd(SAPHeader sapHeader)

	{

		super(sapHeader);	

	}



	@Override

	public void readBodyXDR(XDRByteBuffer byteBuffer) throws Exception

	{

		queryKey.setValue(byteBuffer.readInt());

		errorCode = Result.values()[byteBuffer.readInt()];

	}

	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception

	{

		throw new Exception("SAPQueryRowsEnd can be only read from client side");

	}

	@Override

	public String toString()

	{

		StringBuilder strBd = new StringBuilder()

		.append("SAPQueryRowsEnd::")

		.append("MsgType(").append(getMessageType()).append(")")

		.append("QueryKey(").append(queryKey.getValue()).append(")")

		.append("ErrorCode(").append(errorCode).append(")");

		return strBd.toString();

	}



	public ULong getQueryKey() {

		return queryKey;

	}



	public void setQueryKey(ULong queryKey) {

		this.queryKey = queryKey;

	}



	public Result getErrorCode()

	{

		return errorCode;

	}



	public void setErrorCode(Result result) {

		this.errorCode = result;

	}



}

