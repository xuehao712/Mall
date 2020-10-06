package com.shawn.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.shawn.mall.mapper.*;
import com.shawn.mall.model.*;
import com.shawn.mall.portal.dao.HomeDao;
import com.shawn.mall.portal.domain.FlashPromotionProduct;
import com.shawn.mall.portal.domain.HomeContentResult;
import com.shawn.mall.portal.domain.HomeFlashPromotion;
import com.shawn.mall.portal.service.HomeService;
import com.shawn.mall.portal.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Home page content service implement
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private SmsFlashPromotionMapper flashPromotionMapper;
    @Autowired
    private SmsFlashPromotionSessionMapper promotionSessionMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Override
    public HomeContentResult content(){
        HomeContentResult result = new HomeContentResult();
        result.setAdvertiseList(getHomeAdvertiseList());
        result.setBrandList(homeDao.getRecommendBrandList(0,6));
        result.setHomeFlashPromotion(getHomeFlashPromotion());
        result.setNewProductList(homeDao.getNewProductList(0,4));
        result.setHotProductList(homeDao.getHotProductList(0,4));
        result.setSubjectList(homeDao.getRecommendSubjectList(0,4));
        return result;
    }

    @Override
    public List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria()
                .andDeleteStatusEqualTo(0)
                .andPublishStatusEqualTo(1);
        return productMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductCategory> getProductCateList(Long parentId) {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.createCriteria()
                .andShowStatusEqualTo(1)
                .andParentIdEqualTo(parentId);
        example.setOrderByClause("sort desc");
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public List<CmsSubject> getSubjectList(Long cateId,Integer pageSize,Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        CmsSubjectExample example = new CmsSubjectExample();
        CmsSubjectExample.Criteria criteria = example.createCriteria();
        criteria.andShowStatusEqualTo(1);
        if(cateId!=null){
            criteria.andCategoryIdEqualTo(cateId);
        }
        return subjectMapper.selectByExample(example);
    }

    @Override
    public List<PmsProduct> hotProductList(Integer pageNum,Integer pageSize) {
        int offset = pageSize *(pageNum - 1);
        return homeDao.getHotProductList(offset,pageSize);
    }

    @Override
    public List<PmsProduct> newProductList(Integer pageNum,Integer pageSize) {
        int offset = pageSize *(pageNum-1);
        return homeDao.getNewProductList(offset,pageSize);
    }

    private HomeFlashPromotion getHomeFlashPromotion() {
        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        //Get current flash promotion
        Date now = new Date();
        SmsFlashPromotion flashPromotion = getFlashPromotion(now);
        if(flashPromotion!=null) {
            //Get current flash promotion
            SmsFlashPromotionSession flashPromotionSession = getFlashPromotionSession(now);
            if(flashPromotionSession!=null) {
                homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
                homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
                //Get next promotion
                SmsFlashPromotionSession nextSession = getNextFlashPromotionSession(homeFlashPromotion.getNextStartTime());
                if(nextSession!=null) {
                    homeFlashPromotion.setNextStartTime(nextSession.getStartTime());
                    homeFlashPromotion.setNextEndTime(nextSession.getEndTime());
                }
                //Get promotion products
                List<FlashPromotionProduct> flashProductList = homeDao.getFlashProductList(flashPromotion.getId(),flashPromotionSession.getId());
                homeFlashPromotion.setProductList(flashProductList);
            }
        }
        return homeFlashPromotion;
    }

    /**
     * Get next promotion
     */
    private SmsFlashPromotionSession getNextFlashPromotionSession(Date date) {
        SmsFlashPromotionSessionExample sessionExample = new SmsFlashPromotionSessionExample();
        sessionExample.createCriteria()
                .andStartTimeGreaterThan(date);
        sessionExample.setOrderByClause("start_time asc");
        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
        if(!CollectionUtils.isEmpty(promotionSessionList)){
            return promotionSessionList.get(0);
        }
        return null;
    }

    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        example.createCriteria().andTypeEqualTo(1).andStatusEqualTo(1);
        example.setOrderByClause("sort desc");
        return advertiseMapper.selectByExample(example);
    }

    /**
     * Get flash promotion base on date
     */
    private SmsFlashPromotion getFlashPromotion(Date date) {
        Date curDate = DateUtil.getDate(date);
        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
        example.createCriteria()
                .andStatusEqualTo(1)
                .andStartDateLessThanOrEqualTo(curDate)
                .andEndDateGreaterThanOrEqualTo(curDate);
        List<SmsFlashPromotion> flashPromotionList = flashPromotionMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(flashPromotionList)){
            return flashPromotionList.get(0);
        }
        return null;
    }

    /**
     * Get flash promotion session
     */
    private SmsFlashPromotionSession getFlashPromotionSession(Date date) {
        Date currTime = DateUtil.getTime(date);
        SmsFlashPromotionSessionExample example = new SmsFlashPromotionSessionExample();
        example.createCriteria()
                .andStartTimeLessThanOrEqualTo(currTime)
                .andEndTimeGreaterThanOrEqualTo(currTime);
        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }
}
