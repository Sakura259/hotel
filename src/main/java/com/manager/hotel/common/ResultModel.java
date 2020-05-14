package com.manager.hotel.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

import static com.manager.hotel.common.CommonErrorCode.SUCCESS;

/**
 * @author haobai
 * @description:
 * @date 2020-05-14 23:40
 */
public class ResultModel<T> {

    private int code = SUCCESS.getCode();
    private T data;
    private String resultMsg = SUCCESS.getMessage();
    private String errorStackTrace;
    private String requestId;

    private static ResultModel SUCCESS_RESULT_MODEL = ResultModel.success(null);

    public static ResultModel success() {

        return SUCCESS_RESULT_MODEL;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return code == SUCCESS.getCode();
    }

    public static <T> ResultModel<T> success(T data) {
        return success(data, SUCCESS.getMessage());
    }

    public static <T> ResultModel<T> success(T data, String msg) {
        return new ResultModel<>(SUCCESS.getCode(), data, msg, null);
    }

    public static <T> ResultModel<T> fail(CommonException ex) {
        String resultMsg = ex.getErrMsg();
        if (StringUtils.isNotEmpty(ex.getErrMsg())) {
            resultMsg = ex.getErrMsg();
        }
        return new ResultModel<>(ex.getCode(), null, resultMsg, ex.getMessage());
    }

    public static <T> ResultModel<T> fail(CommonException ex, T data) {
        String resultMsg = ex.getErrMsg();
        if (StringUtils.isNotEmpty(ex.getErrMsg())) {
            resultMsg = ex.getErrMsg();
        }
        return new ResultModel<>(ex.getCode(), data, resultMsg, ex.getMessage());
    }

    public static <T> ResultModel<T> fail(CommonErrorCode error) {
        return new ResultModel<>(error.getCode(), null, error.getMessage(), null);
    }

    public static <T> ResultModel<T> fail(CommonErrorCode error, String msg) {
        return new ResultModel<>(error.getCode(), null, msg, null);
    }

    public static <T> ResultModel<T> fail(int error, T data, String msg) {
        return new ResultModel<>(error, data, msg, null);
    }

    public static <T> ResultModel<T> fail(CommonErrorCode error, Throwable ex) {
        return new ResultModel<>(error.getCode(), null, error.getMessage(), ex.getMessage());
    }

    public static <T> ResultModel<T> fail(CommonErrorCode error, String msg, Throwable ex) {
        return new ResultModel<>(error.getCode(), null, msg, ex.getMessage());
    }

    public ResultModel(int code, T data, String resultMsg, String errorStackTrace) {
        this.code = code;
        this.data = data;
        this.resultMsg = resultMsg;
        this.errorStackTrace = errorStackTrace;
    }

    public int getCode() {
        return code;
    }

    public String getErrorStackTrace() {
        return errorStackTrace;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public T getData() {
        return data;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}

