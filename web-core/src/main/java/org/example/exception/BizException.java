package org.example.exception;

import org.example.model.enums.BaseErrorCodeEnum;

public class BizException extends RuntimeException {

    private int code;

    private Object data;

    public BizException() {
        super(BaseErrorCodeEnum.SYSTEM_ERROR.getMsg());
        this.code = BaseErrorCodeEnum.SYSTEM_ERROR.getCode();
    }

    public BizException(int code) {
        super();
        this.code = code;
    }

    public BizException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(String message) {
        super(message);
        this.code = BaseErrorCodeEnum.SYSTEM_ERROR.getCode();
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.code = BaseErrorCodeEnum.SYSTEM_ERROR.getCode();
    }

    public BizException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BizException(int code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    public BizException(int code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public BizException(String message, Object data) {
        super(message);
        this.code = BaseErrorCodeEnum.SYSTEM_ERROR.getCode();
        this.data = data;
    }

    public BizException(String message, Throwable cause, Object data) {
        super(message, cause);
        this.code = BaseErrorCodeEnum.SYSTEM_ERROR.getCode();
        this.data = data;
    }

    public BizException(String message, int code, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public int getErrorCode() {
        return code;
    }

    public Object getErrorData() {
        return data;
    }
}
