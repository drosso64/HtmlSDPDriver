/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.sdp.common.SDPException;
import com.mtsmarkets.sdp.common.SDPResultCode;
import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.smp.SMPMessage;
import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SAPExtActionRes extends SAPMessage {
    
    public static final int MSG_TYPE = 218;

    public enum Result
	{
		TransOK(0),
		TransKO(1),
		TransInvalidTID(2);
		Result(int value)
		{
		}
	}
    
    protected ULong reqId = new ULong(0);
	protected SAPActionRes.Result result = SAPActionRes.Result.TransOK;
	protected ULong reasonCode = new ULong(0);
	protected ULong[] transId = new ULong[2];
    protected long inTimeStamp = 0;
    protected long outTimeStamp = 0;
	protected ULong resClassId = new ULong(0);
	protected SMPMessage smpMessage = null;
	private MarketFactory mktFactory;

	public SAPExtActionRes(SAPHeader sapHeader, MarketFactory mktFactory) {
		super(sapHeader);
		this.mktFactory = mktFactory;
		transId[0] = new ULong(0);
		transId[1] = new ULong(0);
	}

	@Override
	   public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {
        reqId.setValue(byteBuff.readInt());
        result = SAPActionRes.Result.values()[byteBuff.readInt()];
        reasonCode.setValue(byteBuff.readInt());
        transId[0].setValue(byteBuff.readInt());
        transId[1].setValue(byteBuff.readInt());
        inTimeStamp = byteBuff.readLong();
        outTimeStamp = byteBuff.readLong();
        resClassId.setValue(byteBuff.readInt());
        if (resClassId.getValue() != 0) {
            smpMessage = mktFactory.createSMPMessage(resClassId);
            try {
                smpMessage.readXDR(byteBuff);
            } catch (Exception e) {
                String msg = "xdr error decoding smpMessage in " + toString();
                throw new SDPException(SDPResultCode.XDR_DECODING_FAILED, msg, e);
            }
        }
    }

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {
		throw new Exception("SAPActionRes can only read from client side");
	}
	
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SAPExtActionRes::")
		.append("ReqId(").append(reqId.getValue()).append(")")
		.append("Result(").append(result).append(")")
		.append("ReasonCode(").append(reasonCode.getValue()).append(")")
		.append("TransId0(").append(transId[0].getValue()).append(")")
		.append("TransId1(").append(transId[1].getValue()).append(")")
        .append("inTimeStamp(").append(inTimeStamp).append(")")
        .append("outTimeStamp(").append(outTimeStamp).append(")")
		.append("ResClassId(").append(resClassId.getValue()).append(")");
		return str.toString();
	}

	public ULong getReqId() {
		return reqId;
	}

	public void setReqId(ULong reqId) {
		this.reqId = reqId;
	}

	public SAPActionRes.Result getResult() {
		return result;
	}

	public void setResult(SAPActionRes.Result result) {
		this.result = result;
	}

	public ULong getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(ULong reasonCode) {
		this.reasonCode = reasonCode;
	}

	public ULong[] getTransId() {
		return transId;
	}

	public void setTransId(ULong[] transId) {
		this.transId = transId;
	}

    public long getInTimeStamp() {
        return inTimeStamp;
    }

    public void setInTimeStamp(long inTimeStamp) {
        this.inTimeStamp = inTimeStamp;
    }

    public long getOutTimeStamp() {
        return outTimeStamp;
    }

    public void setOutTimeStamp(long outTimeStamp) {
        this.outTimeStamp = outTimeStamp;
    }
    
	public ULong getResClassId() {
		return resClassId;
	}

	public void setResClassId(ULong resClassId) {
		this.resClassId = resClassId;
	}

	public SMPMessage getSmpMessage() {
		return smpMessage;
	}

	public void setSmpMessage(SMPMessage smpMessage) {
		this.smpMessage = smpMessage;
	}
        
    
}
