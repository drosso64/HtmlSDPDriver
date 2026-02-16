package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.ULong;

import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPChangePasswordRes extends SAPMessage {



	public static final int  MSG_TYPE = 206;



	public enum Result

	{

		ChangePasswordOK(0),

		NoPrivilege(1),

		InvalidOldPassword(2),

		InvalidUserName(3),

		NotPrivilegeChangePassword(4),

		NewPAsswordRepeated(5),

		InsuffPasswordLenght(6),

		InvalidNewPasswordChar(7),

		NewPasswordTooMuchEasy(8);



		Result(int value)

		{

		}

	}

	

	protected ULong reqID = new ULong(0);

	protected Result result = Result.ChangePasswordOK;



	public SAPChangePasswordRes(SAPHeader sapHeader) {

		super(sapHeader);


	}



	@Override

	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {

		reqID.setValue(byteBuff.readInt());

		result = Result.values()[byteBuff.readInt()];



	}



	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {

		throw new Exception("SAPChangePasswordRes can be only read from client side");

	}

	

	@Override

	public String toString()

	{

		StringBuilder strBd = new StringBuilder()

		.append("SAPChangePasswordRes::")

		.append("MsgType(").append(getMessageType()).append(")")

		.append("ReqID(").append(reqID.getValue()).append(")")

		.append("Result(").append(result).append(")");

		return strBd.toString();

	}



	public ULong getReqID() {

		return reqID;

	}



	public void setReqID(ULong reqID) {

		this.reqID = reqID;

	}



	public Result getResult() {

		return result;

	}



	public void setResult(Result result) {

		this.result = result;

	}



	

}

