package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.sdp.smp.SMPMessage;
import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;







public class SAPQueryReq extends SAPMessage {



	public static final int MSG_TYPE = 240;

	

	protected ULong reqId = new ULong(0);

	protected ULong queryId = new ULong(0);

	protected ULong queryParamClassId = new ULong(0);

	protected ULong aliveTimeReq = new ULong(0);

	protected int paginationReq = 0;

	protected SMPMessage smpMessage = null;


    public SAPQueryReq()
	{
		super(new SAPHeader(MSG_TYPE));
	}

    public SAPQueryReq(SAPHeader sapHeader)
	{
		super(sapHeader);
	}

	public SAPQueryReq(SMPMessage smpMessage) {

		super(new SAPHeader(MSG_TYPE));

		this.smpMessage = smpMessage;

	}



	@Override

	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {

		throw new Exception("SAPQueryReq can only written from client side");



	}



	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {

		int init = byteBuff.getByteBuff().position();

		// header pdu

		sapHeader.writeXDR(byteBuff);

		// body pdu

		byteBuff.writeInt((int) reqId.getValue());

		byteBuff.writeInt((int) queryId.getValue());

		byteBuff.writeInt((int) queryParamClassId.getValue());

		byteBuff.writeInt((int) aliveTimeReq.getValue());

		byteBuff.writeInt(paginationReq);

		smpMessage.writeXDR(byteBuff);

		return byteBuff.getByteBuff().position() - init;

	}

	

	@Override

	public String toString()

	{

		StringBuilder strBd = new StringBuilder()

		.append("SAPQueryReq::")

		.append("ReqId(").append(reqId.getValue()).append(")")

		.append("QueryId(").append(queryId.getValue()).append(")")

		.append("QueryParamClassId(").append(queryParamClassId.getValue()).append(")")

		.append("AliveTimeReq(").append(aliveTimeReq.getValue()).append(")")

		.append("PaginationReq(").append(paginationReq).append(")");

		return strBd.toString();

	}



	public ULong getReqId() {

		return reqId;

	}



	public void setReqId(ULong reqId) {

		this.reqId = reqId;

	}

	

	public ULong getQueryId() {

		return queryId;

	}



	public void setQueryId(ULong queryId) {

		this.queryId = queryId;

	}



	public ULong getQueryParamClassId() {

		return queryParamClassId;

	}



	public void setQueryParamClassId(ULong queryParamClassId) {

		this.queryParamClassId = queryParamClassId;

	}



	public ULong getAliveTimeReq() {

		return aliveTimeReq;

	}



	public void setAliveTimeReq(ULong aliveTimeReq) {

		this.aliveTimeReq = aliveTimeReq;

	}



	public int getPaginationReq() {

		return paginationReq;

	}



	public void setPaginationReq(int paginationReq) {

		this.paginationReq = paginationReq;

	}



	public SMPMessage getSmpMessage() {

		return smpMessage;

	}



}

