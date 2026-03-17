package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.sdp.smp.SMPMessage;
import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;




public class SAPQueryDestroyReq extends SAPMessage {



	public static final int MSG_TYPE = 246;

	

	protected ULong reqId = new ULong(0);

	protected ULong queryKey = new ULong(0);



	public SAPQueryDestroyReq(SMPMessage smpMessage) {

		super(new SAPHeader(MSG_TYPE));

	}

	public SAPQueryDestroyReq(SAPHeader sapHeader) {

		super(sapHeader);	

	}

	@Override

	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {

		throw new Exception("SAPQueryDestroyReq can only written from client side");



	}



	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {

		int init = byteBuff.getByteBuff().position();

		// header pdu

		sapHeader.writeXDR(byteBuff);

		// body pdu

		byteBuff.writeInt((int) reqId.getValue());

		byteBuff.writeInt((int) queryKey.getValue());

		return byteBuff.getByteBuff().position() - init;

	}

	

	@Override

	public String toString()

	{

		StringBuilder strBd = new StringBuilder()

		.append("SAPQueryDestroyReq::")

		.append("ReqId(").append(reqId.getValue()).append(")")

		.append("QueryKey(").append(queryKey.getValue()).append(")");

		return strBd.toString();

	}



	public ULong getReqId() {

		return reqId;

	}



	public void setReqId(ULong reqId) {

		this.reqId = reqId;

	}

	

	public ULong getQueryKey() {

		return queryKey;

	}



	public void setQueryKey(ULong queryKey) {

		this.queryKey = queryKey;

	}





}

