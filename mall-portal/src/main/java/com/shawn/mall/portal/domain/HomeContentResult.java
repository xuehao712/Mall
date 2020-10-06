package com.shawn.mall.portal.domain;

import com.shawn.mall.model.CmsSubject;
import com.shawn.mall.model.PmsBrand;
import com.shawn.mall.model.PmsProduct;
import com.shawn.mall.model.SmsHomeAdvertise;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Home page content result
 */
@Getter
@Setter
public class HomeContentResult {
    //advertise
    private List<SmsHomeAdvertise> advertiseList;
    //recommend brand
    private List<PmsBrand> brandList;
    //current flash promotion
    private HomeFlashPromotion homeFlashPromotion;
    //new
    private List<PmsProduct> newProductList;
    //hot
    private List<PmsProduct> hotProductList;
    //recommend subject
    private List<CmsSubject> subjectList;
}
