package com.julyerr.springboot.mvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileOpsController {
    @Value("${UploadFilePath}")
    private String filePath;

    //    html界面
    @GetMapping("/")
    public String file() {
        return "file";
    }

    //    单个文件
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "the file is empty";
        }
        File dest = new File(getFilePath(filePath) + file.getOriginalFilename());
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload failed";
    }

    //    多个文件
    @PostMapping("/uploadBatch")
    @ResponseBody
    public String uploadBatch(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (!file.isEmpty()) {
                File dest = new File(getFilePath(filePath) + file.getOriginalFilename());
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                    return "the " + i + " file upload failed";
                }
            } else {
                return "the " + i + " file is empty";
            }
        }
        return "success";
    }

    @GetMapping("/download")
    @ResponseBody
    public String download(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "test.java";
        File file = new File(getFilePath(filePath) + fileName);
        if (file.exists()) {
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] bytes = new byte[1024];
            InputStream is = null;
            BufferedInputStream bis = null;
            try {
                is = new FileInputStream(file);
                bis = new BufferedInputStream(is);
                OutputStream os = response.getOutputStream();
                int count = bis.read(bytes);
                while (count != -1) {
                    os.write(bytes, 0, count);
                    count = bis.read(bytes);
                }
                return "success";
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(bis!=null){
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(is!=null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "download failed";
    }

    private String getFilePath(String path) {
        String fileSeparator = System.getProperty("file.separator");
        if (path.endsWith(fileSeparator)) {
            return path;
        }
        return path + fileSeparator;
    }
}
