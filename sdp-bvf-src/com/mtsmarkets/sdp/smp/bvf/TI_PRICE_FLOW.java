package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_PRICE_FLOW extends SMPMessage
{
	public static final long CLASS_ID = 100800;

	private long FinancialInstrumentId = 0;
	private TI_FLOW_Enum FlowType = TI_FLOW_Enum.TI_FLOW_BPV;
	private long FlowId = 0;
	private double Value = 0;
	private long ReferenceDate = 0;
	private long ReferenceTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public TI_PRICE_FLOW()
	{
	}

	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public TI_FLOW_Enum getFlowType()
	{
		return FlowType;
	}
	public void setFlowType(TI_FLOW_Enum value)
	{
		FlowType = value;
	}
	public long getFlowId()
	{
		return FlowId;
	}
	public void setFlowId(long value)
	{
		FlowId = value;
	}
	public double getValue()
	{
		return Value;
	}
	public void setValue(double value)
	{
		Value = value;
	}
	public long getReferenceDate()
	{
		return ReferenceDate;
	}
	public void setReferenceDate(long value)
	{
		ReferenceDate = value;
	}
	public long getReferenceTime()
	{
		return ReferenceTime;
	}
	public void setReferenceTime(long value)
	{
		ReferenceTime = value;
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
		FinancialInstrumentId = (long)byteBuffer.readInt();
		FlowType = FlowType.getEnum(byteBuffer.readInt());
		FlowId = (long)byteBuffer.readInt();
		Value = byteBuffer.readDouble();
		ReferenceDate = (long)byteBuffer.readInt();
		ReferenceTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(FlowType.getValue());
		byteBuffer.writeInt((int)(FlowId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Value);
		byteBuffer.writeInt((int)(ReferenceDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(ReferenceTime);
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
		stringBuilder.append("TI_PRICE_FLOW::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("FlowType(").append(FlowType).append(")");
		stringBuilder.append("FlowId(").append(FlowId).append(")");
		stringBuilder.append("Value(").append(Value).append(")");
		stringBuilder.append("ReferenceDate(").append(ReferenceDate).append(")");
		stringBuilder.append("ReferenceTime(").append(ReferenceTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
