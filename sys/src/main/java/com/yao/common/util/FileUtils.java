package com.yao.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileUtils {

    public static String saveFile(MultipartFile file, String fileName, String savePath) throws Exception {
        InputStream inputStream = file.getInputStream();
        String contentType = file.getContentType();
        String surffix = "";
        String fileUrl = "";
        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            surffix = ".xlsx";
        } else if(contentType.equals("application/vnd.ms-excel")) {
            surffix = ".xls";
        }else if(contentType.equals("application/octet-stream")) {
            surffix = ".xlsx";
        }else {
            throw new Exception("上传文件类型错误！");
        }
        OutputStream os = null;
        try {
            String path = savePath;
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName+surffix);
            fileUrl = fileName+surffix;
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileUrl;
    }

}
