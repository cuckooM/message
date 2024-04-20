package com.cuckoom.message.sms.core;

import com.cuckoom.message.sms.core.model.SmsContext;
import com.cuckoom.message.sms.core.proxy.SmsProxy;
import com.cuckoom.message.sms.core.proxy.SmsProxyFactory;
import com.cuckoom.message.sms.core.exception.ErrorCodeEnum;
import com.cuckoom.message.sms.core.exception.SmsException;
import com.cuckoom.message.sms.core.model.Sms;
import com.cuckoom.message.sms.core.model.SmsReult;
import jakarta.annotation.Nonnull;

/**
 * 短信发送
 * @author cuckooM
 */
public class SmsSender {

    /** 防止实例化 */
    private SmsSender() {
    }

    /**
     * 发送短信
     * @param sms 短信实体对象
     * @return 结果
     * @param <T> 短信实体类型
     * @param <D> 短信上下文类型
     * @throws SmsException 异常
     */
    @Nonnull
    public static <T extends Sms, D extends SmsContext> SmsReult send(@Nonnull T sms) throws SmsException {
        SmsProxy<T, D> smsProxy = SmsProxyFactory.getSmsProxy(sms.getProxy());
        if (null == smsProxy) {
            throw new SmsException(ErrorCodeEnum.PLAT_NOT_EXISTS);
        }
        return smsProxy.send(sms);
    }

    /**
     * 发送短信
     * @param context 上下文
     * @param sms 短信实体对象
     * @return 结果
     * @param <T> 短信实体类型
     * @param <D> 短信上下文类型
     * @throws SmsException 异常
     */
    @Nonnull
    public static <T extends Sms, D extends SmsContext> SmsReult send(@Nonnull D context, @Nonnull T sms)
            throws SmsException {
        SmsProxy<T, D> smsProxy = SmsProxyFactory.getSmsProxy(sms.getProxy());
        if (null == smsProxy) {
            throw new SmsException(ErrorCodeEnum.PLAT_NOT_EXISTS);
        }
        return smsProxy.send(context, sms);
    }

}
