package com.yao.common.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : 妖妖
 * @date : 11:48 2020/9/2
 */
public class PoiExcleUtil {

    public static void saveFile(List<List<String>> data,String filePath,String fileName){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = workbook.createSheet("sales");

//        System.out.println("data.size() " + data.size());
        for (int i = 0 ; i < data.size() ; i++){
            HSSFRow row = hssfSheet.createRow(i);
            List<String> c = data.get(i);
//            System.out.println("c.size() "+c.size());
            for (int t = 0;t < c.size(); t++){
                HSSFCell cell = row.createCell(t);
                cell.setCellValue(c.get(t));
            }
        }
        File file = new File(filePath);
        OutputStream stream=null;
        try {
            stream = new FileOutputStream(new File(file, fileName));
            //document.write(stream);
            workbook.write(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (stream != null) ;
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<List<String>> readExcle(String filePath,int startRow,int colnum,int nullRow){
        Workbook wb =null;
        Sheet sheet = null;
        Row row = null;
        wb = readExcel(filePath);
        List<List<String>> beans = new ArrayList<>();
        if (wb != null){
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows()+nullRow;
            for(int i = startRow;i<rownum;i++){
//                System.out.println(i);
                row = sheet.getRow(i);
//                int colnum = row.getPhysicalNumberOfCells();
                List<String> bean = new ArrayList<>();
//                System.out.println(colnum);
                for (int t = 0 ; t < colnum ;t++){
                    String s = null;
                    try {
                        s = getCellFormatValue(row.getCell(t));
                    } catch (Exception e) {
                        e.printStackTrace();
                        s = "";
                    }
//                    System.out.println(i+"-"+t+"-"+s);
                    bean.add(s);
                }
                beans.add(bean);
            }
        }
        return beans;
    }


    public static String getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
                case Cell.CELL_TYPE_NUMERIC:{
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA:{
                    //判断cell是否为日期格式
                    if(org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return (String) cellValue;
    }

    private static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
}
