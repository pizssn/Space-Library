package com.pizssn.sl.result;

import lombok.Data;

@Data
public class Result {
    //响应码
    private int code;
    private String message;
    private Object result;

    public Result(int code,String message,Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
}
