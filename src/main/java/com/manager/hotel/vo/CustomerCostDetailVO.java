package com.manager.hotel.vo;

import lombok.Data;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 21:21
 */
@Data
public class CustomerCostDetailVO {

    private Integer id;

    private Integer recordId;

    private Integer costId;

    private String costName;

    private Double costValue;

    private Double discount;

    private Integer status;
}
