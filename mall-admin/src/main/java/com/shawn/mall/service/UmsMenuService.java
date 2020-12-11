package com.shawn.mall.service;

import com.shawn.mall.dto.UmsMenuNode;
import com.shawn.mall.model.UmsMenu;

import java.util.List;

/**
 * Admin menu service
 */
public interface UmsMenuService {
    /**
     * Create
     */
    int create(UmsMenu umsMenu);

    /**
     * Modify admin menu
     */
    int update(Long id, UmsMenu umsMenu);

    /**
     * Get menu detail base on id
     */
    UmsMenu getItem(Long id);

    /**
     * Delete menu base on id
     */
    int delete(Long id);

    /**
     * Paging get menu list
     */
    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * Tree structure return all menu lists
     */
    List<UmsMenuNode> treeList();

    /**
     * Modify menu display status
     */
    int updateHidden(Long id, Integer hidden);
}
