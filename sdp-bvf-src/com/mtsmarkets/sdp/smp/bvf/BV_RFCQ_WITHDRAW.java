package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_WITHDRAW extends SMPMessage
{
	public static final long CLASS_ID = 114160;

	private long MemberId = 0;
	private long TraderId = 0;
	private BV_RFCQ_WITHDRAW_TYPE_Enum WithdrawType = BV_RFCQ_WITHDRAW_TYPE_Enum.BV_RFCQ_WITHDRAW_TYPE_Trader;
	private String UserData = "";
	private long UpdateTime = 0;

	public BV_RFCQ_WITHDRAW()
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
	public BV_RFCQ_WITHDRAW_TYPE_Enum getWithdrawType()
	{
		return WithdrawType;
	}
	public void setWithdrawType(BV_RFCQ_WITHDRAW_TYPE_Enum value)
	{
		WithdrawType = value;
	}
	public String getUserData()
	{
		return UserData;
	}
	public void setUserData(String value)
	{
		UserData = value;
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
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		WithdrawType = WithdrawType.getEnum(byteBuffer.readInt());
		UserData = byteBuffer.readString();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(WithdrawType.getValue());
		byteBuffer.writeString(UserData);
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
		stringBuilder.append("BV_RFCQ_WITHDRAW::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("WithdrawType(").append(WithdrawType).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
