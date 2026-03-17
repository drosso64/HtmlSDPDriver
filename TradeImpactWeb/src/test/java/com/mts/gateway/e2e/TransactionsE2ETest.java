package com.mts.gateway.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mts.gateway.dto.TransactionRequest;
import com.mts.gateway.dto.TransactionResponse;
import com.mts.gateway.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
    controllers = com.mts.gateway.controller.TransactionController.class
)
@AutoConfigureMockMvc(addFilters = false)
public class TransactionsE2ETest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TransactionService transactionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void postTransaction_monitored_flow_ok() throws Exception {
        TransactionResponse mockResponse = TransactionResponse.success("ok", 12345L);
        when(transactionService.executeMonitoredTransaction(eq("BV"), any())).thenReturn(mockResponse);

        TransactionRequest req = new TransactionRequest();
        req.setUsername("tester");
        req.setMarket("BV");
        req.setClassId(114809L);
        req.setAction(TransactionRequest.TransactionAction.ADD);
        req.setData(Map.of("InstrumentId", 555L, "Quantity", 1000));

        mvc.perform(post("/api/markets/BV/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.success").value(true))
            .andExpect(jsonPath("$.transactionId").value(12345));
    }
}
