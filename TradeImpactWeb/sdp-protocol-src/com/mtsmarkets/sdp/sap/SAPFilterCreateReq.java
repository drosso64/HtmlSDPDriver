package com.mtsmarkets.sdp.sap;


import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SAPFilterCreateReq extends SAPMessage {

	public static final int MSG_TYPE = 230;

	
	protected ULong reqId = new ULong(0);
	protected ULong filterId = new ULong(0);
	protected String filterVal = "";

	public SAPFilterCreateReq()
	{
		super(new SAPHeader(MSG_TYPE));
	}
    
    public SAPFilterCreateReq(SAPHeader sapHeader) {
		super(sapHeader);
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {
		reqId.setValue(byteBuff.readInt());
        filterId.setValue(byteBuff.readInt());
		filterVal = byteBuff.readString();
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {
		int init = byteBuff.getByteBuff().position();
		// header pdu
		sapHeader.writeXDR(byteBuff);
		// body pdu
		byteBuff.writeInt((int) reqId.getValue());
		byteBuff.writeInt((int) filterId.getValue());
		byteBuff.writeString(filterVal);
		return byteBuff.getByteBuff().position() - init;
	}
	
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SAPFilterCreateReq::")
		.append("MsgType(").append(getMessageType()).append(")")
		.append("ReqID(").append(reqId.getValue()).append(")")
		.append("FilterId(").append(filterId.getValue()).append(")")
		.append("FilterSpec(").append(filterVal).append(")");
		return str.toString();
	}

	public ULong getReqId() {
		return reqId;
	}

	public void setReqId(ULong reqId) {
		this.reqId = reqId;
	}

	public ULong getFilterId() {
		return filterId;
	}

	public void setFilterId(ULong filterId) {
		this.filterId = filterId;
	}

	public String getFilterVal() {
		return filterVal;
	}

	public void setFilterVal(String filterVal) {
		this.filterVal = filterVal;
	}

}