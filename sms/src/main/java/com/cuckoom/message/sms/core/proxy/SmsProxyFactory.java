package com.cuckoom.message.sms.core.proxy;

import com.cuckoom.message.sms.core.model.Sms;
import com.cuckoom.message.sms.core.model.SmsContext;
import com.cuckoom.message.sms.core.model.SmsResult;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * 短信发送代理工厂类
 * @author cuckooM
 */
public class SmsProxyFactory {

    /** 短信发送代理 */
    private static final Map<String, SmsProxy<? extends Sms, ? extends SmsContext, ? extends SmsResult>> PROXIES =
            new HashMap<>();

    /** 短信上下文缓存 */
    private static final Map<String, SmsContext> CONTEXTS = new HashMap<>();

    /** 防止实例化 */
    private SmsProxyFactory() {
    }

    /**
     * 获取对应的短信发送代理
     * @param proxy 短信发送代理唯一标志
     * @return 短信发送代理
     * @param <T> 短信实体类型
     * @param <D> 短信上下文类型
     * @param <R> 短信发送结果
     */
    @Nullable
    public static <T extends Sms, D extends SmsContext,  R extends SmsResult> SmsProxy<T, D, R> getSmsProxy(
            @Nonnull String proxy) {
        if (PROXIES.isEmpty()) {
            refresh();
        }
        SmsProxy<T, D, R> result = (SmsProxy<T, D, R>) PROXIES.get(proxy);
        if (null != result) {
            result.setContext((D) CONTEXTS.get(proxy));
        }
        return result;
    }

    /**
     * 设置短信上下文
     * @param context 短信上下文
     */
    public static void setContext(@Nonnull SmsContext context) {
        CONTEXTS.put(context.getProxy(), context);
    }

    /**
     * 刷新短信发送代理
     */
    private static synchronized void refresh() {
        ServiceLoader<SmsProxy> proxies = ServiceLoader.load(SmsProxy.class);
        PROXIES.clear();
        for (SmsProxy smsProxy : proxies) {
            PROXIES.put(smsProxy.getClass().getName(), smsProxy);
        }
    }

}
