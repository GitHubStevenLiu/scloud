package com.t.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @author: liuyang
 * @datetime: 2019/6/20 0020 15:42
 */
@RestController
public class ProducerController {

    @GetMapping("hi")
    public String getHello(@RequestParam String s){
        System.out.println("demo hi");
        return s+"producer2";
    }

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("demo")
    public String demo(@RequestParam String s)
    {
        List<ServiceInstance> consumer = discoveryClient.getInstances("CONSUMER");
        System.out.println(consumer);
        ServiceInstance instance = consumer.get(0);
        System.out.println(instance);
        System.out.println("demo");
        return s+"producer123";
    }

}
