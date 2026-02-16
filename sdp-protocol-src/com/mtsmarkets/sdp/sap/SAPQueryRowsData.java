package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.smp.SMPMessage;
import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;





public class SAPQueryRowsData extends SAPMessage {



	public static final int  MSG_TYPE = 244;

	

	protected ULong queryKey = new ULong(0);

	protected ULong rowNumber = new ULong(0);

	protected ULong queryDataClassId = new ULong(0);

	protected SMPMessage smpMessage = null;

	private MarketFactory mktFactory;

	

	public SAPQueryRowsData(SAPHeader sapHeader, MarketFactory mktFactory)

	{

		super(sapHeader);

		this.mktFactory = mktFactory;

	}



	@Override

	public void readBodyXDR(XDRByteBuffer byteBuffer) throws Exception

	{

		queryKey.setValue(byteBuffer.readInt());

		rowNumber.setValue(byteBuffer.readInt());

		queryDataClassId.setValue(byteBuffer.readInt());

		if(queryDataClassId.getValue() != 0)

		{

			smpMessage = mktFactory.createSMPMessage(queryDataClassId);

			smpMessage.readXDR(byteBuffer);

		}

	}

	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception

	{

		throw new Exception("SAPQueryRowsData can be only read from client side");

	}

	@Override

	public String toString()

	{

		StringBuilder strBd = new StringBuilder()

		.append("SAPQueryRowsData::")

		.append("MsgType(").append(getMessageType()).append(")")

		.append("QueryKey(").append(queryKey.getValue()).append(")")

		.append("RowNumber(").append(rowNumber.getValue()).append(")")

		.append("QueryDataClassId(").append(queryDataClassId.getValue()).append(")");

		return strBd.toString();

	}

	

	public ULong getRowNumber() {

		return rowNumber;

	}



	public void setRowNumber(ULong rowNumber) {

		this.rowNumber = rowNumber;

	}



	public ULong getQueryDataClassId() {

		return queryDataClassId;

	}



	public void setQueryDataClassId(ULong queryDataClassId) {

		this.queryDataClassId = queryDataClassId;

	}



	public SMPMessage getSmpMessage() {

		return smpMessage;

	}



	public void setSmpMessage(SMPMessage smpMessage) {

		this.smpMessage = smpMessage;

	}



	public ULong getQueryKey() {

		return queryKey;

	}



	public void setQueryKey(ULong queryKey) {

		this.queryKey = queryKey;

	}





}

