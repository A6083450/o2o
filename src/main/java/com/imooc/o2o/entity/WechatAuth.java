package com.imooc.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by erpljq on 2018/5/23.
 */
@Data
public class WechatAuth {

    private Long wechatAuthId;

    private String openId;

    private Date createTime;

    private PersonInfo personInfo;

}
