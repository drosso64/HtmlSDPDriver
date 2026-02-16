package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_RECOGNIZED_SIGNATURE extends SMPMessage
{
	public static final long CLASS_ID = 170030;

	private short PlatformId = 0;
	private long Signature = 0;
	private long MinVersion = 0;
	private long MaxVersion = 0;
	private String Description = "";
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long LastUpdateDate = 0;
	private long LastUpdateTime = 0;

	public DF_TI_RECOGNIZED_SIGNATURE()
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
	public long getSignature()
	{
		return Signature;
	}
	public void setSignature(long value)
	{
		Signature = value;
	}
	public long getMinVersion()
	{
		return MinVersion;
	}
	public void setMinVersion(long value)
	{
		MinVersion = value;
	}
	public long getMaxVersion()
	{
		return MaxVersion;
	}
	public void setMaxVersion(long value)
	{
		MaxVersion = value;
	}
	public String getDescription()
	{
		return Description;
	}
	public void setDescription(String value)
	{
		Description = value;
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
		Signature = (long)byteBuffer.readInt();
		MinVersion = (long)byteBuffer.readInt();
		MaxVersion = (long)byteBuffer.readInt();
		Description = byteBuffer.readString();
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
		byteBuffer.writeInt((int)(Signature & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MinVersion & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MaxVersion & 0xFFFFFFFFL));
		byteBuffer.writeString(Description);
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
		stringBuilder.append("DF_TI_RECOGNIZED_SIGNATURE::");
		stringBuilder.append("PlatformId(").append(PlatformId).append(")");
		stringBuilder.append("Signature(").append(Signature).append(")");
		stringBuilder.append("MinVersion(").append(MinVersion).append(")");
		stringBuilder.append("MaxVersion(").append(MaxVersion).append(")");
		stringBuilder.append("Description(").append(Description).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("LastUpdateDate(").append(LastUpdateDate).append(")");
		stringBuilder.append("LastUpdateTime(").append(LastUpdateTime).append(")");
		return stringBuilder.toString();
	}
}
