package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SAPFilterCreateRes extends SAPMessage {

	public static final int  MSG_TYPE = 231;
	
	public enum Result
	{
		SapFilterCreateOK(0),
		SapFilterCreateSintaxError(1),
		SapFilterCreateInvalidFilterKey(2),
		SapFilterCreateInvalidFilterLen(3),
		SapFilterCreateValueAlreadyInUse(4),
		SapFilterTooManyFiltersOpen(5);

		Result(int value)
		{
		}
	}
	
	protected ULong reqID = new ULong(0);
	protected ULong  filterKey = new ULong(0);
	protected Result result = Result.SapFilterCreateOK;

	public SAPFilterCreateRes(SAPHeader sapHeader) {
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
		throw new Exception("SAPFilterCreateRes can be only read from client side");
	}
	
	@Override
	public String toString()
	{
		StringBuilder strBd = new StringBuilder()
		.append("SAPFilterCreateRes::")
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