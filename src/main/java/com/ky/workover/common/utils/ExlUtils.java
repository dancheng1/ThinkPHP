package com.ky.workover.common.utils;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyr on 2015/12/28.
 */
public class ExlUtils {
    public void exportExcel(List<Object> excelExportModelList, OutputStream out) {
    }

    /**
     * Excel读入
     *
     * @param inputStream InputStream 流文件
     *
     * @return list
     */
    public static List<String[]> readExcel(InputStream inputStream) {
        // 返回值resultList
        List<String[]> resultArrayList = new ArrayList<>();

        try {
            // 声明一个Excel工作薄
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            // 取得第一个sheet
            HSSFSheet exlSheet = workbook.getSheetAt(0);
            // 从第二行开始读取（第一行默认为表头）
            for (int rowNum = 1; rowNum <= exlSheet.getLastRowNum(); rowNum++) {
                HSSFRow row = exlSheet.getRow(rowNum);
                if (row == null) {
                    continue;
                }
                String[] eachResultArray = new String[row.getLastCellNum()];
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    if(row.getCell(i) == null){
                        eachResultArray[i] ="";
                    }else{
                        eachResultArray[i] = ConvertCellStr(row.getCell(i));
                    }
                }
                resultArrayList.add(eachResultArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultArrayList;
    }

    /**
     * 把单元格内的类型转换至String类型
     * @param cell Cell数据
     *
     * @return cellStr
     */
    private static String ConvertCellStr(Cell cell) {
        String cellStr = null;
        switch (cell.getCellType()) {

            case Cell.CELL_TYPE_STRING:
                // 读取String
                cellStr = cell.getStringCellValue().toString();
                break;

            case Cell.CELL_TYPE_BOOLEAN:
                // 得到Boolean对象的方法
                cellStr = String.valueOf(cell.getBooleanCellValue());
                break;

            case Cell.CELL_TYPE_NUMERIC:

                // 先看是否是日期格式
                if (DateUtil.isCellDateFormatted(cell)) {

                    // 读取日期格式
                    cellStr = cell.getDateCellValue().toString();

                } else {

                    // 读取数字
                    cellStr = String.valueOf(cell.getNumericCellValue());
                }
                break;

            case Cell.CELL_TYPE_FORMULA:
                // 读取公式
                cellStr = cell.getCellFormula().toString();
                break;
        }
        return cellStr;
    }
}
