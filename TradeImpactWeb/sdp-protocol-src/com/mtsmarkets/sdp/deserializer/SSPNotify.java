/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.deserializer;

import com.mtsmarkets.sdp.block.InputSDPBlock;
import com.mtsmarkets.sdp.ssp.SSPMessage;

public interface SSPNotify
{
	
	public void onMessage(SSPMessage sspMessage, InputSDPBlock inputSDPBlock);
	
}
