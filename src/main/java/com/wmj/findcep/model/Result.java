package com.wmj.findcep.model;

public class Result<T> {
    private String message;

    private Object data;

    public Result(String message) {
        this.message = message;
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result() {
        this.message = new String();
        this.data = new Object();
    }
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void addMessage(String message) {
        this.message = this.message + message;}

    public void addData(Object data) {this.data = data;}
}
