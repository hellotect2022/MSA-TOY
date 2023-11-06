package com.msa.manager.common.utils;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

    public static String UPLOAD_DIR = "C:/TEST/";
    public static String fileUpload(MultipartFile file, String dirPath){
        try{
            String fileName = file.getOriginalFilename();
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

    public static ResponseEntity fileDownload(String fileName) throws IOException {
        String filePath = fileName;
        System.out.println("filePath:::"+filePath);
        File file = new File(filePath);
        System.out.println("fileName:::"+file.getName());

        // 파일이 존재하는지 확인하고 InputStreamResource로 변환
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        // 다운로드할 때 파일명 설정
        HttpHeaders headers = new HttpHeaders();
        String encodedFileName = URLEncoder.encode(file.getName(), StandardCharsets.UTF_8.toString());

        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + encodedFileName);

        // 파일의 MIME 타입에 따라 Content-Type 설정
        String contentType = "application/octet-stream"; // 기본적으로는 이진 파일로 설정
        Path path = Paths.get(filePath);
        if (path != null) {
            contentType = Files.probeContentType(path);
        }

        // ResponseEntity를 이용하여 파일 다운로드 응답 생성
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }

    public static ResponseEntity<byte[]> zipAndDownloadFiles(List<Resource> files) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ZipOutputStream zos = new ZipOutputStream(baos)) {
            for (Resource file : files) {
                zos.putNextEntry(new ZipEntry(file.getFilename()));
                IOUtils.copy(file.getInputStream(), zos);
                zos.closeEntry();
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=files.zip");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(baos.size())
                .contentType(MediaType.parseMediaType("application/zip"))
                .body(baos.toByteArray());
    }
}





