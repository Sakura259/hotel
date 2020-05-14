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


import lombok.Data;

@Data
public class CommonException extends RuntimeException {
    private static final long serialVersionUID = 7840819723316676966L;

    protected String errMsg;
    protected String detailMsg;
    protected Integer code;
    protected Object data;

    public CommonException(IErrorCode errorInfo) {
        this.code = errorInfo.getCode();
        this.errMsg = errorInfo.getMessage();
    }

    public CommonException(IErrorCode errorInfo, Exception e) {
        super(errorInfo.getMessage(), e);
        this.code = errorInfo.getCode();
        this.errMsg = errorInfo.getMessage();
    }


    public CommonException(IErrorCode errorInfo, String msg) {
        this.code = errorInfo.getCode();
        this.errMsg = errorInfo.getMessage() + ":" + msg;
    }

    public CommonException(Integer code, String msg) {
        this.code = code;

    }

    public CommonException(IErrorCode errorInfo, String msg, Exception e) {
        super(errorInfo.getMessage(), e);
        this.code = errorInfo.getCode();
        this.errMsg = errorInfo.getMessage() + ":" + msg;
    }
}
