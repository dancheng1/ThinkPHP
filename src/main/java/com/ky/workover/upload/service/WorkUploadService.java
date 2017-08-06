package com.ky.workover.upload.service;


import com.ky.workover.common.xlsx.ResolveExcel;


import com.ky.workover.upload.web.WorkUploadFile;
import com.ky.workover.work.mapper.PersonWorkoverMapper;
import com.ky.workover.work.model.PersonWorkover;
import com.ky.workover.work.service.PersonWorkoverService;
import org.apache.bcel.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 加班文档上传
 * time：2017年1月17日09:32:49
 */
@Service
public class WorkUploadService {

    @Autowired
    private PersonWorkoverMapper personWorkoverMapper;

    public Map<String, Object> workUpload(WorkUploadFile workUploadFile) {
        List<Map<String, Object>> mapList = null;
        InputStream is = null;
        String filename = workUploadFile.getFileToUpload().getOriginalFilename();//获取文件名称
        String names = filename.substring(filename.indexOf(".") + 1, filename.length());
        if (!workUploadFile.getFileToUpload().isEmpty()) {
            try {
                try {
                    is = workUploadFile.getFileToUpload().getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if ("xls".equals(names.toLowerCase())) {
                    mapList = ResolveExcel.readXls(is);
                }
                if ("xlsx".equals(names.toLowerCase())) {
                    mapList = ResolveExcel.readXlsx(is);
                }
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<PersonWorkover> list = new ArrayList<>();
        for (Map<String, Object> m : mapList) {
            PersonWorkover overCost = new PersonWorkover();               //上传文件内的实体类
            String str = "".equals(m.get("序号") + "") ? "0" : m.get("rowIndex") + "";
            int id = Integer.parseInt(str);
            for (String key : m.keySet()) { //下面用循环读取excel内的内容
                switch (key) {
                    case "人员编号"://加班人姓名
                        overCost.setPersonno(m.get(key) + "");
                        break;
                    case "人员姓名"://加班人姓名
                        overCost.setPersonname(m.get(key) + "");
                        break;
                    case "加班日期"://加班日期
                        overCost.setCurrentdate(m.get(key) + "");
                        break;
                    case "加班日期开始时间"://加班日期开始时间
                        overCost.setStarttime(m.get(key) + "");
                        break;
                    case "加班日期结束时间"://加班日期结束时间
                        overCost.setEndtime(m.get(key) + "");
                        break;
                    case "加班时长"://加班日期结束时间
                        overCost.setLehgthtime(m.get(key) + "");
                        break;
                    case "加班费用"://加班日期结束时间
                        overCost.setWorkcost(m.get(key) + "");
                        break;
                    case "餐补"://加班日期结束时间
                        overCost.setMealcost(m.get(key) + "");
                        break;
                    case "交通补助"://加班日期结束时间
                        overCost.setTrafficcost(m.get(key) + "");
                        break;
                    case "年份"://加班日期结束时间
                        overCost.setYear(m.get(key) + "");
                        break;
                    case "月份"://加班日期结束时间
                        overCost.setMouth(m.get(key) + "");
                        break;
                }
            }
            personWorkoverMapper.insert(overCost);
      /*      list.add(overCost);*/
        }
//        personWorkoverMapper.batchInsert(list);
        return null;
    }
}