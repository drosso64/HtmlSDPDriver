package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA extends SMPMessage
{
	public static final long CLASS_ID = 114992;

	private short AssetClassNum = 0;
	private BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_ASSET[] AssetClass = new BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_ASSET[100];
	private short CurrencyNum = 0;
	private BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_CURRENCY[] CurrencyList = new BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_CURRENCY[100];
	private BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_RESIDUAL_MATURITY ResidualMaturity = new BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_RESIDUAL_MATURITY();
	private BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_SIZE Size = new BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_SIZE();
	private BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_DV01 DV01 = new BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_DV01();
	private BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_EXEC_TIME ExecutionTimeUTC = new BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_EXEC_TIME();
	private BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_BV_COMPOSITE BVComposite = new BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_BV_COMPOSITE();

	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA()
	{
		for (int i=0; i < AssetClass.length; ++i)
		{
			AssetClass[i] = new BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_ASSET();
		}
		for (int i=0; i < CurrencyList.length; ++i)
		{
			CurrencyList[i] = new BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_CURRENCY();
		}
	}

	public short getAssetClassNum()
	{
		return AssetClassNum;
	}
	public void setAssetClassNum(short value)
	{
		AssetClassNum = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_ASSET[] getAssetClass()
	{
		return AssetClass;
	}
	public void setAssetClass(BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_ASSET[] value)
	{
		AssetClass = value;
	}
	public short getCurrencyNum()
	{
		return CurrencyNum;
	}
	public void setCurrencyNum(short value)
	{
		CurrencyNum = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_CURRENCY[] getCurrencyList()
	{
		return CurrencyList;
	}
	public void setCurrencyList(BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_CURRENCY[] value)
	{
		CurrencyList = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_RESIDUAL_MATURITY getResidualMaturity()
	{
		return ResidualMaturity;
	}
	public void setResidualMaturity(BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_RESIDUAL_MATURITY value)
	{
		ResidualMaturity = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_SIZE getSize()
	{
		return Size;
	}
	public void setSize(BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_SIZE value)
	{
		Size = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_DV01 getDV01()
	{
		return DV01;
	}
	public void setDV01(BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_DV01 value)
	{
		DV01 = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_EXEC_TIME getExecutionTimeUTC()
	{
		return ExecutionTimeUTC;
	}
	public void setExecutionTimeUTC(BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_EXEC_TIME value)
	{
		ExecutionTimeUTC = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_BV_COMPOSITE getBVComposite()
	{
		return BVComposite;
	}
	public void setBVComposite(BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_BV_COMPOSITE value)
	{
		BVComposite = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		AssetClassNum = (short)byteBuffer.readInt();
		for (int i=0; i < AssetClass.length; ++i)
		{
			AssetClass[i].readXDR(byteBuffer);
		}
		CurrencyNum = (short)byteBuffer.readInt();
		for (int i=0; i < CurrencyList.length; ++i)
		{
			CurrencyList[i].readXDR(byteBuffer);
		}
		ResidualMaturity.readXDR(byteBuffer);
		Size.readXDR(byteBuffer);
		DV01.readXDR(byteBuffer);
		ExecutionTimeUTC.readXDR(byteBuffer);
		BVComposite.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(AssetClassNum & 0xFFFFL));
		for (int i=0; i < AssetClass.length; ++i)
		{
			AssetClass[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt((int)(CurrencyNum & 0xFFFFL));
		for (int i=0; i < CurrencyList.length; ++i)
		{
			CurrencyList[i].writeXDR(byteBuffer);
		}
		ResidualMaturity.writeXDR(byteBuffer);
		Size.writeXDR(byteBuffer);
		DV01.writeXDR(byteBuffer);
		ExecutionTimeUTC.writeXDR(byteBuffer);
		BVComposite.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA::");
		stringBuilder.append("AssetClassNum(").append(AssetClassNum).append(")");
		for (int i=0; i < AssetClass.length; ++i)
		{
			stringBuilder.append("AssetClass[").append(i).append("](").append(AssetClass[i].toString()).append(")");
		}
		stringBuilder.append("CurrencyNum(").append(CurrencyNum).append(")");
		for (int i=0; i < CurrencyList.length; ++i)
		{
			stringBuilder.append("CurrencyList[").append(i).append("](").append(CurrencyList[i].toString()).append(")");
		}
		stringBuilder.append("ResidualMaturity(").append(ResidualMaturity.toString()).append(")");
		stringBuilder.append("Size(").append(Size.toString()).append(")");
		stringBuilder.append("DV01(").append(DV01.toString()).append(")");
		stringBuilder.append("ExecutionTimeUTC(").append(ExecutionTimeUTC.toString()).append(")");
		stringBuilder.append("BVComposite(").append(BVComposite.toString()).append(")");
		return stringBuilder.toString();
	}
}
