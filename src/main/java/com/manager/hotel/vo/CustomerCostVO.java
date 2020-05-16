package com.manager.hotel.vo;

import lombok.Data;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 17:20
 */
@Data
public class CustomerCostVO extends BaseVO {

    private Integer recordId;

    private Integer costId;

    private Double costValue;

    private Double discount;
}
