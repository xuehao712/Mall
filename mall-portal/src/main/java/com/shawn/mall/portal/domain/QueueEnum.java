package com.shawn.mall.portal.domain;

import lombok.Getter;

/**
 * Message queue config
 */
@Getter
public enum  QueueEnum {
    /**
     * Message warning queue
     */
    QUEUE_ORDER_CANCEL("mall.order.direct","mall.order.cancel","mall.order.cancel"),
    /**
     * Message warning tt1
     */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl","mall.order.cancel.ttl","mall.order.cancel.ttl");

    private String exchange;
    private String name;
    private String routeKey;

    QueueEnum(String exchange, String name,String routeKey){
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
