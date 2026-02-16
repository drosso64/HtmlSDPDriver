package com.mtsmarkets.sdp.sap;



public enum SAPServiceType

{

	IP_Request(0),

	TXN(1),

	INFO_BRT(2),

	INFO_PRIV(3),

	TXN_INFO_PRIV(4),

	DATA_FEED(5),

	QUERY(6),

	RECOVERY_INFO_BRT(7),

	RECOVERY_INFO_PRIV(8),

	RECOVERY_DATA_FEED(9),

	RECOVERY_PRESS(10),

	RECOVERY_ALL(11),

	ALL(99);



	SAPServiceType(int value)

	{

	}

}

