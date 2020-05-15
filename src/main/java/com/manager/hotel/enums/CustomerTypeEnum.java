package com.manager.hotel.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 16:46
 */
@AllArgsConstructor
@Getter
public enum CustomerTypeEnum {

    NEW(0, "新用户"),

    OLD(1, "老用户"),
    ;


    private Integer code;

    private String desc;
}
