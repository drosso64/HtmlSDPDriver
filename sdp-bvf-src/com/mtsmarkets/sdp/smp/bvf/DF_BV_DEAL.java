package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_DEAL extends SMPMessage
{
	public static final long CLASS_ID = 114701;

	private BV_DEAL DFDeal = new BV_DEAL();
	private TI_FLAG_Enum GuaranteedParticipationFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum StrikerRangeMatchingFg = TI_FLAG_Enum.TI_FLAG_No;
	private DF_BV_ALGO_INFO ProviderAlgoInfo = new DF_BV_ALGO_INFO();
	private DF_BV_ALGO_INFO AggressorAlgoInfo = new DF_BV_ALGO_INFO();

	public DF_BV_DEAL()
	{
	}

	public BV_DEAL getDFDeal()
	{
		return DFDeal;
	}
	public void setDFDeal(BV_DEAL value)
	{
		DFDeal = value;
	}
	public TI_FLAG_Enum getGuaranteedParticipationFg()
	{
		return GuaranteedParticipationFg;
	}
	public void setGuaranteedParticipationFg(TI_FLAG_Enum value)
	{
		GuaranteedParticipationFg = value;
	}
	public TI_FLAG_Enum getStrikerRangeMatchingFg()
	{
		return StrikerRangeMatchingFg;
	}
	public void setStrikerRangeMatchingFg(TI_FLAG_Enum value)
	{
		StrikerRangeMatchingFg = value;
	}
	public DF_BV_ALGO_INFO getProviderAlgoInfo()
	{
		return ProviderAlgoInfo;
	}
	public void setProviderAlgoInfo(DF_BV_ALGO_INFO value)
	{
		ProviderAlgoInfo = value;
	}
	public DF_BV_ALGO_INFO getAggressorAlgoInfo()
	{
		return AggressorAlgoInfo;
	}
	public void setAggressorAlgoInfo(DF_BV_ALGO_INFO value)
	{
		AggressorAlgoInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFDeal.readXDR(byteBuffer);
		GuaranteedParticipationFg = GuaranteedParticipationFg.getEnum(byteBuffer.readInt());
		StrikerRangeMatchingFg = StrikerRangeMatchingFg.getEnum(byteBuffer.readInt());
		ProviderAlgoInfo.readXDR(byteBuffer);
		AggressorAlgoInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFDeal.writeXDR(byteBuffer);
		byteBuffer.writeInt(GuaranteedParticipationFg.getValue());
		byteBuffer.writeInt(StrikerRangeMatchingFg.getValue());
		ProviderAlgoInfo.writeXDR(byteBuffer);
		AggressorAlgoInfo.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_DEAL::");
		stringBuilder.append("DFDeal(").append(DFDeal.toString()).append(")");
		stringBuilder.append("GuaranteedParticipationFg(").append(GuaranteedParticipationFg).append(")");
		stringBuilder.append("StrikerRangeMatchingFg(").append(StrikerRangeMatchingFg).append(")");
		stringBuilder.append("ProviderAlgoInfo(").append(ProviderAlgoInfo.toString()).append(")");
		stringBuilder.append("AggressorAlgoInfo(").append(AggressorAlgoInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
