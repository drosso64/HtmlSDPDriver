package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.XDRByteBuffer;





public class SAPLogonTokenRes extends SAPLogonRes {



	public static final int  MSG_TYPE = 251;

	

	protected String token = "";

	

	

	public SAPLogonTokenRes(SAPHeader sapHeader) {

		super(sapHeader);

	}

	

	@Override

	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {

		

		super.readBodyXDR(byteBuff);

		token = byteBuff.readString();		

	}

	@Override

	public String toString()

	{

		StringBuilder strBd = new StringBuilder()

		.append("SAPLogonTokenRes::")

		.append("MsgType(").append(getMessageType()).append(")")

		.append("ReqID(").append(reqID.getValue()).append(")")

		.append("ProtocolRevision(").append(protocolRevision.getValue()).append(")")

		.append("Result(").append(result).append(")")

		.append("SoftwareRevision(").append(softwareRevision.getValue()).append(")")

		.append("User(").append(userName).append(")")

		.append("PasswdLife(").append(passwdLife.getValue()).append(")")

		.append("SystemDate(").append(systemDate.getValue()).append(")")

		.append("SystemTime(").append(systemTime.getValue()).append(")")

		.append("Token(").append(token).append(")");

		return strBd.toString();

	}



	public String getToken() {

		return token;

	}





	public void setToken(String token) {

		this.token = token;

	}

}

