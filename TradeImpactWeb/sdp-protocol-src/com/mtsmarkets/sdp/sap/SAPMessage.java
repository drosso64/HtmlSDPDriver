package com.mtsmarkets.sdp.sap;

import java.io.Serializable;

import com.mtsmarkets.components.logging.AbstractLogFactory;
import com.mtsmarkets.components.logging.ILog;
import com.mtsmarkets.sdp.common.FileLogFactorySDP;
import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.smp.SMPMessage;
import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;
import com.mtsmarkets.io.xdr.XDRable;

public abstract class SAPMessage implements XDRable, Serializable {

    protected SAPHeader sapHeader = null;
    // informazioni aggiuntive
    private ULong session_id = new ULong(0);
    private ULong ssp_sequence_number = new ULong(0);
    private ULong sap_sequence_number = new ULong(0);
    private static ILog logSap = AbstractLogFactory.getLoggerByName(FileLogFactorySDP.SAP);

    public abstract void readBodyXDR(XDRByteBuffer byteBuff) throws Exception;

    public abstract int writeXDR(XDRByteBuffer byteBuff) throws Exception;
   
    public void readXDR(XDRByteBuffer byteBuff) throws Exception {
        sapHeader.readXDR(byteBuff);
        readBodyXDR(byteBuff);
    }

    public SAPMessage(SAPHeader sapHeader) {
        this.sapHeader = sapHeader;
    }

    public long getMessageType() {
        return sapHeader.getMsgType().getValue();
    }
    
    public SMPMessage getSmpMessage()
    {
        return null;
    }

