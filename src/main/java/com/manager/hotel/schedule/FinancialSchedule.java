package com.manager.hotel.schedule;

import com.manager.hotel.enums.CustomerCostStatusEnum;
import com.manager.hotel.enums.FinancialEnum;
import com.manager.hotel.mapper.CustomerCostMapper;
import com.manager.hotel.mapper.FinancialMapper;
import com.manager.hotel.model.CustomerCostDO;
import com.manager.hotel.model.FinancialDO;
import com.manager.hotel.utils.TimeUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 18:58
 */
@Component
public class FinancialSchedule {

    @Resource
    private CustomerCostMapper customerCostMapper;

    @Resource
    private FinancialMapper financialMapper;


    /**
     * 每天23点59分执行
     */
    @Scheduled(cron = "0 59 23 * * ?")
    public void statistics() {
        final Date endTime = new Date();
        Date startTime = TimeUtils.formatDayTime(endTime, "yyyy-MM-dd");
        AtomicReference<Double> number = new AtomicReference<>(0.0D);
        customerCostMapper.listByTime(startTime, endTime)
                .forEach(customerCostDO -> number.updateAndGet(v -> v + customerCostDO.getDiscount() * customerCostDO.getCostValue()));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String name = simpleDateFormat.format(endTime) + "-" + "营收";
        FinancialDO financialDO = new FinancialDO();
        financialDO.setName(name);
        financialDO.setValue(number.get());
        financialDO.setStatus(FinancialEnum.IN.getCode());
        financialMapper.insertSelective(financialDO);
    }
}
