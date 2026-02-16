package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_DEAL_PMS extends SMPMessage
{
	public static final long CLASS_ID = 114300;

	private BV_DEAL_INFO Deal = new BV_DEAL_INFO();
	private BV_RFCQ_LEG_TRADING_LEVEL[] RfcqBook = new BV_RFCQ_LEG_TRADING_LEVEL[30];
	private short AccrualDays = 0;
	private double IndexRatio = 0;
	private double RemainingQty = 0;
	private double RemainingNominalQty = 0;
	private double CumQty = 0;
	private double CumNominalQty = 0;
	private double AveragePrice = 0;
	private long VoiceListId = 0;
	private TI_FLAG_Enum AutoExecutionFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_BEST_TRADING_INFO BVBestBid = new BV_BEST_TRADING_INFO();
	private BV_BEST_TRADING_INFO BVBestAsk = new BV_BEST_TRADING_INFO();
	private double BVBestMidPrice = 0;
	private double BVBestMidYield = 0;
	private BV_VALUE BVBestMidYTW = new BV_VALUE();
	private TI_FLAG_Enum BVBestMidValidityFg = TI_FLAG_Enum.TI_FLAG_No;
	private String BenchmarkISINCode = "";
	private double BenchmarkSpreadValue = 0;
	private TI_FLAG_Enum PreAgreedFg = TI_FLAG_Enum.TI_FLAG_No;
	private String UserInfo1 = "";
	private String UserInfo2 = "";
	private TI_FLAG_Enum DLTSettlementFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_DEAL_PMS()
	{
		for (int i=0; i < RfcqBook.length; ++i)
		{
			RfcqBook[i] = new BV_RFCQ_LEG_TRADING_LEVEL();
		}
	}

	public BV_DEAL_INFO getDeal()
	{
		return Deal;
	}
	public void setDeal(BV_DEAL_INFO value)
	{
		Deal = value;
	}
	public BV_RFCQ_LEG_TRADING_LEVEL[] getRfcqBook()
	{
		return RfcqBook;
	}
	public void setRfcqBook(BV_RFCQ_LEG_TRADING_LEVEL[] value)
	{
		RfcqBook = value;
	}
	public short getAccrualDays()
	{
		return AccrualDays;
	}
	public void setAccrualDays(short value)
	{
		AccrualDays = value;
	}
	public double getIndexRatio()
	{
		return IndexRatio;
	}
	public void setIndexRatio(double value)
	{
		IndexRatio = value;
	}
	public double getRemainingQty()
	{
		return RemainingQty;
	}
	public void setRemainingQty(double value)
	{
		RemainingQty = value;
	}
	public double getRemainingNominalQty()
	{
		return RemainingNominalQty;
	}
	public void setRemainingNominalQty(double value)
	{
		RemainingNominalQty = value;
	}
	public double getCumQty()
	{
		return CumQty;
	}
	public void setCumQty(double value)
	{
		CumQty = value;
	}
	public double getCumNominalQty()
	{
		return CumNominalQty;
	}
	public void setCumNominalQty(double value)
	{
		CumNominalQty = value;
	}
	public double getAveragePrice()
	{
		return AveragePrice;
	}
	public void setAveragePrice(double value)
	{
		AveragePrice = value;
	}
	public long getVoiceListId()
	{
		return VoiceListId;
	}
	public void setVoiceListId(long value)
	{
		VoiceListId = value;
	}
	public TI_FLAG_Enum getAutoExecutionFg()
	{
		return AutoExecutionFg;
	}
	public void setAutoExecutionFg(TI_FLAG_Enum value)
	{
		AutoExecutionFg = value;
	}
	public BV_BEST_TRADING_INFO getBVBestBid()
	{
		return BVBestBid;
	}
	public void setBVBestBid(BV_BEST_TRADING_INFO value)
	{
		BVBestBid = value;
	}
	public BV_BEST_TRADING_INFO getBVBestAsk()
	{
		return BVBestAsk;
	}
	public void setBVBestAsk(BV_BEST_TRADING_INFO value)
	{
		BVBestAsk = value;
	}
	public double getBVBestMidPrice()
	{
		return BVBestMidPrice;
	}
	public void setBVBestMidPrice(double value)
	{
		BVBestMidPrice = value;
	}
	public double getBVBestMidYield()
	{
		return BVBestMidYield;
	}
	public void setBVBestMidYield(double value)
	{
		BVBestMidYield = value;
	}
	public BV_VALUE getBVBestMidYTW()
	{
		return BVBestMidYTW;
	}
	public void setBVBestMidYTW(BV_VALUE value)
	{
		BVBestMidYTW = value;
	}
	public TI_FLAG_Enum getBVBestMidValidityFg()
	{
		return BVBestMidValidityFg;
	}
	public void setBVBestMidValidityFg(TI_FLAG_Enum value)
	{
		BVBestMidValidityFg = value;
	}
	public String getBenchmarkISINCode()
	{
		return BenchmarkISINCode;
	}
	public void setBenchmarkISINCode(String value)
	{
		BenchmarkISINCode = value;
	}
	public double getBenchmarkSpreadValue()
	{
		return BenchmarkSpreadValue;
	}
	public void setBenchmarkSpreadValue(double value)
	{
		BenchmarkSpreadValue = value;
	}
	public TI_FLAG_Enum getPreAgreedFg()
	{
		return PreAgreedFg;
	}
	public void setPreAgreedFg(TI_FLAG_Enum value)
	{
		PreAgreedFg = value;
	}
	public String getUserInfo1()
	{
		return UserInfo1;
	}
	public void setUserInfo1(String value)
	{
		UserInfo1 = value;
	}
	public String getUserInfo2()
	{
		return UserInfo2;
	}
	public void setUserInfo2(String value)
	{
		UserInfo2 = value;
	}
	public TI_FLAG_Enum getDLTSettlementFg()
	{
		return DLTSettlementFg;
	}
	public void setDLTSettlementFg(TI_FLAG_Enum value)
	{
		DLTSettlementFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Deal.readXDR(byteBuffer);
		for (int i=0; i < RfcqBook.length; ++i)
		{
			RfcqBook[i].readXDR(byteBuffer);
		}
		AccrualDays = (short)byteBuffer.readInt();
		IndexRatio = byteBuffer.readDouble();
		RemainingQty = byteBuffer.readDouble();
		RemainingNominalQty = byteBuffer.readDouble();
		CumQty = byteBuffer.readDouble();
		CumNominalQty = byteBuffer.readDouble();
		AveragePrice = byteBuffer.readDouble();
		VoiceListId = (long)byteBuffer.readInt();
		AutoExecutionFg = AutoExecutionFg.getEnum(byteBuffer.readInt());
		BVBestBid.readXDR(byteBuffer);
		BVBestAsk.readXDR(byteBuffer);
		BVBestMidPrice = byteBuffer.readDouble();
		BVBestMidYield = byteBuffer.readDouble();
		BVBestMidYTW.readXDR(byteBuffer);
		BVBestMidValidityFg = BVBestMidValidityFg.getEnum(byteBuffer.readInt());
		BenchmarkISINCode = byteBuffer.readString();
		BenchmarkSpreadValue = byteBuffer.readDouble();
		PreAgreedFg = PreAgreedFg.getEnum(byteBuffer.readInt());
		UserInfo1 = byteBuffer.readString();
		UserInfo2 = byteBuffer.readString();
		DLTSettlementFg = DLTSettlementFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Deal.writeXDR(byteBuffer);
		for (int i=0; i < RfcqBook.length; ++i)
		{
			RfcqBook[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt((int)(AccrualDays & 0xFFFFL));
		byteBuffer.writeDouble(IndexRatio);
		byteBuffer.writeDouble(RemainingQty);
		byteBuffer.writeDouble(RemainingNominalQty);
		byteBuffer.writeDouble(CumQty);
		byteBuffer.writeDouble(CumNominalQty);
		byteBuffer.writeDouble(AveragePrice);
		byteBuffer.writeInt((int)(VoiceListId & 0xFFFFFFFFL));
		byteBuffer.writeInt(AutoExecutionFg.getValue());
		BVBestBid.writeXDR(byteBuffer);
		BVBestAsk.writeXDR(byteBuffer);
		byteBuffer.writeDouble(BVBestMidPrice);
		byteBuffer.writeDouble(BVBestMidYield);
		BVBestMidYTW.writeXDR(byteBuffer);
		byteBuffer.writeInt(BVBestMidValidityFg.getValue());
		byteBuffer.writeString(BenchmarkISINCode);
		byteBuffer.writeDouble(BenchmarkSpreadValue);
		byteBuffer.writeInt(PreAgreedFg.getValue());
		byteBuffer.writeString(UserInfo1);
		byteBuffer.writeString(UserInfo2);
		byteBuffer.writeInt(DLTSettlementFg.getValue());

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
		stringBuilder.append("BV_DEAL_PMS::");
		stringBuilder.append("Deal(").append(Deal.toString()).append(")");
		for (int i=0; i < RfcqBook.length; ++i)
		{
			stringBuilder.append("RfcqBook[").append(i).append("](").append(RfcqBook[i].toString()).append(")");
		}
		stringBuilder.append("AccrualDays(").append(AccrualDays).append(")");
		stringBuilder.append("IndexRatio(").append(IndexRatio).append(")");
		stringBuilder.append("RemainingQty(").append(RemainingQty).append(")");
		stringBuilder.append("RemainingNominalQty(").append(RemainingNominalQty).append(")");
		stringBuilder.append("CumQty(").append(CumQty).append(")");
		stringBuilder.append("CumNominalQty(").append(CumNominalQty).append(")");
		stringBuilder.append("AveragePrice(").append(AveragePrice).append(")");
		stringBuilder.append("VoiceListId(").append(VoiceListId).append(")");
		stringBuilder.append("AutoExecutionFg(").append(AutoExecutionFg).append(")");
		stringBuilder.append("BVBestBid(").append(BVBestBid.toString()).append(")");
		stringBuilder.append("BVBestAsk(").append(BVBestAsk.toString()).append(")");
		stringBuilder.append("BVBestMidPrice(").append(BVBestMidPrice).append(")");
		stringBuilder.append("BVBestMidYield(").append(BVBestMidYield).append(")");
		stringBuilder.append("BVBestMidYTW(").append(BVBestMidYTW.toString()).append(")");
		stringBuilder.append("BVBestMidValidityFg(").append(BVBestMidValidityFg).append(")");
		stringBuilder.append("BenchmarkISINCode(").append(BenchmarkISINCode).append(")");
		stringBuilder.append("BenchmarkSpreadValue(").append(BenchmarkSpreadValue).append(")");
		stringBuilder.append("PreAgreedFg(").append(PreAgreedFg).append(")");
		stringBuilder.append("UserInfo1(").append(UserInfo1).append(")");
		stringBuilder.append("UserInfo2(").append(UserInfo2).append(")");
		stringBuilder.append("DLTSettlementFg(").append(DLTSettlementFg).append(")");
		return stringBuilder.toString();
	}
}
