package com.imooc.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by erpljq on 2018/5/28.
 * 店铺类别实体类
 */
@Data
public class ShopCategory {

    private Long shopCategoryId;

    private String shopCategoryName;

    private String shopCategoryDesc;

    private String shopCategoryImg;

    private Integer priority;

    private Date createTime;

    private Date lastEditTime;

    private ShopCategory parent;
}
