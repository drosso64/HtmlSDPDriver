/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.block;

import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.ssp.SSPMessage;
import javolution.util.FastList;


public interface ProcessableSDPBlock
{
	FastList<SSPMessage> processBlock(OutputSDPBlock outputSDPBlock);
	FastList<SSPMessage> processBlock(InputSDPBlock inputSDPBlock);
	String getKey();
	MarketFactory getMktFactory();
}
