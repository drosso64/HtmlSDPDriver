package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_SPLIT_ACCOUNT_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114959;

	private String AccountCode = "";
	private String AccountInfo = "";
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private double Quantity = 0;
	private TI_ACCOUNT_INFO_STATUS_Enum Status = TI_ACCOUNT_INFO_STATUS_Enum.TI_ACCOUNT_INFO_STATUS_Accepted;

	public BV_HIST_SPLIT_ACCOUNT_INFO()
	{
	}

	public String getAccountCode()
	{
		return AccountCode;
	}
	public void setAccountCode(String value)
	{
		AccountCode = value;
	}
	public String getAccountInfo()
	{
		return AccountInfo;
	}
	public void setAccountInfo(String value)
	{
		AccountInfo = value;
	}
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}
	public double getQuantity()
	{
		return Quantity;
	}
	public void setQuantity(double value)
	{
		Quantity = value;
	}
	public TI_ACCOUNT_INFO_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_ACCOUNT_INFO_STATUS_Enum value)
	{
		Status = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		AccountCode = byteBuffer.readString();
		AccountInfo = byteBuffer.readString();
		Verb = Verb.getEnum(byteBuffer.readInt());
		Quantity = byteBuffer.readDouble();
		Status = Status.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(AccountCode);
		byteBuffer.writeString(AccountInfo);
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeInt(Status.getValue());

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
		stringBuilder.append("BV_HIST_SPLIT_ACCOUNT_INFO::");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("AccountInfo(").append(AccountInfo).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		return stringBuilder.toString();
	}
}
