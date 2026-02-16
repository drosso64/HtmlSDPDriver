package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.sdp.common.SDPException;
import com.mtsmarkets.sdp.common.SDPResultCode;
import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.smp.SMPMessage;
import com.mtsmarkets.io.xdr.ULong;

import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPSubscribeData extends SAPMessage

{

	public static final int  MSG_TYPE = 224;

	

	protected ULong classId = new ULong(0);

	protected ULong keyId = new ULong(0);

	protected SAPActionType action = SAPActionType.ADD;

	protected ULong[] timeStamp = new ULong[2];

	protected ULong subscribeKey = new ULong(0);

	protected SMPMessage smpMessage = null;

	private MarketFactory mktFactory;

	

	public SAPSubscribeData(SAPHeader sapHeader, MarketFactory mktFactory)

	{

		super(sapHeader);

		this.mktFactory = mktFactory;

		timeStamp[0] = new ULong(0);

		timeStamp[1] = new ULong(0);

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

	public SAPActionType getAction()

	{

		return action;

	}

	public void setAction(SAPActionType action)

	{

		this.action = action;

	}

	public ULong[] getTimeStamp()

	{

		return timeStamp;

	}

	public void setTimeStamp(ULong[] timeStamp)

	{

		this.timeStamp = timeStamp;

	}

	public ULong getSubscribeKey()

	{

		return subscribeKey;

	}

	public void setSubscribeKey(ULong subscribeKey)

	{

		this.subscribeKey = subscribeKey;

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

		action = SAPActionType.values()[byteBuffer.readInt()];

		timeStamp[0].setValue(byteBuffer.readInt());

		timeStamp[1].setValue(byteBuffer.readInt());

		subscribeKey.setValue(byteBuffer.readInt());

		smpMessage = mktFactory.createSMPMessage(classId);		

                try {

                    smpMessage.readXDR(byteBuffer);

                } catch (Exception e) {

                    String msg = e + "SAPSubscribeData::readBodyXDR xdr error<" + e.getMessage() + "> decoding smpMessage in " + toString()
                    + " position " + byteBuffer.position() + " limit " 
                    + byteBuffer.limit() + " capacity " + byteBuffer.capacity();
                    throw new SDPException(SDPResultCode.XDR_DECODING_FAILED, msg, e);

                }

	}

	@Override

	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception

	{

		throw new Exception("SAPSubscribeData can be only read from client side");

	}

	@Override

	public String toString()

	{

		StringBuilder stringBuilder = new StringBuilder(128)

			.append("SAPSubscribeData::")

			.append("MsgType(").append(getMessageType()).append(")")

			.append("ClassID(").append(classId.getValue()).append(")")

			.append("KeyID(").append(keyId.getValue()).append(")")

			.append("Action(").append(action).append(")")

			.append("TimeSTamp[0](").append(timeStamp[0].getValue()).append(")")

			.append("TimeStamp[1](").append(timeStamp[1].getValue()).append(")")

			.append("SubscribeKey(").append(subscribeKey.getValue()).append(")");



		return stringBuilder.toString();

	}

}

