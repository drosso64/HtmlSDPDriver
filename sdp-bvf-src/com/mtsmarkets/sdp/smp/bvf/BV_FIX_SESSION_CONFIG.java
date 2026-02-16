package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_FIX_SESSION_CONFIG extends SMPMessage
{
	public static final long CLASS_ID = 100838;

	private long SessionId = 0;
	private TI_FLAG_Enum EnableUnsolicitedTradesFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableUndefinedTradesFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableUnsolicitedInvQuotesFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableUnsolicitedRFCQQuotesFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableUnsolicitedRFCQOrdersFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableUnsolicitedOrdersFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableInventoryQuotesSnapshotFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableInventoryQuotesStatusFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableUnsolicitedIOI = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableIOIStatus = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableIOISnapshot = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableAuditTrailFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableUnsolicitedTradeRegistrationFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum DisableDeletedInvQuoteSnapshot = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum ResendAllDataOnResetCounter = TI_FLAG_Enum.TI_FLAG_No;
	private BV_FIX_ENABLE_ALLOCATION_REPORT_Enum EnableAllocationReport = BV_FIX_ENABLE_ALLOCATION_REPORT_Enum.BV_FIX_ENABLE_ALLOCATION_REPORT_No;
	private long SubmitterMemberId = 0;
	private long SubmitterTraderId = 0;
	private String SubmitterTraderName = "";
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_FIX_SESSION_CONFIG()
	{
	}

	public long getSessionId()
	{
		return SessionId;
	}
	public void setSessionId(long value)
	{
		SessionId = value;
	}
	public TI_FLAG_Enum getEnableUnsolicitedTradesFg()
	{
		return EnableUnsolicitedTradesFg;
	}
	public void setEnableUnsolicitedTradesFg(TI_FLAG_Enum value)
	{
		EnableUnsolicitedTradesFg = value;
	}
	public TI_FLAG_Enum getEnableUndefinedTradesFg()
	{
		return EnableUndefinedTradesFg;
	}
	public void setEnableUndefinedTradesFg(TI_FLAG_Enum value)
	{
		EnableUndefinedTradesFg = value;
	}
	public TI_FLAG_Enum getEnableUnsolicitedInvQuotesFg()
	{
		return EnableUnsolicitedInvQuotesFg;
	}
	public void setEnableUnsolicitedInvQuotesFg(TI_FLAG_Enum value)
	{
		EnableUnsolicitedInvQuotesFg = value;
	}
	public TI_FLAG_Enum getEnableUnsolicitedRFCQQuotesFg()
	{
		return EnableUnsolicitedRFCQQuotesFg;
	}
	public void setEnableUnsolicitedRFCQQuotesFg(TI_FLAG_Enum value)
	{
		EnableUnsolicitedRFCQQuotesFg = value;
	}
	public TI_FLAG_Enum getEnableUnsolicitedRFCQOrdersFg()
	{
		return EnableUnsolicitedRFCQOrdersFg;
	}
	public void setEnableUnsolicitedRFCQOrdersFg(TI_FLAG_Enum value)
	{
		EnableUnsolicitedRFCQOrdersFg = value;
	}
	public TI_FLAG_Enum getEnableUnsolicitedOrdersFg()
	{
		return EnableUnsolicitedOrdersFg;
	}
	public void setEnableUnsolicitedOrdersFg(TI_FLAG_Enum value)
	{
		EnableUnsolicitedOrdersFg = value;
	}
	public TI_FLAG_Enum getEnableInventoryQuotesSnapshotFg()
	{
		return EnableInventoryQuotesSnapshotFg;
	}
	public void setEnableInventoryQuotesSnapshotFg(TI_FLAG_Enum value)
	{
		EnableInventoryQuotesSnapshotFg = value;
	}
	public TI_FLAG_Enum getEnableInventoryQuotesStatusFg()
	{
		return EnableInventoryQuotesStatusFg;
	}
	public void setEnableInventoryQuotesStatusFg(TI_FLAG_Enum value)
	{
		EnableInventoryQuotesStatusFg = value;
	}
	public TI_FLAG_Enum getEnableUnsolicitedIOI()
	{
		return EnableUnsolicitedIOI;
	}
	public void setEnableUnsolicitedIOI(TI_FLAG_Enum value)
	{
		EnableUnsolicitedIOI = value;
	}
	public TI_FLAG_Enum getEnableIOIStatus()
	{
		return EnableIOIStatus;
	}
	public void setEnableIOIStatus(TI_FLAG_Enum value)
	{
		EnableIOIStatus = value;
	}
	public TI_FLAG_Enum getEnableIOISnapshot()
	{
		return EnableIOISnapshot;
	}
	public void setEnableIOISnapshot(TI_FLAG_Enum value)
	{
		EnableIOISnapshot = value;
	}
	public TI_FLAG_Enum getEnableAuditTrailFg()
	{
		return EnableAuditTrailFg;
	}
	public void setEnableAuditTrailFg(TI_FLAG_Enum value)
	{
		EnableAuditTrailFg = value;
	}
	public TI_FLAG_Enum getEnableUnsolicitedTradeRegistrationFg()
	{
		return EnableUnsolicitedTradeRegistrationFg;
	}
	public void setEnableUnsolicitedTradeRegistrationFg(TI_FLAG_Enum value)
	{
		EnableUnsolicitedTradeRegistrationFg = value;
	}
	public TI_FLAG_Enum getDisableDeletedInvQuoteSnapshot()
	{
		return DisableDeletedInvQuoteSnapshot;
	}
	public void setDisableDeletedInvQuoteSnapshot(TI_FLAG_Enum value)
	{
		DisableDeletedInvQuoteSnapshot = value;
	}
	public TI_FLAG_Enum getResendAllDataOnResetCounter()
	{
		return ResendAllDataOnResetCounter;
	}
	public void setResendAllDataOnResetCounter(TI_FLAG_Enum value)
	{
		ResendAllDataOnResetCounter = value;
	}
	public BV_FIX_ENABLE_ALLOCATION_REPORT_Enum getEnableAllocationReport()
	{
		return EnableAllocationReport;
	}
	public void setEnableAllocationReport(BV_FIX_ENABLE_ALLOCATION_REPORT_Enum value)
	{
		EnableAllocationReport = value;
	}
	public long getSubmitterMemberId()
	{
		return SubmitterMemberId;
	}
	public void setSubmitterMemberId(long value)
	{
		SubmitterMemberId = value;
	}
	public long getSubmitterTraderId()
	{
		return SubmitterTraderId;
	}
	public void setSubmitterTraderId(long value)
	{
		SubmitterTraderId = value;
	}
	public String getSubmitterTraderName()
	{
		return SubmitterTraderName;
	}
	public void setSubmitterTraderName(String value)
	{
		SubmitterTraderName = value;
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
		SessionId = (long)byteBuffer.readInt();
		EnableUnsolicitedTradesFg = EnableUnsolicitedTradesFg.getEnum(byteBuffer.readInt());
		EnableUndefinedTradesFg = EnableUndefinedTradesFg.getEnum(byteBuffer.readInt());
		EnableUnsolicitedInvQuotesFg = EnableUnsolicitedInvQuotesFg.getEnum(byteBuffer.readInt());
		EnableUnsolicitedRFCQQuotesFg = EnableUnsolicitedRFCQQuotesFg.getEnum(byteBuffer.readInt());
		EnableUnsolicitedRFCQOrdersFg = EnableUnsolicitedRFCQOrdersFg.getEnum(byteBuffer.readInt());
		EnableUnsolicitedOrdersFg = EnableUnsolicitedOrdersFg.getEnum(byteBuffer.readInt());
		EnableInventoryQuotesSnapshotFg = EnableInventoryQuotesSnapshotFg.getEnum(byteBuffer.readInt());
		EnableInventoryQuotesStatusFg = EnableInventoryQuotesStatusFg.getEnum(byteBuffer.readInt());
		EnableUnsolicitedIOI = EnableUnsolicitedIOI.getEnum(byteBuffer.readInt());
		EnableIOIStatus = EnableIOIStatus.getEnum(byteBuffer.readInt());
		EnableIOISnapshot = EnableIOISnapshot.getEnum(byteBuffer.readInt());
		EnableAuditTrailFg = EnableAuditTrailFg.getEnum(byteBuffer.readInt());
		EnableUnsolicitedTradeRegistrationFg = EnableUnsolicitedTradeRegistrationFg.getEnum(byteBuffer.readInt());
		DisableDeletedInvQuoteSnapshot = DisableDeletedInvQuoteSnapshot.getEnum(byteBuffer.readInt());
		ResendAllDataOnResetCounter = ResendAllDataOnResetCounter.getEnum(byteBuffer.readInt());
		EnableAllocationReport = EnableAllocationReport.getEnum(byteBuffer.readInt());
		SubmitterMemberId = (long)byteBuffer.readInt();
		SubmitterTraderId = (long)byteBuffer.readInt();
		SubmitterTraderName = byteBuffer.readString();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SessionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(EnableUnsolicitedTradesFg.getValue());
		byteBuffer.writeInt(EnableUndefinedTradesFg.getValue());
		byteBuffer.writeInt(EnableUnsolicitedInvQuotesFg.getValue());
		byteBuffer.writeInt(EnableUnsolicitedRFCQQuotesFg.getValue());
		byteBuffer.writeInt(EnableUnsolicitedRFCQOrdersFg.getValue());
		byteBuffer.writeInt(EnableUnsolicitedOrdersFg.getValue());
		byteBuffer.writeInt(EnableInventoryQuotesSnapshotFg.getValue());
		byteBuffer.writeInt(EnableInventoryQuotesStatusFg.getValue());
		byteBuffer.writeInt(EnableUnsolicitedIOI.getValue());
		byteBuffer.writeInt(EnableIOIStatus.getValue());
		byteBuffer.writeInt(EnableIOISnapshot.getValue());
		byteBuffer.writeInt(EnableAuditTrailFg.getValue());
		byteBuffer.writeInt(EnableUnsolicitedTradeRegistrationFg.getValue());
		byteBuffer.writeInt(DisableDeletedInvQuoteSnapshot.getValue());
		byteBuffer.writeInt(ResendAllDataOnResetCounter.getValue());
		byteBuffer.writeInt(EnableAllocationReport.getValue());
		byteBuffer.writeInt((int)(SubmitterMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SubmitterTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SubmitterTraderName);
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
		stringBuilder.append("BV_FIX_SESSION_CONFIG::");
		stringBuilder.append("SessionId(").append(SessionId).append(")");
		stringBuilder.append("EnableUnsolicitedTradesFg(").append(EnableUnsolicitedTradesFg).append(")");
		stringBuilder.append("EnableUndefinedTradesFg(").append(EnableUndefinedTradesFg).append(")");
		stringBuilder.append("EnableUnsolicitedInvQuotesFg(").append(EnableUnsolicitedInvQuotesFg).append(")");
		stringBuilder.append("EnableUnsolicitedRFCQQuotesFg(").append(EnableUnsolicitedRFCQQuotesFg).append(")");
		stringBuilder.append("EnableUnsolicitedRFCQOrdersFg(").append(EnableUnsolicitedRFCQOrdersFg).append(")");
		stringBuilder.append("EnableUnsolicitedOrdersFg(").append(EnableUnsolicitedOrdersFg).append(")");
		stringBuilder.append("EnableInventoryQuotesSnapshotFg(").append(EnableInventoryQuotesSnapshotFg).append(")");
		stringBuilder.append("EnableInventoryQuotesStatusFg(").append(EnableInventoryQuotesStatusFg).append(")");
		stringBuilder.append("EnableUnsolicitedIOI(").append(EnableUnsolicitedIOI).append(")");
		stringBuilder.append("EnableIOIStatus(").append(EnableIOIStatus).append(")");
		stringBuilder.append("EnableIOISnapshot(").append(EnableIOISnapshot).append(")");
		stringBuilder.append("EnableAuditTrailFg(").append(EnableAuditTrailFg).append(")");
		stringBuilder.append("EnableUnsolicitedTradeRegistrationFg(").append(EnableUnsolicitedTradeRegistrationFg).append(")");
		stringBuilder.append("DisableDeletedInvQuoteSnapshot(").append(DisableDeletedInvQuoteSnapshot).append(")");
		stringBuilder.append("ResendAllDataOnResetCounter(").append(ResendAllDataOnResetCounter).append(")");
		stringBuilder.append("EnableAllocationReport(").append(EnableAllocationReport).append(")");
		stringBuilder.append("SubmitterMemberId(").append(SubmitterMemberId).append(")");
		stringBuilder.append("SubmitterTraderId(").append(SubmitterTraderId).append(")");
		stringBuilder.append("SubmitterTraderName(").append(SubmitterTraderName).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
