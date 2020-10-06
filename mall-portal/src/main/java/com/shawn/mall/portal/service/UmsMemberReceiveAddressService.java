package com.shawn.mall.portal.service;

import com.shawn.mall.model.UmsMemberReceiveAddress;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Member address service
 */
public interface UmsMemberReceiveAddressService {
    /**
     * Add receive address
     */
    int add(UmsMemberReceiveAddress address);

    /**
     * Delete receive address
     */
    int delete(Long id);

    /**
     * Modify receive address
     */
    @Transactional
    int update(Long id,UmsMemberReceiveAddress address);

    /**
     * Return member address list
     */
    List<UmsMemberReceiveAddress> list();

    /**
     * Get address detail
     */
    UmsMemberReceiveAddress getItem(Long id);
}
