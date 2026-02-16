package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_ALGO_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114986;

	private String ShortCode1 = "";
	private String ShortCode2 = "";
	private BV_ALGO_INFO_TYPE_Enum Algo = BV_ALGO_INFO_TYPE_Enum.BV_ALGO_INFO_TYPE_None;

	public BV_ALGO_INFO()
	{
	}

	public String getShortCode1()
	{
		return ShortCode1;
	}
	public void setShortCode1(String value)
	{
		ShortCode1 = value;
	}
	public String getShortCode2()
	{
		return ShortCode2;
	}
	public void setShortCode2(String value)
	{
		ShortCode2 = value;
	}
	public BV_ALGO_INFO_TYPE_Enum getAlgo()
	{
		return Algo;
	}
	public void setAlgo(BV_ALGO_INFO_TYPE_Enum value)
	{
		Algo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ShortCode1 = byteBuffer.readString();
		ShortCode2 = byteBuffer.readString();
		Algo = Algo.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(ShortCode1);
		byteBuffer.writeString(ShortCode2);
		byteBuffer.writeInt(Algo.getValue());

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
		stringBuilder.append("BV_ALGO_INFO::");
		stringBuilder.append("ShortCode1(").append(ShortCode1).append(")");
		stringBuilder.append("ShortCode2(").append(ShortCode2).append(")");
		stringBuilder.append("Algo(").append(Algo).append(")");
		return stringBuilder.toString();
	}
}
