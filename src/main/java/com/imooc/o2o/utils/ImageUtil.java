package com.imooc.o2o.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author erpljq
 * @date 2018/6/4
 */
public class ImageUtil {

    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    private static final Random RANDOM = new Random();

    public static String generateThumbnails(CommonsMultipartFile thumbnail, String targetAddr) {
        String realFileName = getRandomFileName();
        String extension = getFileExtension(thumbnail);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream()).size(200, 200).outputQuality(0.25f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及到的目录, 即/home/work/xxx/xxx.jpg
     * 那么home work 这三个文件夹都得自动创建
     *
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    private static String getFileExtension(CommonsMultipartFile thumbnail) {
        String originalFileName = thumbnail.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名, 当前年月日小时分钟分秒+五位随机数
     *
     * @return
     */
    private static String getRandomFileName() {
        // 获取随机的五位数
        int rannum = RANDOM.nextInt(89999) + 10000;
        String nowTimeStr = SIMPLE_DATE_FORMAT.format(new Date());

        return nowTimeStr + rannum;
    }

    /**
     * storePath是文件的路径还是目录路径
     * 如果storePath是文件路径则删除该文件
     * 如果storePath是目录路径则删除该目录下的所有文件
     *
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath) {
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrPath.exists()) {
            if (fileOrPath.isDirectory()) {
                File[] files = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }

    public static void main(String[] args) throws IOException {
        String img = "E:\\BaiduNetdiskDownload\\054 SSM到Spring Boot-从零开发校园商铺平台 加\\images\\item\\shop\\15"
                + "\\20170605234852321010.jpg";
        String logo = "E:\\BaiduNetdiskDownload\\054 SSM到Spring Boot-从零开发校园商铺平台 加\\images\\item\\shop\\15"
                + "\\2017060522042982266.png";
        String path = "E:\\BaiduNetdiskDownload\\054 SSM到Spring Boot-从零开发校园商铺平台 加\\images\\item\\shop\\15";
        Thumbnails.of(new File(img)).size(400, 400).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(logo)), 0.25f)
                .outputQuality(0.8f).toFile(path + "\\1.jpg");

    }
}
