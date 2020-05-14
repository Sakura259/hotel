package com.manager.hotel.model;

import lombok.Data;

import java.util.Date;

@Data
public class WorkerDO {
    private Integer id;

    private String name;

    private String password;

    private Integer roleType;

    private Integer sex;

    private String idNumber;

    private Integer wage;

    private Date gmtCreate;

    private Date gmtModified;

}