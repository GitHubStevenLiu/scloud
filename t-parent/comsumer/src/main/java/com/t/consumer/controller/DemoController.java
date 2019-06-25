package com.t.consumer.controller;

import com.t.consumer.dto.User;
import com.t.consumer.remote.AggreRemote;
import com.t.consumer.remote.ProducerRemote;
import com.test.aggre.dto.req.UserReqDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = {"消费者demo" })
public class DemoController {


    @Autowired
    ProducerRemote producerRemote;

    @Value("${producer.service.host}")
    String host;
    @PostMapping("/demo4")
    public String demo4(@RequestBody User s) {
        System.out.println(s.getId());
        return "";
    }

    @GetMapping("/demo3")
    public String demo3() {
        return  from;
    }

    @Value("${t.from:local}")
    String from;

    @ApiOperation(value = "v", notes = "notes")
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
