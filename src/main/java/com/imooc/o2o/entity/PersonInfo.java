package com.imooc.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by erpljq on 2018/5/22.
 * 用户信息实体类
 */
@Data
public class PersonInfo {

    private Long userId;

    private String name;

    private String profileImg;

    private String email;

    private String gender;

    private Integer enableStatus;

    //1.顾客  2.店家  3.超级管理员
    private Integer userType;

    private Date createTime;

    private Date lastEditTime;
}
