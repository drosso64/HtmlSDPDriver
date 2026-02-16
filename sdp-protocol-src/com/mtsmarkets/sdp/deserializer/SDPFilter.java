/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.deserializer;

import java.util.HashSet;

public class SDPFilter
{
	
	private HashSet<Integer> values;
	
	/**
	 * Filtra le PDU SDP per id
	 * @param value da filtrare
	 * @return ritorna true nel caso la pdu da filtrare sia presente nel filtro false altrimenti
	 */
	public boolean filter(Integer value)
	{
		if (values == null)
			return true;
		else
			return values.contains(value);
	}
	
	
	public void add(int[] value)
	{
		if (values == null)
			values = new HashSet<Integer>();
		for (int i = 0; i < value.length; i++)
		{
			int j = value[i];
			values.add(j);
		}
		
	}
	
	
	public void add(Integer value)
	{
		if (values == null)
			values = new HashSet<Integer>();
		values.add(value);
	}
}
