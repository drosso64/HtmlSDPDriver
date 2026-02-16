package com.mtsmarkets.sdp.smp;



import com.mtsmarkets.io.xdr.ULong;



public interface MarketFactory {

	SMPMessage createSMPMessage(ULong classId) throws Exception;

	String getVersion();

}

