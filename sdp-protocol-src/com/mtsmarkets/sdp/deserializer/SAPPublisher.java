/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.deserializer;

import com.mtsmarkets.sdp.sap.SAPMessage;
import javolution.util.FastMap;


public class SAPPublisher
{
	
	private FastMap<SAPNotify, SDPFilter> listnerSAP = new FastMap<SAPNotify, SDPFilter>();
	
	public void  notifySAPMessage(SAPMessage sapMessage)
	{		
		FastMap<SAPNotify, SDPFilter> map = listnerSAP;
		for (FastMap.Entry<SAPNotify, SDPFilter> e = map.head(), end = map.tail(); (e = e.getNext()) != end;)
		{
			SAPNotify sapNotifier = e.getKey();
			SDPFilter sdpFilter = e.getValue();
			int receivedPduId = (int) sapMessage.getMessageType();
			if (sdpFilter.filter(receivedPduId))				
				sapNotifier.onMessage(sapMessage);
		}
	}
	
	
	public void registerSAPObserver(SAPNotify sapNotifier)
	{		
		SDPFilter sdpFilter = listnerSAP.get(sapNotifier);
		if (sdpFilter == null)
			sdpFilter = new SDPFilter();
		listnerSAP.put(sapNotifier, sdpFilter);
	}
	
	public void registerSAPObserver(SAPNotify sapNotifier, int msgType)
	{
		SDPFilter sdpFilter = listnerSAP.get(sapNotifier);
		if (sdpFilter == null)
			sdpFilter = new SDPFilter();
		sdpFilter.add(msgType);
		listnerSAP.put(sapNotifier, sdpFilter);
	}
	
	public void registerSAPObserver(SAPNotify sapNotifier, int[] msgType)
	{
		SDPFilter sdpFilter = listnerSAP.get(sapNotifier);
		if (sdpFilter == null)
			sdpFilter = new SDPFilter();
		sdpFilter.add(msgType);
		listnerSAP.put(sapNotifier, sdpFilter);
	}
	
}
