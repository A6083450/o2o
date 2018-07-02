package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Area;

import java.util.List;

/**
 * Created by erpljq on 2018/5/31.
 */
public interface AreaDao {

    /**
     * 列出区域列表
     * @return areaList
     */
    List<Area> queryArea();
}
