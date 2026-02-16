package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.ULong;

import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPQueryRes extends SAPMessage {



	public static final int  MSG_TYPE = 241;

	

	public enum Result

	{

		SAP_QueryOK(0),

		SAP_BadParameters(1),

		SAP_WrongQueryId(2),

		SAP_GenericError(3),

		SAP_MustPaginateQuery(4);



		Result(int value)

		{

		}

	}

	

	protected ULong reqId = new ULong(0);

	protected ULong queryKey = new ULong(0);

	protected Result result = Result.SAP_QueryOK;

	protected ULong rowsNumber = new ULong(0);

	protected ULong aliveTimeRes = new ULong(0);

	protected int paginationRes = 0;

	

	public SAPQueryRes(SAPHeader sapHeader)

	{

		super(sapHeader);	

	}



	@Override

	public void readBodyXDR(XDRByteBuffer byteBuffer) throws Exception

	{

		reqId.setValue(byteBuffer.readInt());

		queryKey.setValue(byteBuffer.readInt());

		result = Result.values()[byteBuffer.readInt()];

		rowsNumber.setValue(byteBuffer.readInt());

		aliveTimeRes.setValue(byteBuffer.readInt());

		paginationRes = byteBuffer.readInt();

	}

	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception

	{

		throw new Exception("SAPQueryRes can be only read from client side");

	}

	@Override

	public String toString()

	{

		StringBuilder strBd = new StringBuilder()

		.append("SAPQueryRes::")

		.append("MsgType(").append(getMessageType()).append(")")

		.append("ReqID(").append(reqId.getValue()).append(")")

		.append("QueryKey(").append(queryKey.getValue()).append(")")

		.append("Result(").append(result).append(")")

		.append("RowsNumber(").append(rowsNumber.getValue()).append(")")

		.append("AliveTimeRes(").append(aliveTimeRes.getValue()).append(")")

		.append("PaginationRes(").append(paginationRes).append(")");

		return strBd.toString();

	}

	

	public ULong getReqId() {

		return reqId;

	}



	public void setReqId(ULong reqId) {

		this.reqId = reqId;

	}



	public ULong getRowsNumber() {

		return rowsNumber;

	}



	public void setRowsNumber(ULong rowsNumber) {

		this.rowsNumber = rowsNumber;

	}



	public ULong getAliveTimeRes() {

		return aliveTimeRes;

	}



	public void setAliveTimeRes(ULong aliveTimeRes) {

		this.aliveTimeRes = aliveTimeRes;

	}



	public int getPaginationRes() {

		return paginationRes;

	}



	public void setPaginationRes(int paginationRes) {

		this.paginationRes = paginationRes;

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

