/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.deserializer;

import com.mtsmarkets.sdp.block.InputSDPBlock;
import com.mtsmarkets.sdp.sap.SAPMessage;
import com.mtsmarkets.sdp.ssp.SSPMessage;

public class SDPPublisher
{
	
	
	private SSPPublisher sspObservable = new SSPPublisher();
	private SAPPublisher sapObservable = new SAPPublisher();
	
	public void onMessage(SSPMessage sspMessage, InputSDPBlock inputSDPBlock)
	{						
		sspObservable.notifySSPMessage(sspMessage, inputSDPBlock);
		SAPMessage sapMessage = sspMessage.getSapMessage();
		if (sapMessage != null)
			sapObservable.notifySAPMessage(sspMessage.getSapMessage());					
	}
	
	public void registerSAPObserver(SAPNotify sapNotifier)
	{
		sapObservable.registerSAPObserver(sapNotifier);
	}
	
	public void registerSAPObserver(SAPNotify sapNotifier, int msgType)
	{
		sapObservable.registerSAPObserver(sapNotifier, msgType);
	}
	
	public void registerSAPObserver(SAPNotify sapNotifier, int[] msgType)
	{
		sapObservable.registerSAPObserver(sapNotifier, msgType);
	}
	
	public void registerSSPObserver(SSPNotify sspNotifier)
	{
		sspObservable.registerSSPObserver(sspNotifier);
	}
	
	public void registerSSPObserver(SSPNotify sspNotifier, int msgType)
	{
		sspObservable.registerSSPObserver(sspNotifier, msgType);
	}
	
	public void registerSSPObserver(SSPNotify sspNotifier, int[] msgType)
	{
		sspObservable.registerSSPObserver(sspNotifier, msgType);
	}
	
	/*private void  notifySSPMessage(SSPMessage sspMessage)
	{		
		FastMap<SSPNotify, SDPFilter> map = listnerSSP;
		for (FastMap.Entry<SSPNotify, SDPFilter> e = map.head(), end = map.tail(); (e = e.getNext()) != end;)
		{
			SSPNotify sspNotifier = e.getKey();
			SDPFilter sdpFilter = e.getValue();
			int receivedPduId = (int) sspMessage.getPduId().value;
			if (sdpFilter.filter(receivedPduId))				
				sspNotifier.onMessage(sspMessage);
		}
	}
	
	private void  notifySAPMessage(SAPMessage sapMessage)
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
	
	public void registerSSPObserver(SSPNotify sspNotifier)
	{
		SDPFilter sdpFilter = listnerSSP.get(sspNotifier);
		if (sdpFilter == null)
			sdpFilter = new SDPFilter();
		listnerSSP.put(sspNotifier, sdpFilter);
	}
	
	public void registerSSPObserver(SSPNotify sspNotifier, int msgType)
	{
		SDPFilter sdpFilter = listnerSSP.get(sspNotifier);
		if (sdpFilter == null)
			sdpFilter = new SDPFilter();
		sdpFilter.add(msgType);
		listnerSSP.put(sspNotifier, sdpFilter);
	}
	
	public void registerSSPObserver(SSPNotify sspNotifier, int[] msgType)
	{
		SDPFilter sdpFilter = listnerSSP.get(sspNotifier);
		if (sdpFilter == null)
			sdpFilter = new SDPFilter();
		sdpFilter.add(msgType);
		listnerSSP.put(sspNotifier, sdpFilter);
	}*/
	
}
