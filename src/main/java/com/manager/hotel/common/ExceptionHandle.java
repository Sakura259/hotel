package com.manager.hotel.common;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 00:26
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = CommonException.class)
    @ResponseBody
    public ResultModel handle1(Exception e) {
        CommonException commonException = (CommonException) e;
        return ResultModel.fail(commonException);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultModel handle2(Exception e) {
        String message = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ResultModel.fail(CommonErrorCode.DATA_VALIDED, message);
    }
}
