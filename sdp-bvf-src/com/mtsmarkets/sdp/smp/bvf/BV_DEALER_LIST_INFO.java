package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_DEALER_LIST_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114971;

	private long DealerId = 0;
	private TI_FLAG_Enum RFCQEnabledFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_RFCQ_DEALER_SELECTION_TYPE_Enum DealerSelectionType = BV_RFCQ_DEALER_SELECTION_TYPE_Enum.BV_RFCQ_DEALER_SELECTION_Manual;
	private long Data1 = 0;
	private long Data2 = 0;
	private double Data3 = 0;
	private double Data4 = 0;
	private String Data5 = "";
	private String Data6 = "";

	public BV_DEALER_LIST_INFO()
	{
	}

	public long getDealerId()
	{
		return DealerId;
	}
	public void setDealerId(long value)
	{
		DealerId = value;
	}
	public TI_FLAG_Enum getRFCQEnabledFg()
	{
		return RFCQEnabledFg;
	}
	public void setRFCQEnabledFg(TI_FLAG_Enum value)
	{
		RFCQEnabledFg = value;
	}
	public BV_RFCQ_DEALER_SELECTION_TYPE_Enum getDealerSelectionType()
	{
		return DealerSelectionType;
	}
	public void setDealerSelectionType(BV_RFCQ_DEALER_SELECTION_TYPE_Enum value)
	{
		DealerSelectionType = value;
	}
	public long getData1()
	{
		return Data1;
	}
	public void setData1(long value)
	{
		Data1 = value;
	}
	public long getData2()
	{
		return Data2;
	}
	public void setData2(long value)
	{
		Data2 = value;
	}
	public double getData3()
	{
		return Data3;
	}
	public void setData3(double value)
	{
		Data3 = value;
	}
	public double getData4()
	{
		return Data4;
	}
	public void setData4(double value)
	{
		Data4 = value;
	}
	public String getData5()
	{
		return Data5;
	}
	public void setData5(String value)
	{
		Data5 = value;
	}
	public String getData6()
	{
		return Data6;
	}
	public void setData6(String value)
	{
		Data6 = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DealerId = (long)byteBuffer.readInt();
		RFCQEnabledFg = RFCQEnabledFg.getEnum(byteBuffer.readInt());
		DealerSelectionType = DealerSelectionType.getEnum(byteBuffer.readInt());
		Data1 = (long)byteBuffer.readInt();
		Data2 = (long)byteBuffer.readInt();
		Data3 = byteBuffer.readDouble();
		Data4 = byteBuffer.readDouble();
		Data5 = byteBuffer.readString();
		Data6 = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(DealerId & 0xFFFFFFFFL));
		byteBuffer.writeInt(RFCQEnabledFg.getValue());
		byteBuffer.writeInt(DealerSelectionType.getValue());
		byteBuffer.writeInt((int)(Data1 & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(Data2 & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Data3);
		byteBuffer.writeDouble(Data4);
		byteBuffer.writeString(Data5);
		byteBuffer.writeString(Data6);

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
		stringBuilder.append("BV_DEALER_LIST_INFO::");
		stringBuilder.append("DealerId(").append(DealerId).append(")");
		stringBuilder.append("RFCQEnabledFg(").append(RFCQEnabledFg).append(")");
		stringBuilder.append("DealerSelectionType(").append(DealerSelectionType).append(")");
		stringBuilder.append("Data1(").append(Data1).append(")");
		stringBuilder.append("Data2(").append(Data2).append(")");
		stringBuilder.append("Data3(").append(Data3).append(")");
		stringBuilder.append("Data4(").append(Data4).append(")");
		stringBuilder.append("Data5(").append(Data5).append(")");
		stringBuilder.append("Data6(").append(Data6).append(")");
		return stringBuilder.toString();
	}
}
