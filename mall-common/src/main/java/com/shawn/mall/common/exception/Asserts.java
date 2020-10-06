package com.shawn.mall.common.exception;

import com.shawn.mall.common.api.IErrorCode;

/**
 * Used to throw API exception
 */
public class Asserts {
    public static void fail(String message) {throw new ApiException(message);}

    public static void fail(IErrorCode errorCode) {throw new ApiException(errorCode);}
}
