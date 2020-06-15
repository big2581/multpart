package com.big.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import com.big.entity.Upload;

public class POIReadWrite {

	public static void main(String[] args) throws IOException {
//		createExecl("zhangsan");
		getExecl("C:\\poi\\zhangsan.xls");
	}
	//创建一个表格名字为name的
	public static void createExecl(String name) throws IOException {
		String filePath="C:\\poi\\"+name+".xls";//文件路径
		HSSFWorkbook workbook=new HSSFWorkbook();//创建Excel文件(Workbook)
		HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
		sheet= workbook.createSheet("Test");//创建工作表(Sheet)
		FileOutputStream out= new FileOutputStream(filePath);
		workbook.write(out);//保存Excel文件
		out.close();//关闭文件流
		System.out.println("OK!");
	}
	//读取那个路径下的文件
	public static void getExecl(String path) throws IOException {
		FileInputStream file=new FileInputStream(path);
		HSSFWorkbook hw=new HSSFWorkbook(file);
		HSSFSheet sheet = hw.getSheet("Test");
				
		Iterator<Row> iterator = sheet.iterator();
		
		while(iterator.hasNext()) {
			Upload up=new Upload();
			System.out.println("");
			Row row = iterator.next();
			for (Cell cell : row) {
				String cellValueByCell = getCellValueByCell(cell);
				System.out.println(cellValueByCell);
				System.out.println(".......");
			}
			
		}
		file.close();
	}
	//获取单元格各类型值，返回字符串类型
    public static String getCellValueByCell(Cell cell) {
        //判断是否为null或空串
        if (cell==null || cell.toString().trim().equals("")) {
            return "";
        }
        String cellValue = "";
        int cellType=cell.getCellType();
        switch (cellType) {
        case Cell.CELL_TYPE_NUMERIC: // 数字
            short format = cell.getCellStyle().getDataFormat();
            if (DateUtil.isCellDateFormatted(cell)) {
                SimpleDateFormat sdf = null;  
                //System.out.println("cell.getCellStyle().getDataFormat()="+cell.getCellStyle().getDataFormat());
                if (format == 20 || format == 32) {  
                    sdf = new SimpleDateFormat("HH:mm");  
                } else if (format == 14 || format == 31 || format == 57 || format == 58) {  
                    // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)  
                    sdf = new SimpleDateFormat("yyyy-MM-dd");  
                    double value = cell.getNumericCellValue();  
                    Date date = org.apache.poi.ss.usermodel.DateUtil  
                            .getJavaDate(value);  
                    cellValue = sdf.format(date);  
                }else {// 日期  
                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                }  
                try {
                    cellValue = sdf.format(cell.getDateCellValue());// 日期
                } catch (Exception e) {
                    try {
                        throw new Exception("exception on get date data !".concat(e.toString()));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }finally{
                    sdf = null;
                }
            }  else {
                BigDecimal bd = new BigDecimal(cell.getNumericCellValue()); 
                cellValue = bd.toPlainString();// 数值 这种用BigDecimal包装再获取plainString，可以防止获取到科学计数值
            }
            break;
        case Cell.CELL_TYPE_STRING: // 字符串
            cellValue = cell.getStringCellValue();
            break;
        case Cell.CELL_TYPE_BOOLEAN: // Boolean
            cellValue = cell.getBooleanCellValue()+"";;
            break;
        case Cell.CELL_TYPE_FORMULA: // 公式
            cellValue = cell.getCellFormula();
            break;
        case Cell.CELL_TYPE_BLANK: // 空值
            cellValue = "";
            break;
        case Cell.CELL_TYPE_ERROR: // 故障
            cellValue = "ERROR VALUE";
            break;
        default:
            cellValue = "UNKNOW VALUE";
            break;
        }
        return cellValue;
    }
}
