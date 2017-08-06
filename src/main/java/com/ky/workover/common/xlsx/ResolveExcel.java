package com.ky.workover.common.xlsx;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lau on 2016/7/5.
 */
@Controller
@RequestMapping("poi")
public class ResolveExcel {
    /***************************************************
     * 调用方法                                        *
     * String xls = "X:/XX/XX.xls[xlsx]"               *
     * File file = new File(xls);                      *
     * InputStream in = new FileInputStream(fileXls);  *
     * List<Map<String, Object>> list = readXls/x(in); *
     ***************************************************/

    public static void main(String[] args) {
        String xls = "E:\\工作文档\\xls\\test.xlsx"; //2003及以上生成的版本
        String xlsx = "E:\\工作文档\\xls\\加班信息模版.xlsx"; //2007及以上生成的版本
             File file = new File(xls);
        try {
            InputStream in = new FileInputStream(xls);//读取数据
            InputStream is = new FileInputStream(xlsx);
            List<Map<String, Object>> list = readXls(in);//将读取的数据放入list里面进行解析
            List<Map<String, Object>> listx = readXlsx(is);
            for (Map<String, Object> m : list) {
                for (String key : m.keySet()) {
                    System.out.println(key + " : " + m.get(key));
                }
                System.out.println("++++++++++++++++++++++++++++++");
            }
            System.out.println("￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥");
            for (Map<String, Object> m : listx) {
                for (String key : m.keySet()) {
                    System.out.println(key + " : " + m.get(key));
                }
                System.out.println("++++++++++++++++++++++++++++++");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传Excel文件
     * @param file
     * @return
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    //@RequestParam==request.getParameter("name")
    public static List<Map<String, Object>> uploadExcel(@RequestParam(value = "file", required = false) MultipartFile file) {
        //得到上传的文件名
        String filename = file.getOriginalFilename();
        //截取文件名称
        String names = filename.substring(filename.indexOf(".") + 1, filename.length());
        List<Map<String, Object>> mapList = null;
        InputStream is = null;
        if (!file.isEmpty()) {
            try {
                is = file.getInputStream();

                //转换成小写字母
                if ("xls".equals(names.toLowerCase())) {
                    mapList = readXls(is);
                }
                if ("xlsx".equals(names.toLowerCase())) {
                    mapList = readXlsx(is);
                }
                System.out.println(mapList.size());
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mapList;
    }

    /**
     * 解析.xls文件
     *
     * @param inputStream
     * @return
     */
    public static List<Map<String, Object>> readXls(InputStream inputStream) {
        List<Map<String, Object>> mapList = new ArrayList<>();//封装后的集合
        Map<String, Object> map = null;//标题
        Map<String, Object> bindMap = null;//解析EXCEL后获取的Key-Value集合

        //声明工作簿
        HSSFWorkbook hssfWorkbook = null;
        try {
            hssfWorkbook = new HSSFWorkbook(inputStream);
            map = new HashMap<>();
            // 获取Sheet个数及判断sheet(i)是否为空，为空则不操作
            //读取sheet
            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet.getLastRowNum() == 0) {
                    continue;
                }
                //获取标题
                for (int i = 0; i < 1; i++) {
                    HSSFRow row_title = hssfSheet.getRow(i);
                    for (int columns = 0; columns < row_title.getPhysicalNumberOfCells(); columns++) {
                        //获取标题getLastCellNum()
                        if (row_title.getCell(columns).getStringCellValue() != null && !"".equals(row_title.getCell(columns).getStringCellValue())) {
                            map.put(columns + "", row_title.getCell(columns).getStringCellValue());
                        }
                    }
                }
                //获取列
                for (int rowCount = 2; rowCount <= hssfSheet.getLastRowNum(); rowCount++) {
                    HSSFRow row_record = hssfSheet.getRow(rowCount);
                    boolean flags = isBlankRow(row_record);
                    if (flags) {
                        continue;
                    }
                    HSSFCell cell = null;
                    int minColIndex = row_record.getFirstCellNum();//最小列号
                    int maxColIndex = map.size();//最大列号
//                    int maxColIndex = row_record.getLastCellNum();//最大列号
                    Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
                    bindMap = new HashMap<>();
                    while (entries.hasNext()) {
                        Map.Entry<String, Object> entry = entries.next();
                        cell = row_record.getCell(Integer.parseInt(entry.getKey()));
                        String values = valTypeResolve(cell);
                        bindMap.put(entry.getValue().toString(), values);
                    }
                    bindMap.put("rowIndex", row_record.getRowNum() + 1);
                    mapList.add(bindMap);
                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapList;
    }


    /**
     * 解析.xlsx文件
     *
     * @param inXlsx
     * @return
     */
    public static List<Map<String, Object>> readXlsx(InputStream inXlsx) {
        List<Map<String, Object>> mapList = new ArrayList<>();//封装后的集合
        Map<String, Object> map = null;//标题
        Map<String, Object> bindMap = null;//解析EXCEL后获取的Key-Value集合

        //声明工作簿
        XSSFWorkbook xssfWorkbook = null;
        try {
            xssfWorkbook = new XSSFWorkbook(inXlsx);
            map = new HashMap<>();
            for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                if (xssfSheet.getLastRowNum() == 0) {
                    continue;
                }
                //获取标题
                for (int i = 0; i < 1; i++) {
                    XSSFRow row_title = xssfSheet.getRow(i);
                    for (int columns = 0; columns < row_title.getPhysicalNumberOfCells(); columns++) {
                        //获取标题getLastCellNum()
                        if (row_title.getCell(columns).getStringCellValue() != null && !"".equals(row_title.getCell(columns).getStringCellValue())) {
                            map.put(columns + "", row_title.getCell(columns).getStringCellValue());
                        }
                    }
                }
                //获取列
                for (int rowCount = 1; rowCount <= xssfSheet.getLastRowNum(); rowCount++) {
                    XSSFRow row_record = xssfSheet.getRow(rowCount);
                    boolean flags = isBlankRowx(row_record);
                    if (flags) {
                        continue;
                    }
                    XSSFCell cell = null;
                    int minColIndex = row_record.getFirstCellNum();//最小列号
                    int maxColIndex = map.size();//最大列号
//                    int maxColIndex = row_record.getLastCellNum();//最大列号
                    Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
                    bindMap = new HashMap<>();
                    while (entries.hasNext()) {
                        Map.Entry<String, Object> entry = entries.next();
                        cell = row_record.getCell(Integer.parseInt(entry.getKey()));
                        String values = valTypeResolve(cell);
                        bindMap.put(entry.getValue().toString(), values);
                    }
                    bindMap.put("rowIndex", row_record.getRowNum() + 1);
                    mapList.add(bindMap);
                }
            }
            inXlsx.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapList;
    }

    /**
     * .xls判断是否为空行
     *
     * @param row_record
     * @return
     */
    private static boolean isBlankRow(HSSFRow row_record) {
        return row_record.cellIterator().next().toString().isEmpty();
    }

    /**
     * .xlsx判断是否空行
     *
     * @param row_record
     * @return
     */
    private static boolean isBlankRowx(XSSFRow row_record) {
        return row_record.cellIterator().next().toString().isEmpty();
    }


    /**
     * .xls文件数据类型转换
     *
     * @param cell
     * @return
     */
    public static String valTypeResolve(HSSFCell cell) {
        SimpleDateFormat dateFormat = null;
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            case Cell.CELL_TYPE_NUMERIC:
                //判断日期数据并格式化
                if (cell.getCellStyle().getDataFormat() == 31 || cell.getCellStyle().getDataFormat() == 58 || cell.getCellStyle().getDataFormat() == 32) {
                    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
                    Date date = cell.getDateCellValue();
                    return dateFormat.format(date);
                }
                cell.setCellType(Cell.CELL_TYPE_STRING);
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            default:
                return "";
        }
    }

    /**
     * .xlsx文件数据类型转换
     *
     * @param cell
     * @return
     */
    public static String valTypeResolve(XSSFCell cell) {
        SimpleDateFormat dateFormat = null;
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            case Cell.CELL_TYPE_NUMERIC:
                //判断日期数据并格式化
                if (cell.getCellStyle().getDataFormat() == 31 || cell.getCellStyle().getDataFormat() == 58 || cell.getCellStyle().getDataFormat() == 32) {
                    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
                    Date date = cell.getDateCellValue();
                    return dateFormat.format(date);
                }
                cell.setCellType(Cell.CELL_TYPE_STRING);
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            default:
                return "";
        }
    }

    /**
     * 下载EXCEL接口
     *
     * @param response
     * @return
     * @throws Exception
     */
    public static Map<String, Object> exportExcel(HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

}
