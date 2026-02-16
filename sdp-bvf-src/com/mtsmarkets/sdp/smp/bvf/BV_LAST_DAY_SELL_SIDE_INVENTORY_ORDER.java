package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_LAST_DAY_SELL_SIDE_INVENTORY_ORDER extends SMPMessage
{
	public static final long CLASS_ID = 114533;

	private BV_HIST_SELL_SIDE_INVENTORY_ORDER Order = new BV_HIST_SELL_SIDE_INVENTORY_ORDER();

	public BV_LAST_DAY_SELL_SIDE_INVENTORY_ORDER()
	{
	}

	public BV_HIST_SELL_SIDE_INVENTORY_ORDER getOrder()
	{
		return Order;
	}
	public void setOrder(BV_HIST_SELL_SIDE_INVENTORY_ORDER value)
	{
		Order = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Order.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Order.writeXDR(byteBuffer);

		return byteBuffer.position() - init;
	}
	@Override
	public long getSMPClassId()
	{
		return CLASS_ID;
	}
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(1024);
		stringBuilder.append("BV_LAST_DAY_SELL_SIDE_INVENTORY_ORDER::");
		stringBuilder.append("Order(").append(Order.toString()).append(")");
		return stringBuilder.toString();
	}
}
