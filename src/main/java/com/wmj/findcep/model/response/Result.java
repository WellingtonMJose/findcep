package com.wmj.findcep.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
    private String message;

    private T data;

    private HttpStatus httpStatus;
    public Result(String message, T data, HttpStatus httpStatus) {
        this.message = message;
        this.data = data;
        this.httpStatus = httpStatus;
    }

    public Result() {
        this.message = new String();
        this.data = null;

    }
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void addMessage(String message) {
        this.message = this.message + message;}

    public void addData(T data) {this.data = data;}

    public void addHttpStatus(HttpStatus httpStatus) {this.httpStatus = httpStatus;}
}
