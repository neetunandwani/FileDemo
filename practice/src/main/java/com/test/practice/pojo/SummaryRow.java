package com.test.practice.pojo;

import com.test.practice.enums.Priority;
import com.test.practice.enums.TransactionType;

import java.time.Instant;

public class SummaryRow {
    private String clientId;
    private String securityId;
    private TransactionType type;
    private Instant date;
    private Priority priority;
    private Long fee = 0L;

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "SummaryRow{" +
            "clientId='" + clientId + '\'' +
            "securityId='" + securityId + '\'' +
            ", type=" + type +
            ", date=" + date +
            ", priority=" + priority +
            ", fee=" + fee +
            '}';
    }
}
