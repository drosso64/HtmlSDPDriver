package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.sdp.smp.SMPMessage;
import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPQueryRowsDataReq extends SAPMessage {



	public static final int MSG_TYPE = 242;

	

	protected ULong reqId = new ULong(0);

	protected ULong queryKey = new ULong(0);

	protected ULong initRow = new ULong(0);

	protected ULong rowsNumber = new ULong(0);



	public SAPQueryRowsDataReq(SMPMessage smpMessage) {

		super(new SAPHeader(MSG_TYPE));

	}



	@Override

	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {

		throw new Exception("SAPQueryRowsDataReq can only written from client side");



	}



	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {

		int init = byteBuff.getByteBuff().position();

		// header pdu

		sapHeader.writeXDR(byteBuff);

		// body pdu

		byteBuff.writeInt((int) reqId.getValue());

		byteBuff.writeInt((int) queryKey.getValue());

		byteBuff.writeInt((int) initRow.getValue());

		byteBuff.writeInt((int) rowsNumber.getValue());

		return byteBuff.getByteBuff().position() - init;

	}

	

	@Override

	public String toString()

	{

		StringBuilder strBd = new StringBuilder()

		.append("SAPQueryRowsDataReq::")

		.append("ReqId(").append(reqId.getValue()).append(")")

		.append("queryKey(").append(queryKey.getValue()).append(")")

		.append("InitRow(").append(initRow.getValue()).append(")")

		.append("RowsNumber(").append(rowsNumber.getValue()).append(")");

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



	public ULong getInitRow() {

		return initRow;

	}



	public void setInitRow(ULong initRow) {

		this.initRow = initRow;

	}



	public ULong getRowsNumber() {

		return rowsNumber;

	}



	public void setRowsNumber(ULong rowsNumber) {

		this.rowsNumber = rowsNumber;

	}



}

