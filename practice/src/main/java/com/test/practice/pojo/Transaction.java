package com.test.practice.pojo;

import com.test.practice.enums.Priority;
import com.test.practice.enums.TransactionType;

import java.time.Instant;

public class Transaction {
    private String id;
    private String clientId;
    private String securityId;
    private Instant date;
    private TransactionType type;
    private Priority priority;
    private Long fee;
    private String key;

    public String getKey() {
        return clientId + securityId + date.toString();
    }

    public String getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId.toUpperCase();
    }

    public Instant getDate() {
        return date;
    }

    public Priority getPriority() {
        return priority;
    }

    public TransactionType getType() {
        return type;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public void setType(TransactionType type) {
        this.type = type;
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
        return "Transaction{" +
            "id='" + id + '\'' +
            ", clientId='" + clientId + '\'' +
            ", securityId='" + securityId + '\'' +
            ", date=" + date +
            ", type=" + type +
            ", priority=" + priority +
            '}';
    }
}
