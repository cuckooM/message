package com.cuckoom.message.sms.core.exception;

import lombok.Getter;

import java.io.Serial;

/**
 * 短信异常
 * @author cuckooM
 */
@Getter
public class SmsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 3821416718541837199L;

    /** 错误代码 */
    private final String errorCode;

    /**
     * 构造函数
     * @param errorCodeEnum 错误码
     * @param params 错误参数
     */
    public SmsException(ErrorCodeEnum errorCodeEnum, Object... params) {
        super();
        this.errorCode = errorCodeEnum.getErrorCode();
    }

}
