package com.manager.hotel.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 18:02
 */
@Data
public class StayRecordVO {

    private Integer id;

    private CustomerVO customerVO;
    /**
     * 房间id
     */
    private Integer roomId;
    /**
     * 房间类型
     */
    private Integer roomType;
    /**
     * 已付金额
     */
    private Double payNum;
    /**
     * 未付金额
     */
    private Double notPayNum;
    /**
     * 预定入住时间
     */
    private Date reserveTime;
    /**
     * 预定退房时间
     */
    private Date reserveOutTime;
    /**
     * 实际退房时间
     */
    private Date outTime;
    /**
     * 付款状态 0：未付款 1：已付款
     */
    private Integer costStatus;
}
