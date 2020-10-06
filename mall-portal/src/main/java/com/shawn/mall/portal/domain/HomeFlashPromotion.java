package com.shawn.mall.portal.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Home page current flash promotion
 */
@Getter
@Setter
public class HomeFlashPromotion {
    private Date startTime;
    private Date endTime;
    private Date nextStartTime;
    private Date nextEndTime;
    //flash promotion product
    private List<FlashPromotionProduct> productList;
}
