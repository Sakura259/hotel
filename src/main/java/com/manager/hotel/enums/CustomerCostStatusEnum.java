package com.manager.hotel.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 17:22
 */
@AllArgsConstructor
@Getter
public enum CustomerCostStatusEnum {

    NOT_PAY(0, "未付款"),

    PAY(1, "已付款"),
    ;

    private Integer code;

    private String desc;
}
