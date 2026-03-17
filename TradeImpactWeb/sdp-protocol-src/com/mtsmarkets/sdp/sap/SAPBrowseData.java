package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.sdp.common.SDPException;
import com.mtsmarkets.sdp.common.SDPResultCode;
import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.smp.SMPMessage;
import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SAPBrowseData extends SAPMessage

{
	public static final int  MSG_TYPE = 264;

	protected ULong classId = new ULong(0);
	protected ULong keyId = new ULong(0);
	protected ULong browseKey = new ULong(0);
	protected SMPMessage smpMessage = null;
    
	private MarketFactory mktFactory;

	

	public SAPBrowseData(SAPHeader sapHeader, MarketFactory mktFactory)

	{
		super(sapHeader);
		this.mktFactory = mktFactory;
	}

	public ULong getClassId()
	{
		return classId;
	}

	public void setClassId(ULong classId)
	{
		this.classId = classId;
	}

	public ULong getKeyId()
	{
		return keyId;
	}

	public void setKeyId(ULong keyId)
	{
		this.keyId = keyId;
	}

	public ULong getBrowseKey()
	{
		return browseKey;
	}

	public void setBrowseKey(ULong browseKey)
	{
		this.browseKey = browseKey;
	}

    @Override
	public SMPMessage getSmpMessage()
	{
		return smpMessage;
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuffer) throws Exception

	{
		classId.setValue(byteBuffer.readInt());
		keyId.setValue(byteBuffer.readInt());
		browseKey.setValue(byteBuffer.readInt());
		smpMessage = mktFactory.createSMPMessage(classId);		

                try {
                    smpMessage.readXDR(byteBuffer);
                } catch (Exception e) {
                    String msg = e + "SAPBrowseData::readBodyXDR xdr error<" + e.getMessage() + "> decoding smpMessage in " + toString()
                        + " position " + byteBuffer.position() + " limit "
                        + byteBuffer.limit() + " capacity " + byteBuffer.capacity();
                        throw new SDPException(SDPResultCode.XDR_DECODING_FAILED, msg, e);
                }
	}

	@Override

	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception

	{
		throw new Exception("SAPBrowseData can be only read from client side");
	}

	@Override

	public String toString()

	{
		StringBuilder stringBuilder = new StringBuilder(128)
			.append("SAPBrowseData::")
			.append("MsgType(").append(getMessageType()).append(")")
			.append("ClassID(").append(classId.getValue()).append(")")
			.append("KeyID(").append(keyId.getValue()).append(")")
			.append("BrowseKey(").append(browseKey.getValue()).append(")");

		return stringBuilder.toString();
	}

}

