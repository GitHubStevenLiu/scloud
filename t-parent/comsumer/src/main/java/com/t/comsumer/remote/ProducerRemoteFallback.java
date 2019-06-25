package com.t.comsumer.remote;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: liuyang
 * @datetime: 2019/6/20 0020 15:57
 */
@Component
public class ProducerRemoteFallback  implements ProducerRemote {


    @Override
    public String getHello(String s) {
        return s+"___fallback";
    }
}
