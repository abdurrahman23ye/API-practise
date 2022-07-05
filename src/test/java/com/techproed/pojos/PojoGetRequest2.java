package com.techproed.pojos;

public class PojoGetRequest2 {



private String status;
private String message;
private PojoGetRequest1 data;

    public PojoGetRequest2(String status, String message, PojoGetRequest1 data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public PojoGetRequest2() {
    }

    @Override
    public String toString() {
        return "PojoGetRequest2{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PojoGetRequest1 getData() {
        return data;
    }

    public void setData(PojoGetRequest1 data) {
        this.data = data;
    }
}
