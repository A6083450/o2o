package com.imooc.o2o.service.impl;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.service.ShopService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;

/**
 * @author erpljq
 * @date 2018/6/5
 */
public class ShopServiceImplTest extends BaseTest{

    @Autowired
    private ShopService shopService;

    @Test
    public void addShop() throws Exception {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺1");
        shop.setShopDesc("test1");
        shop.setShopAddr("测试地址1");
        shop.setPhone("测试手机");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("E:\\BaiduNetdiskDownload\\054 SSM到Spring Boot-从零开发校园商铺平台 加\\images\\item\\shopcategory");
        ShopExecution shopExecution = shopService.addShop(shop, new CommonsMultipartFile(
                new DiskFileItem("", "", false, "a", 100, shopImg)));
        System.out.println(shopExecution);
    }


}