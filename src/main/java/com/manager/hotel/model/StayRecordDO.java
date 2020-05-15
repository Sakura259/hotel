package com.manager.hotel.model;

import lombok.Data;

import java.util.Date;

@Data
public class StayRecordDO {

    private Integer id;

    private Integer customerId;

    private String customerName;

    private Integer customerType;

    private Integer roomId;

    private Integer roomType;

    private Date reserveTime;

    private Date reserveOutTime;

    private Date outTime;

    private Integer costStatus;

    private Date gmtCreate;

    private Date gmtModified;
}