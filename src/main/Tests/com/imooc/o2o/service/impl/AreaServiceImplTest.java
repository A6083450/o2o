package com.imooc.o2o.service.impl;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author erpljq
 * @date 2018/6/1
 */
public class AreaServiceImplTest extends BaseTest{

    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaList() throws Exception {
        List<Area> areaList = areaService.getAreaList();
        System.out.println(areaList);

    }

}