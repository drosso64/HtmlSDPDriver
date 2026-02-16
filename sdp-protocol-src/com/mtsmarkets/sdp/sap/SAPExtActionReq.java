/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.smp.SMPMessage;

public class SAPExtActionReq extends SAPActionReq {
    
    public static final int MSG_TYPE = 217;
       
    
	public SAPExtActionReq(SAPHeader sapHeader, MarketFactory mktFactory) {
		super(sapHeader, mktFactory);		
	}
    
    public SAPExtActionReq(SMPMessage smpMessage) {
		super(smpMessage, MSG_TYPE);				
	}
    
    @Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SAPExtActionReq::")
		.append("ReqId(").append(reqId.getValue()).append(")")
		.append("ClassId(").append(classId.getValue()).append(")")
		.append("KeyId(").append(keyId.getValue()).append(")")
		.append("Action(").append(action).append(")")
		.append("TransId0(").append(transId[0].getValue()).append(")")
		.append("TransId1(").append(transId[1].getValue()).append(")")
		.append("DataInResponse(").append(dataInResponse).append(")");
		return str.toString();
	}
    
}
