package com.shawn.mall.portal.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Order timeout cancel and unlock stock timer
 */
public class OrderTimeOutCancelTask {
    private Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);
    @Autowired
    private OmsPortalOrderService portalOrderService;

    /**
     * cron expression: Seconds Minutes Hours DayofMonth Month DayofWeek [year]
     * scan each 10 minutes
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder() {
        Integer count = portalOrderService.cancelTimeOutOrder();
        LOGGER.info("Cancel order, release locked stock according to sku: {}",count);
    }
}
