package com.imooc.o2o.service;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.exceptions.ShopOperationException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author erpljq
 * @date 2018/6/5
 */
public interface ShopService {

    /**
     * 通过店铺Id获取店铺信息
     *
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 更新店铺信息, 包括对图片的处理
     * @param shop
     * @param shopImg
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg) throws ShopOperationException;

    /**
     * 注册店铺信息, 包括图片处理
     *
     * @param shop
     * @param shopImg
     * @return
     * @throws ShopOperationException
     */
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) throws ShopOperationException;
}
