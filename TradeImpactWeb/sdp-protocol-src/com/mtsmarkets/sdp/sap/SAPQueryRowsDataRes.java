package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.ULong;

import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPQueryRowsDataRes extends SAPMessage {



	public static final int  MSG_TYPE = 243;

	

	public enum Result

	{

		SAP_QueryRowsDataOK(0),

		SAP_WrongInitrow(1),

		SAP_WrongRowNumber(2),

		SAP_WrongQueryId(3),

		SAP_GenericError(4),

		SAP_TooManyRows(5);



		Result(int value)

		{

		}

	}

	

	protected ULong reqId = new ULong(0);

	protected ULong queryKey = new ULong(0);

	protected Result result = Result.SAP_QueryRowsDataOK;

	

	public SAPQueryRowsDataRes(SAPHeader sapHeader)

	{

		super(sapHeader);	

	}



	@Override

	public void readBodyXDR(XDRByteBuffer byteBuffer) throws Exception

	{

		reqId.setValue(byteBuffer.readInt());

		queryKey.setValue(byteBuffer.readInt());

		result = Result.values()[byteBuffer.readInt()];

	}

	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception

	{

		throw new Exception("SAPQueryRowsDataRes can be only read from client side");

	}

	@Override

	public String toString()

	{

		StringBuilder strBd = new StringBuilder()

		.append("SAPQueryRowsDataRes::")

		.append("MsgType(").append(getMessageType()).append(")")

		.append("ReqID(").append(reqId.getValue()).append(")")

		.append("QueryKey(").append(queryKey.getValue()).append(")")

		.append("Result(").append(result).append(")");

		return strBd.toString();

	}

	

	public ULong getReqId() {

		return reqId;

	}



	public void setReqId(ULong reqId) {

		this.reqId = reqId;

	}



	public ULong getReqID() {

		return reqId;

	}



	public void setReqID(ULong reqId) {

		this.reqId = reqId;

	}



	public ULong getQueryKey() {

		return queryKey;

	}



	public void setQueryKey(ULong queryKey) {

		this.queryKey = queryKey;

	}



	public Result getResult()

	{

		return result;

	}



	public void setResult(Result result) {

		this.result = result;

	}



}

