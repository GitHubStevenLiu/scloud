package com.t.comsumer.remote;

import com.t.comsumer.remote.feign.ProducerFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @author: liuyang
 * @datetime: 2019/6/20 0020 15:57
 */
@FeignClient(name = "${producer.service.name}/${producer.service.prefix}", url = "${producer.service.host}", configuration = ProducerFeignConfiguration.class,fallback = ProducerRemoteFallback.class)
public interface ProducerRemote {

    @GetMapping (value = "/hi", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHello(@RequestParam String s);

}
