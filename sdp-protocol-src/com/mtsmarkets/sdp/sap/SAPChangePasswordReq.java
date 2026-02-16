package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.ULong;

import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPChangePasswordReq extends SAPMessage {



	public static final int MSG_TYPE = 205;

	

	protected ULong reqId = new ULong(0);

	protected String user = "";

	protected String oldPassword = "";

	protected String newPassword = "";

	



	public SAPChangePasswordReq()

	{

		super(new SAPHeader(MSG_TYPE));

	}

	public SAPChangePasswordReq(SAPHeader sapHeader) {
		super(sapHeader);
    }


	@Override

	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {

		throw new Exception("SAPChangePasswordReq can only written from client side");

	}



	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {

		int init = byteBuff.getByteBuff().position();

		// header pdu

		sapHeader.writeXDR(byteBuff);

		// body pdu

		byteBuff.writeInt((int) reqId.getValue());

		byteBuff.writeString(user);

		byteBuff.writeString(oldPassword);

		byteBuff.writeString(newPassword);

		return byteBuff.getByteBuff().position() - init;

	}

	

	@Override

	public String toString()

	{

		StringBuilder str = new StringBuilder()

		.append("SAPChangePasswordReq::")

		.append("MsgType(").append(getMessageType()).append(")")

		.append("ReqID(").append(reqId.getValue()).append(")")

		.append("User(").append(user).append(")");

		//.append("OldPassword").append(oldPassword).append(")")

		//.append("NewPassword(").append(newPassword).append(")");

		return str.toString();

	}



	public ULong getReqId() {

		return reqId;

	}



	public void setReqId(ULong reqId) {

		this.reqId = reqId;

	}



	public String getUser() {

		return user;

	}



	public void setUser(String user) {

		this.user = user;

	}



	public String getOldPassword() {

		return oldPassword;

	}



	public void setOldPassword(String oldPassword) {

		this.oldPassword = oldPassword;

	}



	public String getNewPassword() {

		return newPassword;

	}



	public void setNewPassword(String newPassword) {

		this.newPassword = newPassword;

	}



}

