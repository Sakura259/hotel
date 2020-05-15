package com.manager.hotel.schedule;

import com.manager.hotel.core.RoomService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 18:58
 */
@Component
public class RoomSchedule {

    @Resource
    private RoomService roomService;


    /**
     * 每天12点执行
     */
    @Scheduled(cron = "0 0 12 ? * *")
    public void deleteExpireData() {
        roomService.updateStatus();
    }
}
