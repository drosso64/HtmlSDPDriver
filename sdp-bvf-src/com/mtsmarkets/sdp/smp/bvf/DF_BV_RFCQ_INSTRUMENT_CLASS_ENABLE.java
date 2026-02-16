package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_RFCQ_INSTRUMENT_CLASS_ENABLE extends SMPMessage
{
	public static final long CLASS_ID = 170015;

	private BV_LOG_RFCQ_INSTRUMENT_CLASS_ENABLE DFRfcqICEnable = new BV_LOG_RFCQ_INSTRUMENT_CLASS_ENABLE();

	public DF_BV_RFCQ_INSTRUMENT_CLASS_ENABLE()
	{
	}

	public BV_LOG_RFCQ_INSTRUMENT_CLASS_ENABLE getDFRfcqICEnable()
	{
		return DFRfcqICEnable;
	}
	public void setDFRfcqICEnable(BV_LOG_RFCQ_INSTRUMENT_CLASS_ENABLE value)
	{
		DFRfcqICEnable = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFRfcqICEnable.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFRfcqICEnable.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_RFCQ_INSTRUMENT_CLASS_ENABLE::");
		stringBuilder.append("DFRfcqICEnable(").append(DFRfcqICEnable.toString()).append(")");
		return stringBuilder.toString();
	}
}
