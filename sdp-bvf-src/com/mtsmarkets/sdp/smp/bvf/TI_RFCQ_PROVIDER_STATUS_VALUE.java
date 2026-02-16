package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_RFCQ_PROVIDER_STATUS_VALUE extends SMPMessage
{
	public static final long CLASS_ID = 100903;

	private TI_RFCQ_PROVIDER_STATUS_Enum Value = TI_RFCQ_PROVIDER_STATUS_Enum.TI_RFCQ_PROVIDER_STATUS_Processing;

	public TI_RFCQ_PROVIDER_STATUS_VALUE()
	{
	}

	public TI_RFCQ_PROVIDER_STATUS_Enum getValue()
	{
		return Value;
	}
	public void setValue(TI_RFCQ_PROVIDER_STATUS_Enum value)
	{
		Value = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Value = Value.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(Value.getValue());

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
		stringBuilder.append("TI_RFCQ_PROVIDER_STATUS_VALUE::");
		stringBuilder.append("Value(").append(Value).append(")");
		return stringBuilder.toString();
	}
}
