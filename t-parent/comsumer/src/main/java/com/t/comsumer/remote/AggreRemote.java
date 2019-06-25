package com.t.comsumer.remote;

import com.t.comsumer.remote.feign.ProducerFeignConfiguration;
import com.test.aggre.dto.req.UserReqDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description:
 * @author: liuyang
 * @datetime: 2019/6/20 0020 15:57
 */
@FeignClient(name = "${aggre.service.name}/${aggre.service.prefix}", url = "${aggre.service.host}", configuration = ProducerFeignConfiguration.class)
public interface AggreRemote {

    @PostMapping(value = "demo")
    public String demo(@RequestBody UserReqDto s);

}
