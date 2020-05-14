package com.manager.hotel.model;

import lombok.Data;

import java.util.Date;

@Data
public class WorkerInfoDO {
    private Integer id;

    private String workerName;

    private String wordPassword;

    private Integer departmentId;

    private Integer roleType;

    private Integer workerSex;

    private String workerIdNumber;

    private String workerPosition;

    private Double workWage;

    private Date gmtCreate;

    private Date gmtModified;
}