package com.manager.hotel.model;

import lombok.Data;

import java.util.Date;

@Data
public class FinancialDO {
    private Integer id;

    private String name;

    private Double value;

    private Integer status;

    private Date gmtCreate;

    private Date gmtModified;

}