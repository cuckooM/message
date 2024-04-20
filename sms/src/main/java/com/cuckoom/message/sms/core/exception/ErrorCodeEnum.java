package com.cuckoom.message.sms.core.exception;

import lombok.Getter;

/**
 * 错误码枚举
 * @author cuckooM
 */
@Getter
public enum ErrorCodeEnum {

    /** 短信平台不存在 */
    PLAT_NOT_EXISTS("plat_not_exists"),

    /** 短信平台配置错误 */
    PLAT_SETTING_ERROR("plat_setting_error");

    /** 错误码 */
    private final String errorCode;

    /**
     * 构造函数
     * @param errorCode 错误码
     */
    ErrorCodeEnum(String errorCode) {
        this.errorCode = errorCode;
    }

}
