package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_ACL_MEMBER_CONNECTION extends SMPMessage
{
	public static final long CLASS_ID = 170034;

	private short PlatformId = 0;
	private long MemberId = 0;
	private TI_ACL_TYPE_Enum AclType = TI_ACL_TYPE_Enum.TI_ACL_TYPE_NoAccess;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long LastUpdateDate = 0;
	private long LastUpdateTime = 0;

	public DF_TI_ACL_MEMBER_CONNECTION()
	{
	}

	public short getPlatformId()
	{
		return PlatformId;
	}
	public void setPlatformId(short value)
	{
		PlatformId = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public TI_ACL_TYPE_Enum getAclType()
	{
		return AclType;
	}
	public void setAclType(TI_ACL_TYPE_Enum value)
	{
		AclType = value;
	}
	public long getCreationDate()
	{
		return CreationDate;
	}
	public void setCreationDate(long value)
	{
		CreationDate = value;
	}
	public long getCreationTime()
	{
		return CreationTime;
	}
	public void setCreationTime(long value)
	{
		CreationTime = value;
	}
	public long getLastUpdateDate()
	{
		return LastUpdateDate;
	}
	public void setLastUpdateDate(long value)
	{
		LastUpdateDate = value;
	}
	public long getLastUpdateTime()
	{
		return LastUpdateTime;
	}
	public void setLastUpdateTime(long value)
	{
		LastUpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		PlatformId = (short)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		AclType = AclType.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		LastUpdateDate = (long)byteBuffer.readInt();
		LastUpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(PlatformId & 0xFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(AclType.getValue());
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(LastUpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(LastUpdateTime);

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
		stringBuilder.append("DF_TI_ACL_MEMBER_CONNECTION::");
		stringBuilder.append("PlatformId(").append(PlatformId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("AclType(").append(AclType).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("LastUpdateDate(").append(LastUpdateDate).append(")");
		stringBuilder.append("LastUpdateTime(").append(LastUpdateTime).append(")");
		return stringBuilder.toString();
	}
}
