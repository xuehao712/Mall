package com.shawn.mall.common.exception;

import com.shawn.mall.common.api.IErrorCode;

/**
 * Customize API exception
 */
public class ApiException extends RuntimeException{
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message){super(message);}

    public ApiException(Throwable cause){super(cause);}

    public ApiException(String message,Throwable cause){super(message,cause);}

    public IErrorCode getErrorCode() {return  errorCode;}
}
