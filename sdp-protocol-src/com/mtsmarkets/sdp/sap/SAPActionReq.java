package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.sdp.common.SDPException;
import com.mtsmarkets.sdp.common.SDPResultCode;
import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.smp.SMPMessage;
import com.mtsmarkets.io.xdr.ULong;

import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPActionReq extends SAPMessage {

	public static final int MSG_TYPE = 210;

	protected ULong reqId = new ULong(0);
	protected ULong classId = new ULong(0);
	protected ULong keyId = new ULong(0);
	protected SAPActionType action = SAPActionType.ADD;
	protected ULong[] transId = new ULong[2];
	protected int dataInResponse = 0;
	protected SMPMessage smpMessage = null;
    protected MarketFactory mktFactory;

	public SAPActionReq(SMPMessage smpMessage) {
		this(smpMessage, MSG_TYPE);
	}

	public SAPActionReq(SMPMessage smpMessage, int msgType) {
		super(new SAPHeader(msgType));
		this.smpMessage = smpMessage;
		transId[0] = new ULong(0);
		transId[1] = new ULong(0);
	}

	public SAPActionReq(SAPHeader sapHeader, MarketFactory mktFactory) {
		super(sapHeader);
		this.mktFactory = mktFactory;
		transId[0] = new ULong(0);
		transId[1] = new ULong(0);
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {
        reqId.setValue(byteBuff.readInt());
        classId.setValue(byteBuff.readInt());
        keyId.setValue(byteBuff.readInt());
        action = SAPActionType.values()[byteBuff.readInt()];   
        transId[0].setValue(byteBuff.readInt());
        transId[1].setValue(byteBuff.readInt());
        dataInResponse = byteBuff.readInt();
        
        if (classId.getValue() != 0) {
            smpMessage = mktFactory.createSMPMessage(classId);
            try {
                smpMessage.readXDR(byteBuff);
            } catch (Exception e) {
                String msg = "xdr error decoding smpMessage ";
                if (smpMessage != null)
                    msg = msg + smpMessage.toString() + "in " + toString();
                 else
                    msg = msg + "in " + toString();
                throw new SDPException(SDPResultCode.XDR_DECODING_FAILED, msg, e);
            }
        }
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {
		int init = byteBuff.getByteBuff().position();
		// header pdu
		sapHeader.writeXDR(byteBuff);
		// body pdu
		byteBuff.writeInt((int) reqId.getValue());
		byteBuff.writeInt((int) classId.getValue());
		byteBuff.writeInt((int) keyId.getValue());
		byteBuff.writeInt(action.ordinal());
		byteBuff.writeInt((int) transId[0].getValue());
		byteBuff.writeInt((int) transId[1].getValue());
		byteBuff.writeInt(dataInResponse);
		smpMessage.writeXDR(byteBuff);
		return byteBuff.getByteBuff().position() - init;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SAPActionReq::")
		.append("ReqId(").append(reqId.getValue()).append(")")
		.append("ClassId(").append(classId.getValue()).append(")")
		.append("KeyId(").append(keyId.getValue()).append(")")
		.append("Action(").append(action).append(")")
		.append("TransId0(").append(transId[0].getValue()).append(")")
		.append("TransId1(").append(transId[1].getValue()).append(")")
		.append("DataInResponse(").append(dataInResponse).append(")");
		return str.toString();
	}

	public ULong getReqId() {
		return reqId;
	}
    
	public void setReqId(ULong reqId) {
		this.reqId = reqId;
	}

	public ULong getClassId() {
		return classId;
	}

	public void setClassId(ULong classId) {
		this.classId = classId;
	}

	public ULong getKeyId() {
		return keyId;
	}

	public void setKeyId(ULong keyId) {
		this.keyId = keyId;
	}

	public SAPActionType getAction() {
		return action;
	}

	public void setAction(SAPActionType action) {
		this.action = action;
	}

	public ULong[] getTransId() {
		return transId;
	}

	public void setTransId(ULong[] transId) {
		this.transId = transId;
	}

	public int getDataInResponse() {
		return dataInResponse;
	}

	public void setDataInResponse(int dataInResponse) {
		this.dataInResponse = dataInResponse;
	}
	
	public SMPMessage getSmpMessage() {
		return smpMessage;
	}
}