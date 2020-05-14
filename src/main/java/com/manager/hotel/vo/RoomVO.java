package com.manager.hotel.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 01:05
 */
@Data
public class RoomVO extends BaseVO {

    @NotNull(message = "房间id不能为空")
    private Integer roomId;
    @NotNull(message = "房间类型不能为空")
    private Integer roomType;
    @NotNull(message = "入住状态不能为空")
    private Integer stayStatus;
    @NotNull(message = "清洁状态不能为空")
    private Integer cleanStatus;
    @NotNull(message = "房间价格不能为空")
    private Double roomPrice;

}
