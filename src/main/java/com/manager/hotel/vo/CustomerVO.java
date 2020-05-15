package com.manager.hotel.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 02:27
 */
@Data
public class CustomerVO extends BaseVO {

    @NotBlank(message = "客户名不能为空")
    private String customerName;

    @NotBlank(message = "客户电话不能为空")
    private String phone;

    @NotNull(message = "客户性别不能为空")
    private Integer sex;

    @NotBlank(message = "身份证号不能为空")
    private String idNumber;

    @NotBlank(message = "客户类型不能为空")
    private Integer customerType;
}
