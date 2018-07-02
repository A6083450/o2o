package com.imooc.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by erpljq on 2018/5/28.
 */
@Data
public class ProductCategory {

    private Long productCategoryId;

    private Long shopId;

    private String productCategoryName;

    private Integer priority;

    private Date createTime;
}
