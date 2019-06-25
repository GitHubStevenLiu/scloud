package com.t.comsumer.controller;

import com.t.comsumer.remote.AggreRemote;
import com.t.comsumer.remote.ProducerRemote;
import com.test.aggre.dto.req.UserReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @author: liuyang
 * @datetime: 2019/6/19 0019 14:52
 */
@RestController
@RefreshScope //开启更新功能
public class DemoController {

    @Autowired
    ProducerRemote producerRemote;

    @Value("${producer.service.host}")
    String host;

    @GetMapping("/demo3")
    public String demo3() {
        return  from;
    }

    @Value("${t.from:local}")
    String from;

    @GetMapping("/demo2")
    public String demo2(@RequestParam  String s) {
        System.out.println(producerRemote);
        System.out.println(producerRemote);
        System.out.println(producerRemote);
        System.out.println(host);
        String hello = producerRemote.getHello(s);
        System.out.println(hello);
        return hello;
    }


    @Autowired
    AggreRemote aggreRemote;

    @PostMapping("/demo")
    public String demo(@RequestBody UserReqDto s) {
        String hello = aggreRemote.demo(s);
        System.out.println(hello);
        return hello;
    }


}
