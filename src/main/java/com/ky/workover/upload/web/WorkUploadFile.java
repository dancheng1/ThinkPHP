package com.ky.workover.upload.web;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 13455 on 2017/1/19.
 */
public class WorkUploadFile {
    public MultipartFile getFileToUpload() {
        return fileToUpload;
    }

    public void setFileToUpload(MultipartFile fileToUpload) {
        this.fileToUpload = fileToUpload;
    }

    private MultipartFile fileToUpload;

   }
