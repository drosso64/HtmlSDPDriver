package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPLogonTokenReq extends SAPLogonReq
{
	public static final int  MSG_TYPE = 250;

	protected String realHost = "";

	public SAPLogonTokenReq()
	{
		super(MSG_TYPE);
	}
    
    public SAPLogonTokenReq(SAPHeader sapHeader)
	{
		super(sapHeader);	
	}

	protected SAPLogonTokenReq(int msgType)
	{
		super(new SAPHeader(msgType));
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		super.readBodyXDR(byteBuff);
		//realHost = byteBuff.readString();		
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception
	{
		int init = byteBuff.getByteBuff().position();
		super.writeXDR(byteBuff);
		//byteBuff.writeString(realHost);
		return byteBuff.getByteBuff().position() - init;
	}

	@Override
	public String toString()
	{
		StringBuilder strBd = new StringBuilder()
		.append("SAPLogonTokenReq::")
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

	public String getRealHost() {

		return realHost;

	}

	public void setRealHost(String realHost) {

		this.realHost = realHost;

	}

}

