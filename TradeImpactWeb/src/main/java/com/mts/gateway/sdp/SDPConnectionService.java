package com.mts.gateway.sdp;

import com.mts.gateway.rest.dto.TransactionRequest;
import com.mts.gateway.rest.dto.AddressServiceRequest;

public interface SDPConnectionService {
    long sendMonitoredAction(TransactionRequest req);
    long requestAddressService(AddressServiceRequest req);
}
