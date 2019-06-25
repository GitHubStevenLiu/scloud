package com.test.aggre.controller;

import com.test.aggre.dto.req.UserReqDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: liuyang
 * @datetime: 2019/6/21 0021 16:14
 */
@RestController
public class AggreController {

    @PostMapping("demo")
    public String demo(@RequestBody UserReqDto s)
    {
        System.out.println(s);
        return s+"AggreController";
    }
    @GetMapping("/demo3")
    public String demo3() {
        return  from;
    }

    @Value("${t.from:local}")
    String from;
}
