package com.msa.manager.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FileUtil {

    public static String UPLOAD_DIR = "C:/TEST/";
    public static String fileUpload(MultipartFile file, String dirPath){
        try{
            byte[] utf8Bytes = file.getOriginalFilename().getBytes(StandardCharsets.UTF_8);
            String fileName = new String(utf8Bytes, StandardCharsets.UTF_8.toString());
            String encodedFileName = URLEncoder.encode(file.getOriginalFilename(), StandardCharsets.UTF_8.toString())
                    .replace("+", "%20");
            System.out.println("getOriginalFilename:::"+file.getOriginalFilename());
            System.out.println("utf8Bytes:::"+utf8Bytes);
            System.out.println("encodedFileName:::"+encodedFileName);

            String filePath = UPLOAD_DIR+fileName;
            File dirFile = new File(UPLOAD_DIR);


            if(!dirFile.exists())
            {
                //디렉토리 생성 실패
                if(!dirFile.mkdirs())
                {
                    throw new Exception();
                }
            }

            File destFile = new File(filePath);
            file.transferTo(destFile);
            return "File upload success";
        }catch (Exception e){
            return "File download error"+e.toString();
        }

    }
}
