package com.manager.hotel.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 00:16
 */
@Data
public class WorkerVO extends BaseVO {

    @NotBlank(message = "用户名不能为空")
    private String name;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotNull(message = "权限不能为空")
    private Integer roleType;
    @NotNull(message = "性别不能为空")
    private Integer sex;
    @NotBlank(message = "身份证不能为空")
    private String idNumber;
    @NotNull(message = "工资不能为空")
    private Integer wage;
}
