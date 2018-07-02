package com.imooc.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by erpljq on 2018/5/30.
 */
@Data
public class ProductImg {

    private Long productImgId;

    private String imgAddr;

    private String imgDesc;

    private Integer priority;

    private Date createTime;

    private Long productId;
}
