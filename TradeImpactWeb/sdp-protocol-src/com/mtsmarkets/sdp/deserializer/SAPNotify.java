/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.deserializer;

import com.mtsmarkets.sdp.sap.SAPMessage;


public interface SAPNotify
{
	public void onMessage(SAPMessage sapMessage);
}
