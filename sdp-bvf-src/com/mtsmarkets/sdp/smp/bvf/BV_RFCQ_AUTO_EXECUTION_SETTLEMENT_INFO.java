package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_SETTLEMENT_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114991;

	private TI_FLAG_Enum SettlementInfoFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum DefaultSettlementFg = TI_FLAG_Enum.TI_FLAG_No;
	private short SettlementOffset = 0;

	public BV_RFCQ_AUTO_EXECUTION_SETTLEMENT_INFO()
	{
	}

	public TI_FLAG_Enum getSettlementInfoFg()
	{
		return SettlementInfoFg;
	}
	public void setSettlementInfoFg(TI_FLAG_Enum value)
	{
		SettlementInfoFg = value;
	}
	public TI_FLAG_Enum getDefaultSettlementFg()
	{
		return DefaultSettlementFg;
	}
	public void setDefaultSettlementFg(TI_FLAG_Enum value)
	{
		DefaultSettlementFg = value;
	}
	public short getSettlementOffset()
	{
		return SettlementOffset;
	}
	public void setSettlementOffset(short value)
	{
		SettlementOffset = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SettlementInfoFg = SettlementInfoFg.getEnum(byteBuffer.readInt());
		DefaultSettlementFg = DefaultSettlementFg.getEnum(byteBuffer.readInt());
		SettlementOffset = (short)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(SettlementInfoFg.getValue());
		byteBuffer.writeInt(DefaultSettlementFg.getValue());
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));

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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_SETTLEMENT_INFO::");
		stringBuilder.append("SettlementInfoFg(").append(SettlementInfoFg).append(")");
		stringBuilder.append("DefaultSettlementFg(").append(DefaultSettlementFg).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		return stringBuilder.toString();
	}
}
