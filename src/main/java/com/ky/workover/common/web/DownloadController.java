package com.ky.workover.common.web;

import com.ky.workover.common.web.BaseController;
import com.ky.workover.common.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;


/**
 * Created by 13455 on 2017/1/23.
 * 加班模板下载
 */
@Controller
@RequestMapping (value="download")
public class DownloadController extends BaseController {
   @Autowired
    private DownloadService downloadService;
    @RequestMapping(value = "Excel", method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Objects> downExcel (HttpServletResponse response) throws IOException{

         downloadService.downloadExcel(response);
        return null;
    }
}
