package com.manager.hotel.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author haobai
 * @description:
 * @date 2020-05-14 23:55
 */
@Data
public class WorkerLoginVO {

    @NotBlank(message = "用户名不能为空")
    private String name;

    @NotBlank(message = "密码不能为空")
    private String password;

}
