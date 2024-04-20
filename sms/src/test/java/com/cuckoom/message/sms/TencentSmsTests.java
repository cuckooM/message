package com.cuckoom.message.sms;

import com.cuckoom.message.sms.config.TestConfiguration;
import com.cuckoom.message.sms.core.SmsSender;
import com.cuckoom.message.sms.core.proxy.SmsProxyFactory;
import com.cuckoom.message.sms.properties.TecentProperties;
import com.cuckoom.message.sms.tencent.model.TencentSms;
import com.cuckoom.message.sms.tencent.model.TencentSmsContext;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * 腾讯云短信测试用例
 */
@SpringBootTest
@ContextConfiguration(classes = TestConfiguration.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TencentSmsTests {

    /** 腾讯云短信配置 */
    @Autowired
    private TecentProperties tecentProperties;

    /**
     * 测试发送短信
     */
    @Test
    void send() {
        TencentSmsContext context = new TencentSmsContext();
        context.setSecretId(tecentProperties.getSecretId());
        context.setSecretKey(tecentProperties.getSecretKey());
        context.setSdkAppId(tecentProperties.getSdkAppId());
        context.setRegion(tecentProperties.getRegion());
        SmsProxyFactory.setContext(context);

        TencentSms sms = new TencentSms();
        sms.setSignName(tecentProperties.getSignName());
        sms.setTemplateId(tecentProperties.getTemplateId());
        sms.setTemplateParams(tecentProperties.getTemplateParams());
        sms.setPhoneNumbers(tecentProperties.getPhoneNumbers());
        SmsSender.send(sms);
    }

}
