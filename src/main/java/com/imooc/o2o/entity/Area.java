package com.imooc.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by erpljq on 2018/5/22.
 * 区域实体类
 */
@Data
public class Area {

    //ID
    private Integer areaId;

    //名称
    private String areaName;

    //权重
    private Integer priority;

    //创建时间
    private Date createTime;

    //更新时间
    private Date lastEditTime;

}

