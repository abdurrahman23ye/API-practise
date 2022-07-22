package com.techproed.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ExpectedDataDummyDel {


   private String status;
    private int data;
    private String message;

    public ExpectedDataDummyDel(String status, int data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public ExpectedDataDummyDel() {
    }

    @Override
    public String toString() {
        return "ExpectedDataDummy{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
