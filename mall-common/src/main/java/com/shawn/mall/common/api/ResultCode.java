package com.shawn.mall.common.api;

/**
 * Some common API code
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200,"Success"),
    FAILED(500,"Failure"),
    VALIDATE_FAILED(404,"Validation Error"),
    UNAUTHORIZED(401,"Not logged in or token expired"),
    FORBIDDEN(403,"No authorization");


    private long code;
    private String message;

    private ResultCode(long code,String message){
        this.code = code;
        this.message = message;
    }

    public long getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
