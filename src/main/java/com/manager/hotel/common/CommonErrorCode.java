/*
 *
 *  Copyright 2020 byai.com All right reserved. This software is the
 *  confidential and proprietary information of byai.com ("Confidential
 *  Information"). You shall not disclose such Confidential Information and shall
 *  use it only in accordance with the terms of the license agreement you entered
 *  into with byai.com.
 * /
 */

package com.manager.hotel.common;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonErrorCode implements IErrorCode {

    SUCCESS(200, "执行成功"),

    DATA_VALIDED(10000001, "数据校验错误"),

    RESOURCE_NOT_FOUND(404, "资源不存在"),

    UNKNOWN_ERROR(500, "未知错误"),

    RESOURCE_EXIT(10000000, "资源已存在"),
    ;

    private int code;

    private String Message;
}