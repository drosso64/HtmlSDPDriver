package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SAPFilterSetReq extends SAPMessage {
	
	public static final int MSG_TYPE = 232;
	
	protected ULong reqId = new ULong(0);
	protected ULong filterKey = new ULong(0);
	protected String filterVal = "";
	
    public SAPFilterSetReq()
	{
		super(new SAPHeader(MSG_TYPE));
	}
    
    public SAPFilterSetReq(SAPHeader sapHeader) {
		super(sapHeader);
	}

	@Override
    public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {
		reqId.setValue(byteBuff.readInt());
        filterKey.setValue(byteBuff.readInt());
		filterVal = byteBuff.readString();
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {
		int init = byteBuff.getByteBuff().position();
		// header pdu
		sapHeader.writeXDR(byteBuff);
		// body pdu
		byteBuff.writeInt((int) reqId.getValue());
		byteBuff.writeInt((int) filterKey.getValue());
		byteBuff.writeString(filterVal);
		return byteBuff.getByteBuff().position() - init;
	}
	
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SAPFilterSetReq::")
		.append("MsgType(").append(getMessageType()).append(")")
		.append("ReqID(").append(reqId.getValue()).append(")")
		.append("FilterKey(").append(filterKey.getValue()).append(")")
		.append("FilterVal(").append(filterVal).append(")");
		return str.toString();
	}

	public ULong getReqId() {
		return reqId;
	}

	public void setReqId(ULong reqId) {
		this.reqId = reqId;
	}

	public ULong getFilterKey() {
		return filterKey;
	}

	public void setFilterKey(ULong filterKey) {
		this.filterKey = filterKey;
	}

	public String getFilterVal() {
		return filterVal;
	}

	public void setFilterVal(String filterVal) {
		this.filterVal = filterVal;
	}

}