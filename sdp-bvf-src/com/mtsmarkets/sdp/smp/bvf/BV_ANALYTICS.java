package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_ANALYTICS extends SMPMessage
{
	public static final long CLASS_ID = 114984;

	private BV_VALUE ISpreadYTM = new BV_VALUE();
	private BV_VALUE ISpreadYTC = new BV_VALUE();
	private BV_VALUE ISpreadYTW = new BV_VALUE();
	private BV_VALUE ZSpreadYTM = new BV_VALUE();
	private BV_VALUE ZSpreadYTC = new BV_VALUE();
	private BV_VALUE ZSpreadYTW = new BV_VALUE();
	private BV_VALUE GSpreadYTM = new BV_VALUE();
	private BV_VALUE GSpreadYTC = new BV_VALUE();
	private BV_VALUE GSpreadYTW = new BV_VALUE();
	private BV_VALUE OISSpreadYTM = new BV_VALUE();
	private BV_VALUE OISSpreadYTC = new BV_VALUE();
	private BV_VALUE OISSpreadYTW = new BV_VALUE();
	private BV_VALUE ASWSpreadYTM = new BV_VALUE();
	private BV_VALUE ASWSpreadYTC = new BV_VALUE();
	private BV_VALUE ASWSpreadYTW = new BV_VALUE();
	private BV_VALUE CDSSpreadYTM = new BV_VALUE();
	private BV_VALUE CDSSpreadYTC = new BV_VALUE();
	private BV_VALUE CDSSpreadYTW = new BV_VALUE();
	private BV_VALUE CDSBasisYTM = new BV_VALUE();
	private BV_VALUE CDSBasisYTC = new BV_VALUE();
	private BV_VALUE CDSBasisYTW = new BV_VALUE();

	public BV_ANALYTICS()
	{
	}

	public BV_VALUE getISpreadYTM()
	{
		return ISpreadYTM;
	}
	public void setISpreadYTM(BV_VALUE value)
	{
		ISpreadYTM = value;
	}
	public BV_VALUE getISpreadYTC()
	{
		return ISpreadYTC;
	}
	public void setISpreadYTC(BV_VALUE value)
	{
		ISpreadYTC = value;
	}
	public BV_VALUE getISpreadYTW()
	{
		return ISpreadYTW;
	}
	public void setISpreadYTW(BV_VALUE value)
	{
		ISpreadYTW = value;
	}
	public BV_VALUE getZSpreadYTM()
	{
		return ZSpreadYTM;
	}
	public void setZSpreadYTM(BV_VALUE value)
	{
		ZSpreadYTM = value;
	}
	public BV_VALUE getZSpreadYTC()
	{
		return ZSpreadYTC;
	}
	public void setZSpreadYTC(BV_VALUE value)
	{
		ZSpreadYTC = value;
	}
	public BV_VALUE getZSpreadYTW()
	{
		return ZSpreadYTW;
	}
	public void setZSpreadYTW(BV_VALUE value)
	{
		ZSpreadYTW = value;
	}
	public BV_VALUE getGSpreadYTM()
	{
		return GSpreadYTM;
	}
	public void setGSpreadYTM(BV_VALUE value)
	{
		GSpreadYTM = value;
	}
	public BV_VALUE getGSpreadYTC()
	{
		return GSpreadYTC;
	}
	public void setGSpreadYTC(BV_VALUE value)
	{
		GSpreadYTC = value;
	}
	public BV_VALUE getGSpreadYTW()
	{
		return GSpreadYTW;
	}
	public void setGSpreadYTW(BV_VALUE value)
	{
		GSpreadYTW = value;
	}
	public BV_VALUE getOISSpreadYTM()
	{
		return OISSpreadYTM;
	}
	public void setOISSpreadYTM(BV_VALUE value)
	{
		OISSpreadYTM = value;
	}
	public BV_VALUE getOISSpreadYTC()
	{
		return OISSpreadYTC;
	}
	public void setOISSpreadYTC(BV_VALUE value)
	{
		OISSpreadYTC = value;
	}
	public BV_VALUE getOISSpreadYTW()
	{
		return OISSpreadYTW;
	}
	public void setOISSpreadYTW(BV_VALUE value)
	{
		OISSpreadYTW = value;
	}
	public BV_VALUE getASWSpreadYTM()
	{
		return ASWSpreadYTM;
	}
	public void setASWSpreadYTM(BV_VALUE value)
	{
		ASWSpreadYTM = value;
	}
	public BV_VALUE getASWSpreadYTC()
	{
		return ASWSpreadYTC;
	}
	public void setASWSpreadYTC(BV_VALUE value)
	{
		ASWSpreadYTC = value;
	}
	public BV_VALUE getASWSpreadYTW()
	{
		return ASWSpreadYTW;
	}
	public void setASWSpreadYTW(BV_VALUE value)
	{
		ASWSpreadYTW = value;
	}
	public BV_VALUE getCDSSpreadYTM()
	{
		return CDSSpreadYTM;
	}
	public void setCDSSpreadYTM(BV_VALUE value)
	{
		CDSSpreadYTM = value;
	}
	public BV_VALUE getCDSSpreadYTC()
	{
		return CDSSpreadYTC;
	}
	public void setCDSSpreadYTC(BV_VALUE value)
	{
		CDSSpreadYTC = value;
	}
	public BV_VALUE getCDSSpreadYTW()
	{
		return CDSSpreadYTW;
	}
	public void setCDSSpreadYTW(BV_VALUE value)
	{
		CDSSpreadYTW = value;
	}
	public BV_VALUE getCDSBasisYTM()
	{
		return CDSBasisYTM;
	}
	public void setCDSBasisYTM(BV_VALUE value)
	{
		CDSBasisYTM = value;
	}
	public BV_VALUE getCDSBasisYTC()
	{
		return CDSBasisYTC;
	}
	public void setCDSBasisYTC(BV_VALUE value)
	{
		CDSBasisYTC = value;
	}
	public BV_VALUE getCDSBasisYTW()
	{
		return CDSBasisYTW;
	}
	public void setCDSBasisYTW(BV_VALUE value)
	{
		CDSBasisYTW = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ISpreadYTM.readXDR(byteBuffer);
		ISpreadYTC.readXDR(byteBuffer);
		ISpreadYTW.readXDR(byteBuffer);
		ZSpreadYTM.readXDR(byteBuffer);
		ZSpreadYTC.readXDR(byteBuffer);
		ZSpreadYTW.readXDR(byteBuffer);
		GSpreadYTM.readXDR(byteBuffer);
		GSpreadYTC.readXDR(byteBuffer);
		GSpreadYTW.readXDR(byteBuffer);
		OISSpreadYTM.readXDR(byteBuffer);
		OISSpreadYTC.readXDR(byteBuffer);
		OISSpreadYTW.readXDR(byteBuffer);
		ASWSpreadYTM.readXDR(byteBuffer);
		ASWSpreadYTC.readXDR(byteBuffer);
		ASWSpreadYTW.readXDR(byteBuffer);
		CDSSpreadYTM.readXDR(byteBuffer);
		CDSSpreadYTC.readXDR(byteBuffer);
		CDSSpreadYTW.readXDR(byteBuffer);
		CDSBasisYTM.readXDR(byteBuffer);
		CDSBasisYTC.readXDR(byteBuffer);
		CDSBasisYTW.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		ISpreadYTM.writeXDR(byteBuffer);
		ISpreadYTC.writeXDR(byteBuffer);
		ISpreadYTW.writeXDR(byteBuffer);
		ZSpreadYTM.writeXDR(byteBuffer);
		ZSpreadYTC.writeXDR(byteBuffer);
		ZSpreadYTW.writeXDR(byteBuffer);
		GSpreadYTM.writeXDR(byteBuffer);
		GSpreadYTC.writeXDR(byteBuffer);
		GSpreadYTW.writeXDR(byteBuffer);
		OISSpreadYTM.writeXDR(byteBuffer);
		OISSpreadYTC.writeXDR(byteBuffer);
		OISSpreadYTW.writeXDR(byteBuffer);
		ASWSpreadYTM.writeXDR(byteBuffer);
		ASWSpreadYTC.writeXDR(byteBuffer);
		ASWSpreadYTW.writeXDR(byteBuffer);
		CDSSpreadYTM.writeXDR(byteBuffer);
		CDSSpreadYTC.writeXDR(byteBuffer);
		CDSSpreadYTW.writeXDR(byteBuffer);
		CDSBasisYTM.writeXDR(byteBuffer);
		CDSBasisYTC.writeXDR(byteBuffer);
		CDSBasisYTW.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_ANALYTICS::");
		stringBuilder.append("ISpreadYTM(").append(ISpreadYTM.toString()).append(")");
		stringBuilder.append("ISpreadYTC(").append(ISpreadYTC.toString()).append(")");
		stringBuilder.append("ISpreadYTW(").append(ISpreadYTW.toString()).append(")");
		stringBuilder.append("ZSpreadYTM(").append(ZSpreadYTM.toString()).append(")");
		stringBuilder.append("ZSpreadYTC(").append(ZSpreadYTC.toString()).append(")");
		stringBuilder.append("ZSpreadYTW(").append(ZSpreadYTW.toString()).append(")");
		stringBuilder.append("GSpreadYTM(").append(GSpreadYTM.toString()).append(")");
		stringBuilder.append("GSpreadYTC(").append(GSpreadYTC.toString()).append(")");
		stringBuilder.append("GSpreadYTW(").append(GSpreadYTW.toString()).append(")");
		stringBuilder.append("OISSpreadYTM(").append(OISSpreadYTM.toString()).append(")");
		stringBuilder.append("OISSpreadYTC(").append(OISSpreadYTC.toString()).append(")");
		stringBuilder.append("OISSpreadYTW(").append(OISSpreadYTW.toString()).append(")");
		stringBuilder.append("ASWSpreadYTM(").append(ASWSpreadYTM.toString()).append(")");
		stringBuilder.append("ASWSpreadYTC(").append(ASWSpreadYTC.toString()).append(")");
		stringBuilder.append("ASWSpreadYTW(").append(ASWSpreadYTW.toString()).append(")");
		stringBuilder.append("CDSSpreadYTM(").append(CDSSpreadYTM.toString()).append(")");
		stringBuilder.append("CDSSpreadYTC(").append(CDSSpreadYTC.toString()).append(")");
		stringBuilder.append("CDSSpreadYTW(").append(CDSSpreadYTW.toString()).append(")");
		stringBuilder.append("CDSBasisYTM(").append(CDSBasisYTM.toString()).append(")");
		stringBuilder.append("CDSBasisYTC(").append(CDSBasisYTC.toString()).append(")");
		stringBuilder.append("CDSBasisYTW(").append(CDSBasisYTW.toString()).append(")");
		return stringBuilder.toString();
	}
}
