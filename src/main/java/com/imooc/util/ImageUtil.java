package com.imooc.util;

import com.sun.javafx.scene.shape.PathUtils;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;

import static com.imooc.util.FileUtil.getRandomFileName;

public class ImageUtil {
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = FileUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    private static String getFileExtension(CommonsMultipartFile cFile) {
        String originalFileName = cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }
    public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
        String realFileName = FileUtil.getRandomFileName();
        String extension = getFileExtension(thumbnail);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream()).size(200, 200).outputQuality(0.25f).toFile(dest);
        } catch (IOException e) {
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        return relativeAddr;
    }
//    public static generateThumbnail(CommonsMultipartFile thumbnail,String targetAddr){
//        String  realFileName=getRandomFileName();
//        String extension=getFileExtension();
//        makeDirPath(targetAddr);
//        String relativeAddr=targetAddr+realFileName+extension;
//        File dest=new File(FileUtil.getImgBasePath()+relativeAddr);
//        try{
//            Thumbnails.of(thumbnail.getInputStream()).size(200,200)
//                    .watermark()
//        }
//
//    }
    public static void main(String[] args) {
        String basepath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
        try {
           // File file=new File("C:\\Users\\Susan\\Downloads\\shirley-software\\实例web项目学习\\qinxuewu-mongo-web-select-master\\mockwebapp\\src\\main\\resources\\fj.jpg");
            Thumbnails.of(new File("C:\\Users\\Susan\\Downloads\\shirley-software\\实例web项目学习\\qinxuewu-mongo-web-select-master\\mockwebapp\\src\\main\\resources\\tt.jpg"))
                    .size(500,500).watermark(Positions.BOTTOM_RIGHT,
                    ImageIO.read(new File("C:\\Users\\Susan\\Downloads\\shirley-software\\实例web项目学习\\qinxuewu-mongo-web-select-master\\mockwebapp\\src\\main\\resources\\fj.jpg")),0.8f).outputQuality(0.9f)
                    .toFile("xiaoren6.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
