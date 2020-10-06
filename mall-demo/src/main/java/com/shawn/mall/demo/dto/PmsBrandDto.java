package com.shawn.mall.demo.dto;

import com.shawn.mall.demo.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Brand parameter
 */
@ApiModel(value = "PmsBrandDto")
public class PmsBrandDto {
    @ApiModelProperty(value = "brand name",required = true)
    @NotNull(message = "name cannot be empty")
    private String name;
    @ApiModelProperty(value = "brand first letter",required = true)
    @NotNull(message = "first letter cannot be empty")
    private String firstLetter;
    @ApiModelProperty(value = "sort field")
    @Min(value = 0,message = "lowest sort 0")
    private Integer sort;
    @ApiModelProperty(value = "manufacturer")
    @FlagValidator(value = {"0","1"},message = "factory status not correct")
    private Integer factoryStatus;
    @ApiModelProperty(value = "display")
    @FlagValidator(value = {"0","1"},message = "display status not correct")
    private Integer showStatus;
    @ApiModelProperty(value = "brand logo")
    private String logo;
    @ApiModelProperty(value = "brand big picture")
    private String bigPic;
    @ApiModelProperty(value = "brand story")
    private String brandStory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(Integer factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }
}
