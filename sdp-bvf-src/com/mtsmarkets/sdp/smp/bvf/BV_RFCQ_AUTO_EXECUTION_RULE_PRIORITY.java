package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY extends SMPMessage
{
	public static final long CLASS_ID = 114112;

	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private long[] Rules = new long[200];
	private TI_FLAG_Enum DealerIndicator = TI_FLAG_Enum.TI_FLAG_No;
	private short MaxAutoExecutionRulesNum = 0;
	private TI_FLAG_Enum DefaultAutoExecutionTraderFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum StageOrderAutoDeleteFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY_EVENT_Enum Event = BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY_EVENT_Enum.BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY_EVENT_Enable;
	private BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY_STATUS_Enum Status = BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY_STATUS_Enum.BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY_STATUS_Enabled;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;
	private String UserData = "";

	public BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY()
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
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public long[] getRules()
	{
		return Rules;
	}
	public void setRules(long[] value)
	{
		Rules = value;
	}
	public TI_FLAG_Enum getDealerIndicator()
	{
		return DealerIndicator;
	}
	public void setDealerIndicator(TI_FLAG_Enum value)
	{
		DealerIndicator = value;
	}
	public short getMaxAutoExecutionRulesNum()
	{
		return MaxAutoExecutionRulesNum;
	}
	public void setMaxAutoExecutionRulesNum(short value)
	{
		MaxAutoExecutionRulesNum = value;
	}
	public TI_FLAG_Enum getDefaultAutoExecutionTraderFg()
	{
		return DefaultAutoExecutionTraderFg;
	}
	public void setDefaultAutoExecutionTraderFg(TI_FLAG_Enum value)
	{
		DefaultAutoExecutionTraderFg = value;
	}
	public TI_FLAG_Enum getStageOrderAutoDeleteFg()
	{
		return StageOrderAutoDeleteFg;
	}
	public void setStageOrderAutoDeleteFg(TI_FLAG_Enum value)
	{
		StageOrderAutoDeleteFg = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY_STATUS_Enum value)
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
	public String getUserData()
	{
		return UserData;
	}
	public void setUserData(String value)
	{
		UserData = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		for (int i=0; i < Rules.length; ++i)
		{
			Rules[i] = (long)byteBuffer.readInt();
		}
		DealerIndicator = DealerIndicator.getEnum(byteBuffer.readInt());
		MaxAutoExecutionRulesNum = (short)byteBuffer.readInt();
		DefaultAutoExecutionTraderFg = DefaultAutoExecutionTraderFg.getEnum(byteBuffer.readInt());
		StageOrderAutoDeleteFg = StageOrderAutoDeleteFg.getEnum(byteBuffer.readInt());
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = byteBuffer.readLong();
		UpdateTime = byteBuffer.readLong();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		for (int i=0; i < Rules.length; ++i)
		{
			byteBuffer.writeInt((int)(Rules[i] & 0xFFFFFFFFL));
		}
		byteBuffer.writeInt(DealerIndicator.getValue());
		byteBuffer.writeInt((int)(MaxAutoExecutionRulesNum & 0xFFFFL));
		byteBuffer.writeInt(DefaultAutoExecutionTraderFg.getValue());
		byteBuffer.writeInt(StageOrderAutoDeleteFg.getValue());
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeLong(UpdateDate);
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeString(UserData);

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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_RULE_PRIORITY::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		for (int i=0; i < Rules.length; ++i)
		{
			stringBuilder.append("Rules[").append(i).append("](").append(Rules[i]).append(")");
		}
		stringBuilder.append("DealerIndicator(").append(DealerIndicator).append(")");
		stringBuilder.append("MaxAutoExecutionRulesNum(").append(MaxAutoExecutionRulesNum).append(")");
		stringBuilder.append("DefaultAutoExecutionTraderFg(").append(DefaultAutoExecutionTraderFg).append(")");
		stringBuilder.append("StageOrderAutoDeleteFg(").append(StageOrderAutoDeleteFg).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
