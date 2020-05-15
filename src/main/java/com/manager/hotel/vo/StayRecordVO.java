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
    /**
     * 客户id
     */
    private Integer customerId;
    /**
     * 客户名
     */
    private String customerName;
    /**
     * 客户类型 0：老用户 1：新用户
     */
    private Integer customerType;
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
