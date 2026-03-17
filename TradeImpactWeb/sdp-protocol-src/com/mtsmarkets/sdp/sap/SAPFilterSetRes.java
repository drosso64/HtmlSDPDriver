package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.ULong;

import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPFilterSetRes extends SAPMessage {



	public static final int  MSG_TYPE = 233;



	public enum Result

	{

		SapFilterSetOK(0),

		SapFilterSetSintaxError(1),

		SapFilterSetInvalidFilterKey(2),

		SapFilterSetInvalidFilterLen(3),

		SapFilterSetValueAlreadyInUse(4);



		Result(int value)

		{

		}

	}

	

	protected ULong reqID = new ULong(0);

	protected ULong  filterKey = new ULong(0);

	protected Result result = Result.SapFilterSetOK;



	public SAPFilterSetRes(SAPHeader sapHeader) {
		super(sapHeader);
	}



	@Override

	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {

		reqID.setValue(byteBuff.readInt());

		filterKey.setValue(byteBuff.readInt());

		result = Result.values()[byteBuff.readInt()];



	}



	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {

		throw new Exception("SAPFilterSetRes can be only read from client side");

	}

	

	@Override

	public String toString()

	{

		StringBuilder strBd = new StringBuilder()

		.append("SAPFilterSetRes::")

		.append("MsgType(").append(getMessageType()).append(")")

		.append("ReqID(").append(reqID.getValue()).append(")")

		.append("FilterKey(").append(filterKey.getValue()).append(")")

		.append("Result(").append(result).append(")");

		return strBd.toString();

	}



	public ULong getReqID() {

		return reqID;

	}



	public void setReqID(ULong reqID) {

		this.reqID = reqID;

	}



	public ULong getFilterKey() {

		return filterKey;

	}



	public void setFilterKey(ULong filterKey) {

		this.filterKey = filterKey;

	}



	public Result getResult() {

		return result;

	}



	public void setResult(Result result) {

		this.result = result;

	}



}

