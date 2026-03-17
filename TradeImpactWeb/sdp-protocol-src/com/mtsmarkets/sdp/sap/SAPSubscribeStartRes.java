package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SAPSubscribeStartRes extends SAPMessage
{
	public static final int  MSG_TYPE = 221;
	
	public enum Result
	{
		SAP_SubscribeOK(0),
		SAP_SubscribeKO(1),
		SAP_SubscribeBAD(2),
		SAP_SubscribeInvalidFilterID(3),
		SAP_SubscribeInvalidSubMask(4),
		SAP_SubscribeTooManyOpenSubscriptions(5),
		SAP_SubscribeNoFilterSpecified(6);

		Result(int value)
		{
		}
	}
	
	protected ULong reqId = new ULong(0);
	protected ULong classId = new ULong(0);
	protected ULong classVer = new ULong(0);
	protected Result result = Result.SAP_SubscribeOK;
	protected int resetClass = 0;
	protected ULong filterKey = new ULong(0);
	protected ULong subscribeKey = new ULong(0);
	
	public SAPSubscribeStartRes(SAPHeader sapHeader)
	{
		super(sapHeader);	
	}

	public ULong getReqID() {
		return reqId;
	}

	public void setReqID(ULong reqId) {
		this.reqId = reqId;
	}

	public ULong getClassId() {
		return classId;
	}

	public void setClassId(ULong classId) {
		this.classId = classId;
	}

	public ULong getClassVer() {
		return classVer;
	}

	public void setClassVer(ULong classVer) {
		this.classVer = classVer;
	}

	public Result getResult()
	{
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public int isResetClass() {
		return resetClass;
	}

	public void setResetClass(int resetClass) {
		this.resetClass = resetClass;
	}

	public ULong getFilterKey() {
		return filterKey;
	}

	public void setFilterKey(ULong filterKey) {
		this.filterKey = filterKey;
	}

	public ULong getSubscribeKey() {
		return subscribeKey;
	}

	public void setSubscribeKey(ULong subscribeKey) {
		this.subscribeKey = subscribeKey;
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		reqId.setValue(byteBuffer.readInt());
		classId.setValue(byteBuffer.readInt());
		classVer.setValue(byteBuffer.readInt());
		result = Result.values()[byteBuffer.readInt()];
		resetClass = byteBuffer.readInt();
		filterKey.setValue(byteBuffer.readInt());
		subscribeKey.setValue(byteBuffer.readInt());
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception
	{
		throw new Exception("SAPSubscribeStartRes can be only read from client side");
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
			.append("SAPSubscribeStartRes::")
			.append("MsgType(").append(getMessageType()).append(")")
			.append("ReqID(").append(reqId.getValue()).append(")")
			.append("ClassID(").append(classId.getValue()).append(")")
			.append("ClassVer(").append(classVer.getValue()).append(")")
			.append("Result(").append(result).append(")")
			.append("ResetClass(").append(resetClass).append(")")
			.append("FilterKey(").append(filterKey.getValue()).append(")")
			.append("SubscribeKey(").append(subscribeKey.getValue()).append(")");

		return str.toString();
	}
}

