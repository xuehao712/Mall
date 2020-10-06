package com.shawn.mall.search.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * Search product attribute
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EsProductAttributeValue implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long productAttributeId;
    //Attribute
    @Field(type = FieldType.Keyword)
    private String value;
    //Attribute: 0->specification; 1->parameter
    private Integer type;
    //Attribute name
    @Field(type = FieldType.Keyword)
    private String name;
}
