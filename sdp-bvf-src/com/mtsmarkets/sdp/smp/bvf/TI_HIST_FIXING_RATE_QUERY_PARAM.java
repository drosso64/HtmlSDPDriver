package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_HIST_FIXING_RATE_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 100100;

	private TI_QUERY_OP_Enum FinancialInstrumentCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String FinancialInstrumentCode = "";
	private TI_QUERY_OP_Enum ReferenceDateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long ReferenceDateFrom = 0;
	private TI_QUERY_OP_Enum ReferenceDateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long ReferenceDateTo = 0;

	public TI_HIST_FIXING_RATE_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getFinancialInstrumentCodeOp()
	{
		return FinancialInstrumentCodeOp;
	}
	public void setFinancialInstrumentCodeOp(TI_QUERY_OP_Enum value)
	{
		FinancialInstrumentCodeOp = value;
	}
	public String getFinancialInstrumentCode()
	{
		return FinancialInstrumentCode;
	}
	public void setFinancialInstrumentCode(String value)
	{
		FinancialInstrumentCode = value;
	}
	public TI_QUERY_OP_Enum getReferenceDateFromOp()
	{
		return ReferenceDateFromOp;
	}
	public void setReferenceDateFromOp(TI_QUERY_OP_Enum value)
	{
		ReferenceDateFromOp = value;
	}
	public long getReferenceDateFrom()
	{
		return ReferenceDateFrom;
	}
	public void setReferenceDateFrom(long value)
	{
		ReferenceDateFrom = value;
	}
	public TI_QUERY_OP_Enum getReferenceDateToOp()
	{
		return ReferenceDateToOp;
	}
	public void setReferenceDateToOp(TI_QUERY_OP_Enum value)
	{
		ReferenceDateToOp = value;
	}
	public long getReferenceDateTo()
	{
		return ReferenceDateTo;
	}
	public void setReferenceDateTo(long value)
	{
		ReferenceDateTo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentCodeOp = FinancialInstrumentCodeOp.getEnum(byteBuffer.readInt());
		FinancialInstrumentCode = byteBuffer.readString();
		ReferenceDateFromOp = ReferenceDateFromOp.getEnum(byteBuffer.readInt());
		ReferenceDateFrom = (long)byteBuffer.readInt();
		ReferenceDateToOp = ReferenceDateToOp.getEnum(byteBuffer.readInt());
		ReferenceDateTo = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(FinancialInstrumentCodeOp.getValue());
		byteBuffer.writeString(FinancialInstrumentCode);
		byteBuffer.writeInt(ReferenceDateFromOp.getValue());
		byteBuffer.writeInt((int)(ReferenceDateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(ReferenceDateToOp.getValue());
		byteBuffer.writeInt((int)(ReferenceDateTo & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_HIST_FIXING_RATE_QUERY_PARAM::");
		stringBuilder.append("FinancialInstrumentCodeOp(").append(FinancialInstrumentCodeOp).append(")");
		stringBuilder.append("FinancialInstrumentCode(").append(FinancialInstrumentCode).append(")");
		stringBuilder.append("ReferenceDateFromOp(").append(ReferenceDateFromOp).append(")");
		stringBuilder.append("ReferenceDateFrom(").append(ReferenceDateFrom).append(")");
		stringBuilder.append("ReferenceDateToOp(").append(ReferenceDateToOp).append(")");
		stringBuilder.append("ReferenceDateTo(").append(ReferenceDateTo).append(")");
		return stringBuilder.toString();
	}
}
