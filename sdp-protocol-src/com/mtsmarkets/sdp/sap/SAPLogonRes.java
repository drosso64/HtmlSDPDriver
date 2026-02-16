package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.ULong;

import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPLogonRes extends SAPMessage

{

	public static final int  MSG_TYPE = 202;

	public enum Result

	{
		LoginOK(0),
		LoginInvalPWD(1),
		LoginInvalUSR(2),
		LoginInvalVER(3),
		LoginALREADYLOG(4),
		LoginInternalError(5),
		AccountNotActive(6),
		TooManyTradersConnected(7),
		PasswordExpired(8),
		NotPrivilegeChangePassword(9),
		NewPasswordRepeated(10),
		InsuffNewPasswordLenght(11),
		InvalidNewPasswordChar(12),
		NewPasswordTooMuchEasy(13),
		UserMismatch(14),
		BadCertificate(15),
		ServiceNotAvailable(16);

		Result(int value)
		{
		}

	}

	

	protected ULong reqID = new ULong(0);
	protected ULong  protocolRevision = new ULong(0);
	protected Result result = Result.LoginOK;
	protected ULong  softwareRevision = new ULong(0);
	protected String userName = "";
	protected ULong  passwdLife = new ULong(0);
	protected ULong  systemDate = new ULong(0);
	protected ULong  systemTime = new ULong(0);


	public SAPLogonRes(SAPHeader sapHeader)
	{
		super(sapHeader);	
	}

	@Override

	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		reqID.setValue(byteBuff.readInt());
		protocolRevision.setValue(byteBuff.readInt());
		result = Result.values()[byteBuff.readInt()];
		softwareRevision.setValue(byteBuff.readInt());
		userName = byteBuff.readString();
		passwdLife.setValue(byteBuff.readInt());
		systemDate.setValue(byteBuff.readInt());
		systemTime.setValue(byteBuff.readInt());
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception

	{
		throw new Exception("SAPLogonRes can be only read from client side");
	}

	@Override
	public String toString()
	{
		StringBuilder strBd = new StringBuilder()
		.append("SAPLogonRes::")
		.append("MsgType(").append(getMessageType()).append(")")
		.append("ReqID(").append(reqID.getValue()).append(")")
		.append("ProtocolRevision(").append(protocolRevision.getValue()).append(")")
		.append("Result(").append(result).append(")")
		.append("SoftwareRevision(").append(softwareRevision.getValue()).append(")")
		.append("UserName(").append(userName).append(")")
		.append("PasswordLife(").append(passwdLife.getValue()).append(")")
		.append("SystemDate(").append(systemDate.getValue()).append(")")
		.append("SystemTime(").append(systemTime.getValue()).append(")");
		return strBd.toString();
	}

	public ULong getReqID() {
		return reqID;
	}

	public ULong getProtocolRevision() {
		return protocolRevision;
	}

	public Result getResult() {
		return result;
	}

	public ULong getSoftwareRevision() {
		return softwareRevision;
	}

	public String getUserName() {
		return userName;
	}

	public ULong getPasswdLife() {
		return passwdLife;
	}

	public ULong getSystemDate() {
		return systemDate;
	}

	public ULong getSystemTime() {
		return systemTime;
	}

}

