package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRANSPARENCY_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114989;

	private BV_TRANSPARENCY_EXEMPTION_Enum PreTradeAppliedWaiver = BV_TRANSPARENCY_EXEMPTION_Enum.BV_TRANSPARENCY_EXEMPTION_None;
	private BV_WAIVER_INDICATOR_Enum PreTradeWaiverIndicator = BV_WAIVER_INDICATOR_Enum.BV_WAIVER_INDICATOR_None;
	private BV_PRE_TRADE_PUBLISH_FLAG_Enum PreTradePublishFlag = BV_PRE_TRADE_PUBLISH_FLAG_Enum.BV_PRE_TRADE_PUBLISH_FLAG_None;
	private TI_POST_TRADE_DEFERRAL_Enum PostTradeDeferral = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;
	private TI_POST_TRADE_DEFERRAL_Enum PostTradePublishFlag = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;
	private TI_POST_TRADE_DEFERRAL_Enum LimitedPostTradeDeferral = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;
	private TI_POST_TRADE_DEFERRAL_Enum SuperPostTradeDeferral = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;

	public BV_TRANSPARENCY_INFO()
	{
	}

	public BV_TRANSPARENCY_EXEMPTION_Enum getPreTradeAppliedWaiver()
	{
		return PreTradeAppliedWaiver;
	}
	public void setPreTradeAppliedWaiver(BV_TRANSPARENCY_EXEMPTION_Enum value)
	{
		PreTradeAppliedWaiver = value;
	}
	public BV_WAIVER_INDICATOR_Enum getPreTradeWaiverIndicator()
	{
		return PreTradeWaiverIndicator;
	}
	public void setPreTradeWaiverIndicator(BV_WAIVER_INDICATOR_Enum value)
	{
		PreTradeWaiverIndicator = value;
	}
	public BV_PRE_TRADE_PUBLISH_FLAG_Enum getPreTradePublishFlag()
	{
		return PreTradePublishFlag;
	}
	public void setPreTradePublishFlag(BV_PRE_TRADE_PUBLISH_FLAG_Enum value)
	{
		PreTradePublishFlag = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getPostTradeDeferral()
	{
		return PostTradeDeferral;
	}
	public void setPostTradeDeferral(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		PostTradeDeferral = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getPostTradePublishFlag()
	{
		return PostTradePublishFlag;
	}
	public void setPostTradePublishFlag(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		PostTradePublishFlag = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getLimitedPostTradeDeferral()
	{
		return LimitedPostTradeDeferral;
	}
	public void setLimitedPostTradeDeferral(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		LimitedPostTradeDeferral = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getSuperPostTradeDeferral()
	{
		return SuperPostTradeDeferral;
	}
	public void setSuperPostTradeDeferral(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		SuperPostTradeDeferral = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		PreTradeAppliedWaiver = PreTradeAppliedWaiver.getEnum(byteBuffer.readInt());
		PreTradeWaiverIndicator = PreTradeWaiverIndicator.getEnum(byteBuffer.readInt());
		PreTradePublishFlag = PreTradePublishFlag.getEnum(byteBuffer.readInt());
		PostTradeDeferral = PostTradeDeferral.getEnum(byteBuffer.readInt());
		PostTradePublishFlag = PostTradePublishFlag.getEnum(byteBuffer.readInt());
		LimitedPostTradeDeferral = LimitedPostTradeDeferral.getEnum(byteBuffer.readInt());
		SuperPostTradeDeferral = SuperPostTradeDeferral.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(PreTradeAppliedWaiver.getValue());
		byteBuffer.writeInt(PreTradeWaiverIndicator.getValue());
		byteBuffer.writeInt(PreTradePublishFlag.getValue());
		byteBuffer.writeInt(PostTradeDeferral.getValue());
		byteBuffer.writeInt(PostTradePublishFlag.getValue());
		byteBuffer.writeInt(LimitedPostTradeDeferral.getValue());
		byteBuffer.writeInt(SuperPostTradeDeferral.getValue());

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
		stringBuilder.append("BV_TRANSPARENCY_INFO::");
		stringBuilder.append("PreTradeAppliedWaiver(").append(PreTradeAppliedWaiver).append(")");
		stringBuilder.append("PreTradeWaiverIndicator(").append(PreTradeWaiverIndicator).append(")");
		stringBuilder.append("PreTradePublishFlag(").append(PreTradePublishFlag).append(")");
		stringBuilder.append("PostTradeDeferral(").append(PostTradeDeferral).append(")");
		stringBuilder.append("PostTradePublishFlag(").append(PostTradePublishFlag).append(")");
		stringBuilder.append("LimitedPostTradeDeferral(").append(LimitedPostTradeDeferral).append(")");
		stringBuilder.append("SuperPostTradeDeferral(").append(SuperPostTradeDeferral).append(")");
		return stringBuilder.toString();
	}
}
