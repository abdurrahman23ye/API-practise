package com.techproed.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ExpectedDataDummy {


   private String status;
    private DummyApiPostRequestBody data;
    private String message;

    public ExpectedDataDummy(String status, DummyApiPostRequestBody data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public ExpectedDataDummy() {
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

    public DummyApiPostRequestBody getData() {
        return data;
    }

    public void setData(DummyApiPostRequestBody data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
