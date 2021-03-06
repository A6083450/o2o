package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;

/**
 * @author erpljq
 * @date 2018/6/2
 */
public interface ShopDao {

    /**
     * 通过shioId 查询店铺
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);

    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 修改店铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
