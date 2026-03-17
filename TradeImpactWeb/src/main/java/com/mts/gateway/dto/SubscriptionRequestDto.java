package com.mts.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO representing a subscription request aligned with SAPSubscribeStartReq PDU fields.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionRequestDto {
    private String username;     // requesting user
    private Long reqId;          // optional request id
    private String subscribeType; // e.g., "All", "Stop", "OnTime"
    private Long classId;        // SMP class id
    private Long classVer;       // class version
    private Long startTs0;       // start timestamp part 0
    private Long startTs1;       // start timestamp part 1
    private Long filterKey;      // optional filter key
    private String subMask;      // optional subscription mask (hex/base64)
}