    public static SAPMessage create(SAPHeader sapHeader, MarketFactory mktFactory) throws Exception {
        SAPMessage sapMessage = null;
        long sapMsgType = sapHeader.getMsgType().value;
        //logSap.debug("SAP|SAPMessage create - creating sapMsgType: %d", sapMsgType);
        if (sapMsgType == SAPSubscribeData.MSG_TYPE) {
            sapMessage = new SAPSubscribeData(sapHeader, mktFactory);
        }
        else if (sapMsgType == SAPMonitoredActionReq.MSG_TYPE) {
            sapMessage = new SAPMonitoredActionReq(sapHeader, mktFactory);
        }
        else if (sapMsgType == SAPMonitoredActionRes.MSG_TYPE) {
            sapMessage = new SAPMonitoredActionRes(sapHeader, mktFactory);
        }
        else if (sapMsgType == SAPAddressServiceResExt.MSG_TYPE) {
            sapMessage = new SAPAddressServiceResExt(sapHeader);
        }
        else if (sapMsgType == SAPAddressServiceReqExt.MSG_TYPE) {
            sapMessage = new SAPAddressServiceReqExt(sapHeader);
        }
        else if (sapMsgType == SAPLogonReq.MSG_TYPE) {
            sapMessage = new SAPLogonReq(sapHeader);
        }
        else if (sapMsgType == SAPLogonTokenReq.MSG_TYPE) {
            sapMessage = new SAPLogonTokenReq(sapHeader);
        }
        else if (sapMsgType == SAPLogonTokenExtReq.MSG_TYPE) {
            sapMessage = new SAPLogonTokenExtReq(sapHeader);
        }
        else if (sapMsgType == SAPLogonRes.MSG_TYPE) {
            sapMessage = new SAPLogonRes(sapHeader);
        }
        else if (sapMsgType == SAPLogonTokenRes.MSG_TYPE) {
            sapMessage = new SAPLogonTokenRes(sapHeader);
        }
        else if (sapMsgType == SAPLogoffRes.MSG_TYPE) {
            sapMessage = new SAPLogoffRes(sapHeader);
        }
        else if (sapMsgType == SAPLogoffReq.MSG_TYPE) {
            sapMessage = new SAPLogoffReq(sapHeader);
        }        
        else if (sapMsgType == SAPSubscribeStartReq.MSG_TYPE) {
            sapMessage = new SAPSubscribeStartReq(sapHeader);
        }
        else if (sapMsgType == SAPSubscribeStartRes.MSG_TYPE) {
            sapMessage = new SAPSubscribeStartRes(sapHeader);
        }        
        else if (sapMsgType == SAPSubscribeIdle.MSG_TYPE) {
            sapMessage = new SAPSubscribeIdle(sapHeader);
        }
        else if (sapMsgType == SAPSubscribeStopReq.MSG_TYPE) {
            sapMessage = new SAPSubscribeStopReq(sapHeader);
        }
        else if (sapMsgType == SAPSubscribeStopRes.MSG_TYPE) {
            sapMessage = new SAPSubscribeStopRes(sapHeader);
        }
        else if (sapMsgType == SAPFilterCreateReq.MSG_TYPE) {
            sapMessage = new SAPFilterCreateReq(sapHeader);
        }
        else if (sapMsgType == SAPFilterCreateRes.MSG_TYPE) {
            sapMessage = new SAPFilterCreateRes(sapHeader);
        }
        else if (sapMsgType == SAPFilterDestroyReq.MSG_TYPE) {
            sapMessage = new SAPFilterDestroyReq(sapHeader);
        }
        else if (sapMsgType == SAPFilterDestroyRes.MSG_TYPE) {
            sapMessage = new SAPFilterDestroyRes(sapHeader);
        }
        else if (sapMsgType == SAPFilterSetReq.MSG_TYPE) {
            sapMessage = new SAPFilterSetReq(sapHeader);
        }
        else if (sapMsgType == SAPFilterSetRes.MSG_TYPE) {
            sapMessage = new SAPFilterSetRes(sapHeader);
        }
        else if (sapMsgType == SAPQueryReq.MSG_TYPE) {
            sapMessage = new SAPQueryReq(sapHeader);
        }
        else if (sapMsgType == SAPQueryRes.MSG_TYPE) {
            sapMessage = new SAPQueryRes(sapHeader);
        }
        else if (sapMsgType == SAPQueryDestroyReq.MSG_TYPE) {
            sapMessage = new SAPQueryDestroyReq(sapHeader);
        }
        else if (sapMsgType == SAPQueryDestroyRes.MSG_TYPE) {
            sapMessage = new SAPQueryDestroyRes(sapHeader);
        }
        else if (sapMsgType == SAPQueryRowsDataRes.MSG_TYPE) {
            sapMessage = new SAPQueryRowsDataRes(sapHeader);
        }
        else if (sapMsgType == SAPQueryRowsData.MSG_TYPE) {
            sapMessage = new SAPQueryRowsData(sapHeader, mktFactory);
        }
        else if (sapMsgType == SAPQueryRowsEnd.MSG_TYPE) {
            sapMessage = new SAPQueryRowsEnd(sapHeader);
        }
        else if (sapMsgType == SAPActionReq.MSG_TYPE) {
            sapMessage = new SAPActionReq(sapHeader, mktFactory);
        }
        else if (sapMsgType == SAPActionRes.MSG_TYPE) {
            sapMessage = new SAPActionRes(sapHeader, mktFactory);
        }
        else if (sapMsgType == SAPExtActionReq.MSG_TYPE) {
            sapMessage = new SAPExtActionReq(sapHeader, mktFactory);
        }
        else if (sapMsgType == SAPExtActionRes.MSG_TYPE) {
            sapMessage = new SAPExtActionRes(sapHeader, mktFactory);
        }
        else if (sapMsgType == SAPChangePasswordReq.MSG_TYPE) {
            sapMessage = new SAPChangePasswordReq(sapHeader);
        }
        else if (sapMsgType == SAPChangePasswordRes.MSG_TYPE) {
            sapMessage = new SAPChangePasswordRes(sapHeader);
        }
        else if (sapMsgType == SAPErrorMsg.MSG_TYPE) {
            sapMessage = new SAPErrorMsg(sapHeader);
        }
        else {
            logSap.error("SAP|SAPMessage create: Fatal error: Unknow SAPMessage: %d", sapMsgType);
            throw new Exception("Fatal error: Unknow SAPMessage: " + sapMsgType);
        }
        return sapMessage;
    }
}
