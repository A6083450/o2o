package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by erpljq on 2018/6/1.
 */
public class AreaDaoTest extends BaseTest{

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() throws Exception {
        List<Area> areaList = areaDao.queryArea();
        System.out.println(areaList);
        Assert.assertEquals(2, areaList.size());
    }

}