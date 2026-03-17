package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SAPBrowseRes extends SAPMessage
{
	public static final int  MSG_TYPE = 261;
	
	public enum Result
	{
		SAP_BrowseOK(0),
		SAP_BrowseKO(1),
		SAP_BrowseBAD(2),
		SAP_BrowseInvalidKeyID(3);

		Result(int value)
		{
		}
	}
	
	protected ULong reqId = new ULong(0);
	protected ULong classId = new ULong(0);	
	protected Result result = Result.SAP_BrowseOK;
	protected ULong browseKey = new ULong(0);
	
	public SAPBrowseRes(SAPHeader sapHeader)
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

	public Result getResult()
	{
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public ULong getBrowseKey() {
		return browseKey;
	}

	public void setBrowseKey(ULong browseKey) {
		this.browseKey = browseKey;
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		reqId.setValue(byteBuffer.readInt());
		classId.setValue(byteBuffer.readInt());
		result = Result.values()[byteBuffer.readInt()];
		browseKey.setValue(byteBuffer.readInt());
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception
	{
		throw new Exception("SAPBrowseRes can be only read from client side");
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
			.append("SAPBrowseRes::")
			.append("MsgType(").append(getMessageType()).append(")")
			.append("ReqID(").append(reqId.getValue()).append(")")
			.append("ClassID(").append(classId.getValue()).append(")")
			.append("Result(").append(result).append(")")
			.append("BrowseKey(").append(browseKey.getValue()).append(")");

		return str.toString();
	}
}

