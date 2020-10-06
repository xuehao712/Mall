package com.shawn.mall.mapper;

import com.shawn.mall.model.PmsFreightTemplate;
import com.shawn.mall.model.PmsFreightTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsFreightTemplateMapper {
    long countByExample(PmsFreightTemplateExample example);

    int deleteByExample(PmsFreightTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsFreightTemplate record);

    int insertSelective(PmsFreightTemplate record);

    List<PmsFreightTemplate> selectByExample(PmsFreightTemplateExample example);

    PmsFreightTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsFreightTemplate record, @Param("example") PmsFreightTemplateExample example);

    int updateByExample(@Param("record") PmsFreightTemplate record, @Param("example") PmsFreightTemplateExample example);

    int updateByPrimaryKeySelective(PmsFreightTemplate record);

    int updateByPrimaryKey(PmsFreightTemplate record);
}