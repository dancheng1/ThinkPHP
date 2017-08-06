package com.ky.workover.upload.web;

import com.ky.workover.common.web.BaseController;
import com.ky.workover.emp.service.PersonUserService;

import com.ky.workover.upload.service.WorkUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 13455 on 2017/1/16.
 */
@Controller
@RequestMapping(value = "upload")
public class WorkUploadController extends BaseController {
    @Autowired
    private WorkUploadService workUploadService;

    @RequestMapping(method = RequestMethod.GET)
    public String toPage(HttpServletRequest request, HttpServletResponse response) {
        return "upload/toPage";
    }
    @RequestMapping(value = "workUpload",method = RequestMethod.GET)
    public String select(HttpServletRequest request, HttpServletResponse response) {
        return "/upload/selectWUL";
    }
    /**
     * POI上传
     *
     * @param files
     * @return "success"
     */
    @RequestMapping(value = "workUpload1", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> driverUploadExcel(@RequestParam("file") MultipartFile[] files) {
        Map result = new HashMap<String,String>();
        WorkUploadFile workUploadFile = new WorkUploadFile();//文件上传  包含MultipartFile方法
        workUploadFile.setFileToUpload(files[0]);           //文件上传
        try {
            workUploadService.workUpload(workUploadFile); //单条插入上传
        } catch (Exception e) {
            e.printStackTrace();
            result.put("result","fail");
            result.put("message",e.getMessage());
            return result;
        }
        result.put("result","success");
     return result;
    }
}

