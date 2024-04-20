package com.cuckoom.message.sms.config;

import com.cuckoom.message.sms.properties.TecentProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 测试配置
 */
@Configuration
@EnableConfigurationProperties(TecentProperties.class)
public class TestConfiguration {
}
