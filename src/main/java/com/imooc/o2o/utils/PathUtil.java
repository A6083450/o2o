package com.imooc.o2o.utils;

/**
 * @author erpljq
 * @date 2018/6/4
 */
public class PathUtil {

    private static String separator = System.getProperty("file.separator");

    public static String getImgBasePath() {

        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "E:/o2o/";
        } else {
            basePath = "/home/";
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    public static String getShopImagePath(long shopId) {

        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/",separator);
    }
}
