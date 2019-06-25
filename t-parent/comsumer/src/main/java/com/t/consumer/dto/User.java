package com.t.consumer.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @author: liuyang
 * @datetime: 2019/6/25 0025 17:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ApiModelProperty(name = "abc",value = "abc1")
    private Integer id;
    private String name;

}