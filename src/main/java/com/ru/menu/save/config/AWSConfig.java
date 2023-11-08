package com.ru.menu.save.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:secret.properties")
public class AWSConfig {

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.accessKey}")
    private String accessKey;

    public String getSecretKey() {
        return secretKey;
    }

    public String getAccessKey() {
        return accessKey;
    }
}