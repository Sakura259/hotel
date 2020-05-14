package com.manager.hotel.model;

import lombok.Data;

import java.util.Date;

@Data
public class RoomDO {
    private Integer id;

    private Integer roomId;

    private Integer roomType;

    private Integer stayStatus;

    private Integer cleanStatus;

    private Double roomPrice;

    private Date gmtCreate;

    private Date gmtModified;
}