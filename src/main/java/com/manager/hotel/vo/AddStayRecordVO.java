package com.manager.hotel.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 13:10
 */
@Data
public class AddStayRecordVO extends BaseVO {

    private CustomerVO customerVO;

    private Integer roomId;

    private Date reserveTime;

    private Date reserveOutTime;

}
