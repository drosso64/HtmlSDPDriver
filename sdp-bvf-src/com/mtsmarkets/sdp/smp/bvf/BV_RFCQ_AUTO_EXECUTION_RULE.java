package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_RULE extends SMPMessage
{
	public static final long CLASS_ID = 400037;

	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private short ExecTraderListNum = 0;
	private BV_AUTO_EXECUTION_RULE_EXEC_TRADER[] ExecTraderList = new BV_AUTO_EXECUTION_RULE_EXEC_TRADER[100];
	private long DefaultAutoExecutionTraderId = 0;
	private String DefaultAutoExecutionTraderName = "";
	private long RuleId = 0;
	private String RuleName = "";
	private BV_RFCQ_AUTO_EXECUTION_SETTLEMENT_INFO SettlementInfo = new BV_RFCQ_AUTO_EXECUTION_SETTLEMENT_INFO();
	private BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA EligibilityCriteria = new BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA();
	private BV_RFCQ_AUTO_EXECUTION_DEALER_SELECTION_CRITERIA DealerSelectionCriteria = new BV_RFCQ_AUTO_EXECUTION_DEALER_SELECTION_CRITERIA();
	private BV_RFCQ_AUTO_EXECUTION_EXECUTION_CRITERIA ExecutionCriteria = new BV_RFCQ_AUTO_EXECUTION_EXECUTION_CRITERIA();
	private BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Enum Event = BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Enum.BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Enable;
	private BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Enum Status = BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Enum.BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Enabled;
	private String UserData = "";
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_RFCQ_AUTO_EXECUTION_RULE()
	{
		for (int i=0; i < ExecTraderList.length; ++i)
		{
			ExecTraderList[i] = new BV_AUTO_EXECUTION_RULE_EXEC_TRADER();
		}
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
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public short getExecTraderListNum()
	{
		return ExecTraderListNum;
	}
	public void setExecTraderListNum(short value)
	{
		ExecTraderListNum = value;
	}
	public BV_AUTO_EXECUTION_RULE_EXEC_TRADER[] getExecTraderList()
	{
		return ExecTraderList;
	}
	public void setExecTraderList(BV_AUTO_EXECUTION_RULE_EXEC_TRADER[] value)
	{
		ExecTraderList = value;
	}
	public long getDefaultAutoExecutionTraderId()
	{
		return DefaultAutoExecutionTraderId;
	}
	public void setDefaultAutoExecutionTraderId(long value)
	{
		DefaultAutoExecutionTraderId = value;
	}
	public String getDefaultAutoExecutionTraderName()
	{
		return DefaultAutoExecutionTraderName;
	}
	public void setDefaultAutoExecutionTraderName(String value)
	{
		DefaultAutoExecutionTraderName = value;
	}
	public long getRuleId()
	{
		return RuleId;
	}
	public void setRuleId(long value)
	{
		RuleId = value;
	}
	public String getRuleName()
	{
		return RuleName;
	}
	public void setRuleName(String value)
	{
		RuleName = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_SETTLEMENT_INFO getSettlementInfo()
	{
		return SettlementInfo;
	}
	public void setSettlementInfo(BV_RFCQ_AUTO_EXECUTION_SETTLEMENT_INFO value)
	{
		SettlementInfo = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA getEligibilityCriteria()
	{
		return EligibilityCriteria;
	}
	public void setEligibilityCriteria(BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA value)
	{
		EligibilityCriteria = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_DEALER_SELECTION_CRITERIA getDealerSelectionCriteria()
	{
		return DealerSelectionCriteria;
	}
	public void setDealerSelectionCriteria(BV_RFCQ_AUTO_EXECUTION_DEALER_SELECTION_CRITERIA value)
	{
		DealerSelectionCriteria = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_EXECUTION_CRITERIA getExecutionCriteria()
	{
		return ExecutionCriteria;
	}
	public void setExecutionCriteria(BV_RFCQ_AUTO_EXECUTION_EXECUTION_CRITERIA value)
	{
		ExecutionCriteria = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Enum value)
	{
		Status = value;
	}
	public String getUserData()
	{
		return UserData;
	}
	public void setUserData(String value)
	{
		UserData = value;
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
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		ExecTraderListNum = (short)byteBuffer.readInt();
		for (int i=0; i < ExecTraderList.length; ++i)
		{
			ExecTraderList[i].readXDR(byteBuffer);
		}
		DefaultAutoExecutionTraderId = (long)byteBuffer.readInt();
		DefaultAutoExecutionTraderName = byteBuffer.readString();
		RuleId = (long)byteBuffer.readInt();
		RuleName = byteBuffer.readString();
		SettlementInfo.readXDR(byteBuffer);
		EligibilityCriteria.readXDR(byteBuffer);
		DealerSelectionCriteria.readXDR(byteBuffer);
		ExecutionCriteria.readXDR(byteBuffer);
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		UserData = byteBuffer.readString();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt((int)(ExecTraderListNum & 0xFFFFL));
		for (int i=0; i < ExecTraderList.length; ++i)
		{
			ExecTraderList[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt((int)(DefaultAutoExecutionTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(DefaultAutoExecutionTraderName);
		byteBuffer.writeInt((int)(RuleId & 0xFFFFFFFFL));
		byteBuffer.writeString(RuleName);
		SettlementInfo.writeXDR(byteBuffer);
		EligibilityCriteria.writeXDR(byteBuffer);
		DealerSelectionCriteria.writeXDR(byteBuffer);
		ExecutionCriteria.writeXDR(byteBuffer);
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeString(UserData);
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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_RULE::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("ExecTraderListNum(").append(ExecTraderListNum).append(")");
		for (int i=0; i < ExecTraderList.length; ++i)
		{
			stringBuilder.append("ExecTraderList[").append(i).append("](").append(ExecTraderList[i].toString()).append(")");
		}
		stringBuilder.append("DefaultAutoExecutionTraderId(").append(DefaultAutoExecutionTraderId).append(")");
		stringBuilder.append("DefaultAutoExecutionTraderName(").append(DefaultAutoExecutionTraderName).append(")");
		stringBuilder.append("RuleId(").append(RuleId).append(")");
		stringBuilder.append("RuleName(").append(RuleName).append(")");
		stringBuilder.append("SettlementInfo(").append(SettlementInfo.toString()).append(")");
		stringBuilder.append("EligibilityCriteria(").append(EligibilityCriteria.toString()).append(")");
		stringBuilder.append("DealerSelectionCriteria(").append(DealerSelectionCriteria.toString()).append(")");
		stringBuilder.append("ExecutionCriteria(").append(ExecutionCriteria.toString()).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
