package com.mtsmarkets.sdp.sap;


import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SAPLogonReq extends SAPMessage 
{
	public static final int MSG_TYPE = 201;

	
	protected ULong reqId = new ULong(0);
	protected ULong protocolRevision = new ULong(0);
	protected ULong signature = new ULong(0);
	protected SAPServiceType service = SAPServiceType.TXN_INFO_PRIV;
	protected ULong softwareRevision = new ULong(0);
	protected String userName = "";
	protected String password = "";
	protected String newPassword = "";
	

	public SAPLogonReq()
	{
		super(new SAPHeader(MSG_TYPE));
	}
	
	public SAPLogonReq(SAPHeader sapHeader)
	{
		super(sapHeader);	
	}

	protected SAPLogonReq(int msgType)
	{
		super(new SAPHeader(msgType));
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		reqId.setValue(byteBuff.readInt());
		protocolRevision.setValue(byteBuff.readInt());		
		signature.setValue(byteBuff.readInt());
		service = SAPServiceType.values()[byteBuff.readInt()];
		softwareRevision.setValue(byteBuff.readInt());		
		userName = byteBuff.readString();
		password = byteBuff.readString();
		newPassword = byteBuff.readString();		
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception
	{
		int init = byteBuff.getByteBuff().position();

		// header pdu
		sapHeader.writeXDR(byteBuff);

		// body pdu
		byteBuff.writeInt((int) reqId.getValue());
		byteBuff.writeInt((int) protocolRevision.getValue());
		byteBuff.writeInt((int) signature.getValue());
		byteBuff.writeInt(service.ordinal());
		byteBuff.writeInt((int) softwareRevision.getValue());
		byteBuff.writeString(userName);
		byteBuff.writeString(password);
		byteBuff.writeString(newPassword);

		return byteBuff.getByteBuff().position() - init;

	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SAPLogonReq::")
		.append("MsgType(").append(getMessageType()).append(")")
		.append("ReqID(").append(reqId.getValue()).append(")")
		.append("ProtocolRevision(").append(protocolRevision.getValue()).append(")")
		.append("Signature(").append(signature.getValue()).append(")")
		.append("Service(").append(service).append(")")
		.append("SoftwareRevision(").append(softwareRevision.getValue()).append(")")
		.append("UserName(").append(userName).append(")");
		//.append("Password(").append(password).append(")")
		//.append("NewPassword(").append(newPassword).append(")");
		return str.toString();
	}

	public ULong getReqId() {
		return reqId;
	}

	public void setReqId(ULong reqId) {
		this.reqId = reqId;
	}

	public ULong getProtocolRevision() {
		return protocolRevision;
	}

	public void setProtocolRevision(ULong protocolRevision) {
		this.protocolRevision = protocolRevision;
	}

	public ULong getSignature() {
		return signature;
	}

	public void setSignature(ULong signature) {
		this.signature = signature;
	}

	public SAPServiceType getService() {
		return service;
	}

	public void setService(SAPServiceType service) {
		this.service = service;
	}

	public ULong getSoftwareRevision() {
		return softwareRevision;
	}

	public void setSoftwareRevision(ULong softwareRevision) {
		this.softwareRevision = softwareRevision;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}

