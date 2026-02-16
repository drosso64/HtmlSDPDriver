package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADE_FUTURE_ACCOUNT_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410009;

	private long AccountId = 0;
	private long MemberId = 0;
	private String ExchangeMemberId = "";
	private String ExchangeTraderId = "";
	private long AutoApprovalRuleId = 0;

	public BV_TRADE_FUTURE_ACCOUNT_INFO()
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
	public String getExchangeMemberId()
	{
		return ExchangeMemberId;
	}
	public void setExchangeMemberId(String value)
	{
		ExchangeMemberId = value;
	}
	public String getExchangeTraderId()
	{
		return ExchangeTraderId;
	}
	public void setExchangeTraderId(String value)
	{
		ExchangeTraderId = value;
	}
	public long getAutoApprovalRuleId()
	{
		return AutoApprovalRuleId;
	}
	public void setAutoApprovalRuleId(long value)
	{
		AutoApprovalRuleId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		AccountId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		ExchangeMemberId = byteBuffer.readString();
		ExchangeTraderId = byteBuffer.readString();
		AutoApprovalRuleId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(AccountId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(ExchangeMemberId);
		byteBuffer.writeString(ExchangeTraderId);
		byteBuffer.writeInt((int)(AutoApprovalRuleId & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_TRADE_FUTURE_ACCOUNT_INFO::");
		stringBuilder.append("AccountId(").append(AccountId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("ExchangeMemberId(").append(ExchangeMemberId).append(")");
		stringBuilder.append("ExchangeTraderId(").append(ExchangeTraderId).append(")");
		stringBuilder.append("AutoApprovalRuleId(").append(AutoApprovalRuleId).append(")");
		return stringBuilder.toString();
	}
}
