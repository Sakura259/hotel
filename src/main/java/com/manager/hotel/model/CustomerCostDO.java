package com.manager.hotel.model;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerCostDO {

    private Integer id;

    private Integer recordId;

    private Integer costId;

    private Double costValue;

    private Double discount;

    private Integer status;

    private Date gmtCreate;

    private Date gmtModified;
}