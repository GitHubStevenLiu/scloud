package com.t.comsumer.remote.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author nathan
 * @version V1.0
 * @Title: crm
 * @Description: 描述
 **/
public class ProducerFeignConfiguration {

    private static Logger logger = LoggerFactory.getLogger(ProducerFeignConfiguration.class);

    @Value("${producer.service.verifyCode}")
    private String crmToken;

    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        if (logger.isDebugEnabled()) {
            logger.debug("stockToken:" + crmToken);
        }
        return new FeignBasicAuthRequestInterceptor(crmToken, "CRM");
    }

}
