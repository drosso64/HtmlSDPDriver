package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_PROVIDER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114939;

	private long MemberId = 0;
	private String MemberCode = "";
	private String MemberDesc = "";
	private String MemberShortDesc = "";
	private TI_RFCQ_PROVIDER_STATUS_Enum Status = TI_RFCQ_PROVIDER_STATUS_Enum.TI_RFCQ_PROVIDER_STATUS_Processing;
	private BV_RFCQ_DEALER_SELECTION_TYPE_Enum DealerSelectionType = BV_RFCQ_DEALER_SELECTION_TYPE_Enum.BV_RFCQ_DEALER_SELECTION_Manual;
	private double PriceCoverValue = 0;
	private double ProceedsCoverValue = 0;
	private double GrossYieldCoverValue = 0;
	private double DurWeightedYieldCoverValue = 0;
	private int ResponseTimeDifference = 0;
	private long Delay = 0;

	public BV_RFCQ_PROVIDER_INFO()
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
	public String getMemberCode()
	{
		return MemberCode;
	}
	public void setMemberCode(String value)
	{
		MemberCode = value;
	}
	public String getMemberDesc()
	{
		return MemberDesc;
	}
	public void setMemberDesc(String value)
	{
		MemberDesc = value;
	}
	public String getMemberShortDesc()
	{
		return MemberShortDesc;
	}
	public void setMemberShortDesc(String value)
	{
		MemberShortDesc = value;
	}
	public TI_RFCQ_PROVIDER_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_RFCQ_PROVIDER_STATUS_Enum value)
	{
		Status = value;
	}
	public BV_RFCQ_DEALER_SELECTION_TYPE_Enum getDealerSelectionType()
	{
		return DealerSelectionType;
	}
	public void setDealerSelectionType(BV_RFCQ_DEALER_SELECTION_TYPE_Enum value)
	{
		DealerSelectionType = value;
	}
	public double getPriceCoverValue()
	{
		return PriceCoverValue;
	}
	public void setPriceCoverValue(double value)
	{
		PriceCoverValue = value;
	}
	public double getProceedsCoverValue()
	{
		return ProceedsCoverValue;
	}
	public void setProceedsCoverValue(double value)
	{
		ProceedsCoverValue = value;
	}
	public double getGrossYieldCoverValue()
	{
		return GrossYieldCoverValue;
	}
	public void setGrossYieldCoverValue(double value)
	{
		GrossYieldCoverValue = value;
	}
	public double getDurWeightedYieldCoverValue()
	{
		return DurWeightedYieldCoverValue;
	}
	public void setDurWeightedYieldCoverValue(double value)
	{
		DurWeightedYieldCoverValue = value;
	}
	public int getResponseTimeDifference()
	{
		return ResponseTimeDifference;
	}
	public void setResponseTimeDifference(int value)
	{
		ResponseTimeDifference = value;
	}
	public long getDelay()
	{
		return Delay;
	}
	public void setDelay(long value)
	{
		Delay = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		MemberCode = byteBuffer.readString();
		MemberDesc = byteBuffer.readString();
		MemberShortDesc = byteBuffer.readString();
		Status = Status.getEnum(byteBuffer.readInt());
		DealerSelectionType = DealerSelectionType.getEnum(byteBuffer.readInt());
		PriceCoverValue = byteBuffer.readDouble();
		ProceedsCoverValue = byteBuffer.readDouble();
		GrossYieldCoverValue = byteBuffer.readDouble();
		DurWeightedYieldCoverValue = byteBuffer.readDouble();
		ResponseTimeDifference = (int)byteBuffer.readInt();
		Delay = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberDesc);
		byteBuffer.writeString(MemberShortDesc);
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(DealerSelectionType.getValue());
		byteBuffer.writeDouble(PriceCoverValue);
		byteBuffer.writeDouble(ProceedsCoverValue);
		byteBuffer.writeDouble(GrossYieldCoverValue);
		byteBuffer.writeDouble(DurWeightedYieldCoverValue);
		byteBuffer.writeInt((int)(ResponseTimeDifference & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(Delay & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_RFCQ_PROVIDER_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberDesc(").append(MemberDesc).append(")");
		stringBuilder.append("MemberShortDesc(").append(MemberShortDesc).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("DealerSelectionType(").append(DealerSelectionType).append(")");
		stringBuilder.append("PriceCoverValue(").append(PriceCoverValue).append(")");
		stringBuilder.append("ProceedsCoverValue(").append(ProceedsCoverValue).append(")");
		stringBuilder.append("GrossYieldCoverValue(").append(GrossYieldCoverValue).append(")");
		stringBuilder.append("DurWeightedYieldCoverValue(").append(DurWeightedYieldCoverValue).append(")");
		stringBuilder.append("ResponseTimeDifference(").append(ResponseTimeDifference).append(")");
		stringBuilder.append("Delay(").append(Delay).append(")");
		return stringBuilder.toString();
	}
}
