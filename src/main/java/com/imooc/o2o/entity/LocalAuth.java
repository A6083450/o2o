package com.imooc.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by erpljq on 2018/5/23.
 */
@Data
public class LocalAuth {

    private Long localAuthId;

    private String username;

    private String password;

    private Date createTime;

    private Date lastEditTime;

    private PersonInfo personInfo;

}
