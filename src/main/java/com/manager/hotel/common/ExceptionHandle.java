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

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultModel handle(Exception e){
        if(e instanceof CommonException){
            CommonException commonException = (CommonException) e;
            return ResultModel.fail(commonException);
        }else if (e instanceof MethodArgumentNotValidException){
            String message = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().get(0).getDefaultMessage();
            return ResultModel.fail(CommonErrorCode.DATA_VALIDED, message);
        }
        return ResultModel.fail(CommonErrorCode.DATA_VALIDED, "111");
    }
}
