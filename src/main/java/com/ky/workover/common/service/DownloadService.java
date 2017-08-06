package com.ky.workover.common.service;

import com.alibaba.fastjson.JSON;
import com.ky.workover.common.json.JsonUtils;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lau on 2017/1/3.
 */
@Service
public class DownloadService {

    /**
     * 加班信息模版下载
     */
    public Map<String, Object> downloadExcel(HttpServletResponse response) throws IOException {
        Map<String, Object> mapData = new HashMap<>();
        Workbook wb = new XSSFWorkbook();
        Sheet sheet1 = (Sheet) wb.createSheet("sheet1");
        HSSFWorkbook workbook = new HSSFWorkbook();
        Font ztFont = wb.createFont();
        ztFont.setColor(Font.COLOR_RED);
        XSSFCellStyle ztStyle = (XSSFCellStyle) wb.createCellStyle();
        ztStyle.setFont(ztFont);
        HSSFDataFormat format = workbook.createDataFormat();
        ztStyle.setDataFormat(format.getFormat("0"));
        try {
            // 第一行
            Row row0 = (Row) sheet1.createRow(0);
            Cell cell = row0.createCell(0);
            cell.setCellValue("人员编号");
            cell.setCellStyle(ztStyle);
            cell = row0.createCell(1);
            cell.setCellValue("人员姓名");
            cell.setCellStyle(ztStyle);
            cell = row0.createCell(2);
            cell.setCellValue("加班日期");
            cell.setCellStyle(ztStyle);
            cell = row0.createCell(3);
            cell.setCellValue("加班日期开始时间");
            cell.setCellStyle(ztStyle);
            cell = row0.createCell(4);
            cell.setCellValue("加班日期结束时间");
            cell.setCellStyle(ztStyle);
            cell = row0.createCell(5);
            cell.setCellValue("加班时长");
            cell = row0.createCell(6);
            cell.setCellValue("加班费用");
            cell.setCellStyle(ztStyle);
            cell = row0.createCell(7);
            cell.setCellValue("餐补");
            cell.setCellStyle(ztStyle);
            cell = row0.createCell(8);
            cell.setCellStyle(ztStyle);
            cell.setCellValue("交通补助");
            cell = row0.createCell(9);
            cell.setCellValue("年份");
            cell = row0.createCell(10);
            cell.setCellValue("月份");
            String filename = "加班记录模板.xlsx";
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + filename);
            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapData;
    }

    }