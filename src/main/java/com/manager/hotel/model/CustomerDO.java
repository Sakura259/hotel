package com.manager.hotel.model;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDO {

    private Integer id;

    private String customerName;

    private String phone;

    private Integer sex;

    private String idNumber;

    private Integer customerType;

    private Date gmtCreate;

    private Date gmtModified;

}