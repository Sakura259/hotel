package com.manager.hotel.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author haobai
 * @description:
 * @date 2020-05-17 00:42
 */
@Getter
@AllArgsConstructor
public enum FinancialEnum {

    IN(0, "收入"),

    out(1, "支出"),
    ;

    private Integer code;

    private String desc;
}
