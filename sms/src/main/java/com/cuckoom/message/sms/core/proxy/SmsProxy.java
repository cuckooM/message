package com.cuckoom.message.sms.core.proxy;

import com.cuckoom.message.sms.core.exception.ErrorCodeEnum;
import com.cuckoom.message.sms.core.exception.SmsException;
import com.cuckoom.message.sms.core.model.Sms;
import com.cuckoom.message.sms.core.model.SmsContext;
import com.cuckoom.message.sms.core.model.SmsResult;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * 短信发送代理
 * @param <T> 短信实体类型
 * @param <D> 短信上下文类型
 * @param <R> 短信发送结果
 * @author cuckooM
 */
public interface SmsProxy<T extends Sms, D extends SmsContext, R extends SmsResult> {

    /**
     * 获取短信上下文
     * @return 短信上下文
     */
    @Nullable
    D getContext();

    /**
     * 设置短信上下文
     * @param context 短信上下文
     */
    void setContext(@Nonnull D context);

    /**
     * 发送短信
     * @param context 短信上下文
     * @param sms 短信对象
     * @return 结果
     */
    @Nonnull
    R send(@Nonnull D context, @Nonnull T sms);

    /**
     * 发送短信
     * @param sms 短信对象
     * @return 结果
     */
    default R send(@Nonnull T sms) {
        D context = getContext();
        if (null == context) {
            throw new SmsException(ErrorCodeEnum.PLAT_SETTING_ERROR);
        }
        return send(context, sms);
    }

}
