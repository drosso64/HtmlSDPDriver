/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.deserializer;

import com.mtsmarkets.sdp.block.InputSDPBlock;
import com.mtsmarkets.sdp.ssp.SSPMessage;
import javolution.util.FastMap;

public class SSPPublisher
{
	private FastMap<SSPNotify, SDPFilter> listnerSSP = new FastMap<SSPNotify, SDPFilter>();
	
	public void  notifySSPMessage(SSPMessage sspMessage, InputSDPBlock inputSDPBlock)
	{		
		FastMap<SSPNotify, SDPFilter> map = listnerSSP;
		for (FastMap.Entry<SSPNotify, SDPFilter> e = map.head(), end = map.tail(); (e = e.getNext()) != end;)
		{
			SSPNotify sspNotifier = e.getKey();
			SDPFilter sdpFilter = e.getValue();
			int receivedPduId = (int) sspMessage.getPduId().value;
			if (sdpFilter.filter(receivedPduId))				
				sspNotifier.onMessage(sspMessage, inputSDPBlock);
		}
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
	}
	
}
