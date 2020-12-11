package com.shawn.mall.service;

import com.shawn.mall.dto.*;
import com.shawn.mall.model.OmsOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Order Service
 */
public interface OmsOrderService {
    /**
     * Order search
     */
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * Multiple ship
     */
    @Transactional
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * Multiple close orders
     */
    @Transactional
    int close(List<Long> ids, String note);

    /**
     * Multiple delete order
     */
    int delete(List<Long> ids);

    /**
     * Get single order detail
     */
    OmsOrderDetail detail(Long id);

    /**
     * Modify order receiver info
     */
    @Transactional
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    /**
     * Modify order money info
     */
    @Transactional
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    /**
     * Modify order note
     */
    @Transactional
    int updateNote(Long id, String note, Integer status);
}
