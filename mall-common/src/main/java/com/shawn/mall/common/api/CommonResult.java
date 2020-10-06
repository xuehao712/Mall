package com.shawn.mall.common.api;

/**
 * Common return target
 */
public class CommonResult<T> {
     private long code;
     private String message;
     private T data;

     protected CommonResult(){
     }

     protected CommonResult(long code,String message,T data){
         this.code = code;
         this.message = message;
         this.data = data;
     }
    /**
     * Successful return result
     *
     * @param data result
     */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * Successful return result
     *
     * @param data result
     * @param message
     */
    public static <T> CommonResult<T> success(T data,String message){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }

    /**
     * Failed return result
     *
     * @param errorCode
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode){
        return new CommonResult<T>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    /**
     * Failed return result
     *
     * @param errorCode
     * @param message
     */
    public static<T> CommonResult<T> failed(IErrorCode errorCode,String message){
        return new CommonResult<T>(errorCode.getCode(),message,null);
    }

    /**
     * Failed return result
     *
     * @param message
     */
    public static<T>CommonResult<T> failed(String message){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),message,null);
    }

    /**
     * Failed return result
     */
    public static <T> CommonResult<T> failed(){
        return failed(ResultCode.FAILED);
    }

    /**
     * Failed validation return result
     */
    public static <T>CommonResult<T> validateFailed(){
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * Failed validation return result
     * @param message
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * Failed logging
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * Failed authorization
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
