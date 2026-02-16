package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_CONNECTION_INFO extends SMPMessage
{
	public static final long CLASS_ID = 170013;

	private long MemberId = 0;
	private long TraderId = 0;
	private long ServiceId = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;
	private DF_TRADER_CONNEC_STATUS_Enum ConnectionStatus = DF_TRADER_CONNEC_STATUS_Enum.DF_TRADER_CONNEC_STATUS_LogOn;
	private long Signature = 0;
	private long Version = 0;
	private TI_NETWORK_TYPE_Enum NetworkType = TI_NETWORK_TYPE_Enum.TI_NETWORK_TYPE_Undefined;
	private String SourceNetwork = "";
	private long APSID = 0;
	private String AuthorizationToken = "";
	private TI_LOGON_INFO_Enum LogonInfo = TI_LOGON_INFO_Enum.TI_LOGON_INFO_NotAvailable;
	private TI_ACL_TYPE_Enum AclType = TI_ACL_TYPE_Enum.TI_ACL_TYPE_NoAccess;
	private long NonCompliantAttempts = 0;

	public DF_TI_CONNECTION_INFO()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}
	public long getServiceId()
	{
		return ServiceId;
	}
	public void setServiceId(long value)
	{
		ServiceId = value;
	}
	public long getUpdateDate()
	{
		return UpdateDate;
	}
	public void setUpdateDate(long value)
	{
		UpdateDate = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}
	public DF_TRADER_CONNEC_STATUS_Enum getConnectionStatus()
	{
		return ConnectionStatus;
	}
	public void setConnectionStatus(DF_TRADER_CONNEC_STATUS_Enum value)
	{
		ConnectionStatus = value;
	}
	public long getSignature()
	{
		return Signature;
	}
	public void setSignature(long value)
	{
		Signature = value;
	}
	public long getVersion()
	{
		return Version;
	}
	public void setVersion(long value)
	{
		Version = value;
	}
	public TI_NETWORK_TYPE_Enum getNetworkType()
	{
		return NetworkType;
	}
	public void setNetworkType(TI_NETWORK_TYPE_Enum value)
	{
		NetworkType = value;
	}
	public String getSourceNetwork()
	{
		return SourceNetwork;
	}
	public void setSourceNetwork(String value)
	{
		SourceNetwork = value;
	}
	public long getAPSID()
	{
		return APSID;
	}
	public void setAPSID(long value)
	{
		APSID = value;
	}
	public String getAuthorizationToken()
	{
		return AuthorizationToken;
	}
	public void setAuthorizationToken(String value)
	{
		AuthorizationToken = value;
	}
	public TI_LOGON_INFO_Enum getLogonInfo()
	{
		return LogonInfo;
	}
	public void setLogonInfo(TI_LOGON_INFO_Enum value)
	{
		LogonInfo = value;
	}
	public TI_ACL_TYPE_Enum getAclType()
	{
		return AclType;
	}
	public void setAclType(TI_ACL_TYPE_Enum value)
	{
		AclType = value;
	}
	public long getNonCompliantAttempts()
	{
		return NonCompliantAttempts;
	}
	public void setNonCompliantAttempts(long value)
	{
		NonCompliantAttempts = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		ServiceId = (long)byteBuffer.readInt();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
		ConnectionStatus = ConnectionStatus.getEnum(byteBuffer.readInt());
		Signature = (long)byteBuffer.readInt();
		Version = (long)byteBuffer.readInt();
		NetworkType = NetworkType.getEnum(byteBuffer.readInt());
		SourceNetwork = byteBuffer.readString();
		APSID = (long)byteBuffer.readInt();
		AuthorizationToken = byteBuffer.readString();
		LogonInfo = LogonInfo.getEnum(byteBuffer.readInt());
		AclType = AclType.getEnum(byteBuffer.readInt());
		NonCompliantAttempts = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ServiceId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeInt(ConnectionStatus.getValue());
		byteBuffer.writeInt((int)(Signature & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(Version & 0xFFFFFFFFL));
		byteBuffer.writeInt(NetworkType.getValue());
		byteBuffer.writeString(SourceNetwork);
		byteBuffer.writeInt((int)(APSID & 0xFFFFFFFFL));
		byteBuffer.writeString(AuthorizationToken);
		byteBuffer.writeInt(LogonInfo.getValue());
		byteBuffer.writeInt(AclType.getValue());
		byteBuffer.writeInt((int)(NonCompliantAttempts & 0xFFFFFFFFL));

		return byteBuffer.position() - init;
	}
	@Override
	public long getSMPClassId()
	{
		return CLASS_ID;
	}
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(1024);
		stringBuilder.append("DF_TI_CONNECTION_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("ServiceId(").append(ServiceId).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("ConnectionStatus(").append(ConnectionStatus).append(")");
		stringBuilder.append("Signature(").append(Signature).append(")");
		stringBuilder.append("Version(").append(Version).append(")");
		stringBuilder.append("NetworkType(").append(NetworkType).append(")");
		stringBuilder.append("SourceNetwork(").append(SourceNetwork).append(")");
		stringBuilder.append("APSID(").append(APSID).append(")");
		stringBuilder.append("AuthorizationToken(").append(AuthorizationToken).append(")");
		stringBuilder.append("LogonInfo(").append(LogonInfo).append(")");
		stringBuilder.append("AclType(").append(AclType).append(")");
		stringBuilder.append("NonCompliantAttempts(").append(NonCompliantAttempts).append(")");
		return stringBuilder.toString();
	}
}
