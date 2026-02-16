package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_EUREX_ACCOUNT extends SMPMessage
{
	public static final long CLASS_ID = 400071;

	private long AccountId = 0;
	private long MemberId = 0;
	private String EurexMemberId = "";
	private String EurexTraderId = "";
	private long AutoApprovalRuleId = 0;
	private TI_FLAG_Enum DefaultFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_EUREX_ACCOUNT_STATUS_Enum Status = BV_EUREX_ACCOUNT_STATUS_Enum.BV_EUREX_ACCOUNT_STATUS_Active;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_EUREX_ACCOUNT()
	{
	}

	public long getAccountId()
	{
		return AccountId;
	}
	public void setAccountId(long value)
	{
		AccountId = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public String getEurexMemberId()
	{
		return EurexMemberId;
	}
	public void setEurexMemberId(String value)
	{
		EurexMemberId = value;
	}
	public String getEurexTraderId()
	{
		return EurexTraderId;
	}
	public void setEurexTraderId(String value)
	{
		EurexTraderId = value;
	}
	public long getAutoApprovalRuleId()
	{
		return AutoApprovalRuleId;
	}
	public void setAutoApprovalRuleId(long value)
	{
		AutoApprovalRuleId = value;
	}
	public TI_FLAG_Enum getDefaultFg()
	{
		return DefaultFg;
	}
	public void setDefaultFg(TI_FLAG_Enum value)
	{
		DefaultFg = value;
	}
	public BV_EUREX_ACCOUNT_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_EUREX_ACCOUNT_STATUS_Enum value)
	{
		Status = value;
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		AccountId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		EurexMemberId = byteBuffer.readString();
		EurexTraderId = byteBuffer.readString();
		AutoApprovalRuleId = (long)byteBuffer.readInt();
		DefaultFg = DefaultFg.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(AccountId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(EurexMemberId);
		byteBuffer.writeString(EurexTraderId);
		byteBuffer.writeInt((int)(AutoApprovalRuleId & 0xFFFFFFFFL));
		byteBuffer.writeInt(DefaultFg.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("BV_EUREX_ACCOUNT::");
		stringBuilder.append("AccountId(").append(AccountId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("EurexMemberId(").append(EurexMemberId).append(")");
		stringBuilder.append("EurexTraderId(").append(EurexTraderId).append(")");
		stringBuilder.append("AutoApprovalRuleId(").append(AutoApprovalRuleId).append(")");
		stringBuilder.append("DefaultFg(").append(DefaultFg).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
