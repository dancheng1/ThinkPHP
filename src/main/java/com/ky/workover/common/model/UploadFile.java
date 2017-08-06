package com.ky.workover.common.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 13455 on 2017/1/19.
 */
public class UploadFile {
    public MultipartFile getFileToUpload() {
        return fileToUpload;
    }

    public void setFileToUpload(MultipartFile fileToUpload) {
        this.fileToUpload = fileToUpload;
    }

    private MultipartFile fileToUpload;

   }
