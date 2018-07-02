package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author erpljq
 * @date 2018/6/7
 */
public class ShopCategoryDaoTest extends BaseTest{

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void queryShopCategory() throws Exception {
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setParent(new ShopCategory());
        shopCategory.getParent().setShopCategoryId(1L);
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(shopCategory);
        System.out.println(shopCategoryList);
    }

}