package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410027;

	private TI_MSG_INFO RfcqReqMsgInfo = new TI_MSG_INFO();
	private long BuySideMemberId = 0;
	private String BuySideMemberCode = "";
	private String BuySideMemberDesc = "";
	private String BuySideMemberShortDesc = "";
	private short LegId = 0;
	private BV_PORTFOLIO_RFCQ_BUY_SIDE_LEG_SUMMARY LegInfo = new BV_PORTFOLIO_RFCQ_BUY_SIDE_LEG_SUMMARY();
	private BV_PORTFOLIO_RFCQ_PROVIDER_LEG_INFO[] ProviderInfo = new BV_PORTFOLIO_RFCQ_PROVIDER_LEG_INFO[10];

	public BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG_INFO()
	{
		for (int i=0; i < ProviderInfo.length; ++i)
		{
			ProviderInfo[i] = new BV_PORTFOLIO_RFCQ_PROVIDER_LEG_INFO();
		}
	}

	public TI_MSG_INFO getRfcqReqMsgInfo()
	{
		return RfcqReqMsgInfo;
	}
	public void setRfcqReqMsgInfo(TI_MSG_INFO value)
	{
		RfcqReqMsgInfo = value;
	}
	public long getBuySideMemberId()
	{
		return BuySideMemberId;
	}
	public void setBuySideMemberId(long value)
	{
		BuySideMemberId = value;
	}
	public String getBuySideMemberCode()
	{
		return BuySideMemberCode;
	}
	public void setBuySideMemberCode(String value)
	{
		BuySideMemberCode = value;
	}
	public String getBuySideMemberDesc()
	{
		return BuySideMemberDesc;
	}
	public void setBuySideMemberDesc(String value)
	{
		BuySideMemberDesc = value;
	}
	public String getBuySideMemberShortDesc()
	{
		return BuySideMemberShortDesc;
	}
	public void setBuySideMemberShortDesc(String value)
	{
		BuySideMemberShortDesc = value;
	}
	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public BV_PORTFOLIO_RFCQ_BUY_SIDE_LEG_SUMMARY getLegInfo()
	{
		return LegInfo;
	}
	public void setLegInfo(BV_PORTFOLIO_RFCQ_BUY_SIDE_LEG_SUMMARY value)
	{
		LegInfo = value;
	}
	public BV_PORTFOLIO_RFCQ_PROVIDER_LEG_INFO[] getProviderInfo()
	{
		return ProviderInfo;
	}
	public void setProviderInfo(BV_PORTFOLIO_RFCQ_PROVIDER_LEG_INFO[] value)
	{
		ProviderInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		RfcqReqMsgInfo.readXDR(byteBuffer);
		BuySideMemberId = (long)byteBuffer.readInt();
		BuySideMemberCode = byteBuffer.readString();
		BuySideMemberDesc = byteBuffer.readString();
		BuySideMemberShortDesc = byteBuffer.readString();
		LegId = (short)byteBuffer.readInt();
		LegInfo.readXDR(byteBuffer);
		for (int i=0; i < ProviderInfo.length; ++i)
		{
			ProviderInfo[i].readXDR(byteBuffer);
		}
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		RfcqReqMsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(BuySideMemberCode);
		byteBuffer.writeString(BuySideMemberDesc);
		byteBuffer.writeString(BuySideMemberShortDesc);
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		LegInfo.writeXDR(byteBuffer);
		for (int i=0; i < ProviderInfo.length; ++i)
		{
			ProviderInfo[i].writeXDR(byteBuffer);
		}

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG_INFO::");
		stringBuilder.append("RfcqReqMsgInfo(").append(RfcqReqMsgInfo.toString()).append(")");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("BuySideMemberCode(").append(BuySideMemberCode).append(")");
		stringBuilder.append("BuySideMemberDesc(").append(BuySideMemberDesc).append(")");
		stringBuilder.append("BuySideMemberShortDesc(").append(BuySideMemberShortDesc).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("LegInfo(").append(LegInfo.toString()).append(")");
		for (int i=0; i < ProviderInfo.length; ++i)
		{
			stringBuilder.append("ProviderInfo[").append(i).append("](").append(ProviderInfo[i].toString()).append(")");
		}
		return stringBuilder.toString();
	}
}
