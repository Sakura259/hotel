package com.manager.hotel.model;

import lombok.Data;

import java.util.Date;

@Data
public class CostInfoDO {

    private Integer id;

    private String costName;

    private Date gmtCreate;

    private Date gmtModified;

}