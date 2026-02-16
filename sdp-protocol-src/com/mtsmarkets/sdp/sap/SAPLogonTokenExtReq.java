package com.mtsmarkets.sdp.sap;

public class SAPLogonTokenExtReq extends SAPLogonTokenReq
{
	public static final int  MSG_TYPE = 249;

	public SAPLogonTokenExtReq()
	{
		super(MSG_TYPE);
	}
    
    public SAPLogonTokenExtReq(SAPHeader sapHeader)
	{
		super(sapHeader);	
	}

	public String toString()
	{
		StringBuilder strBd = new StringBuilder()
		.append("SAPLogonTokenExtReq::")
		.append("MsgType(").append(getMessageType()).append(")")
		.append("ReqID(").append(reqId.getValue()).append(")")
		.append("ProtocolRevision(").append(protocolRevision.getValue()).append(")")
		.append("Signature(").append(signature.getValue()).append(")")
		.append("Service(").append(SAPServiceType.values()[service.ordinal()]).append(")")
		.append("SoftwareRevision(").append(softwareRevision.getValue()).append(")")
		.append("UserName(").append(userName).append(")")
		//.append("Password(").append(password).append(")")
		//.append("NewPassword(").append(newPassword).append(")")
		.append("RealHost(").append(realHost).append(")");
		return strBd.toString();
	}
}

