package com.qdfae.jdk.pdfconvertor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.huajin.baymax.exception.BayMaxBaseException;
import com.huajin.baymax.logger.XMsgError;
import com.huajin.baymax.logger.Xlogger;
import com.huajin.baymax.support.ResponseCodeBase;

public class PdfProcessSupport {
	
	/**
	 * 读取Excel文件，得到CSV文件
	 * @return File
	 * @author hongbo.zhao
	 * 2016年12月21日 下午1:46:21
	 */
	public static File readFromExcelToCsv(File excelFile) throws IOException {
		String separator = ",";
		if(!excelFile.exists() || !excelFile.isFile()) {
			throw new IOException();
		}
		//读Excel文件
		List<String[]> contentList = readFirstSheetFromExcelFile(excelFile);
		//创建CSV文件
		String excelFileName = excelFile.getName();
		String csvFileName = excelFileName.substring(0,excelFileName.lastIndexOf(".")) + ".csv";
		File csvFile = new File(excelFile.getParent(), csvFileName);
		//写入CSV文件
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(csvFile));
		StringBuffer buffer = new StringBuffer();
		for(String [] array: contentList) {
			for(int i=0;i<array.length;i++) {
				buffer.append(array[i]);
				if(i != array.length-1) {
					buffer.append(separator);
				}
			}
			buffer.append("\n");
		}
		buffer.deleteCharAt(buffer.length()-1);
		bufferedWriter.write(buffer.toString());
		bufferedWriter.close();
		return csvFile;
	}
	
	/**
	 * 工具方法：从excel文件中抽取数据,多个sheet数据会进行合并
	 * @param excelFile，Excel文件
	 * @return List<String> 所有列的list,当读取文件出错时返回null
	 * @author hongbo.zhao
	 * 2016年12月7日 下午5:06:16
	 * @throws IOException 
	 */
	public static List<String[]> readFromExcelFile(File excelFile) throws IOException {
		if(!isExcel(excelFile)) {
			throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null, "文件类型错误");
		}
		List<String[]> resultList = new ArrayList<String[]>();
		boolean isHSSF = excelFile.getName().endsWith(".xls");//是否是xls
		boolean isXSSF = excelFile.getName().endsWith(".xlsx");//是否是xlsx
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(excelFile);
			//获取excel的workbook
			Workbook workbook = null;
			if(isHSSF){
				workbook = new HSSFWorkbook(inputStream);
			}else if(isXSSF){
				workbook = new XSSFWorkbook(inputStream);
			}
			if(workbook == null){
				throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null, "文件内数据为空!");
			}
			//获取所有的sheet
			for(Iterator<Sheet> it = workbook.iterator();it.hasNext();){
				Sheet sheet = it.next();
				//处理一个sheet
				List<String[]> tempList = handleSheet(sheet);
				resultList.addAll(tempList);
			}
		} catch (FileNotFoundException e) {
			Xlogger.error(XMsgError.buildSimple("FileTool", "找不到Spring创建的临时文件", e));
		} catch (IOException e) {
			Xlogger.error(XMsgError.buildSimple("FileTool", "读取Spring临时文件失败", e));
		} finally {
			inputStream.close();
		}
		return resultList;
	}
	
	public static List<String[]> readFirstSheetFromExcelFile(File excelFile) throws IOException {
		if(!isExcel(excelFile)) {
			throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null, "文件类型错误");
		}
		List<String[]> resultList = new ArrayList<String[]>();
		boolean isHSSF = excelFile.getName().endsWith(".xls");//是否是xls
		boolean isXSSF = excelFile.getName().endsWith(".xlsx");//是否是xlsx
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(excelFile);
			//获取excel的workbook
			Workbook workbook = null;
			if(isHSSF){
				workbook = new HSSFWorkbook(inputStream);
			}else if(isXSSF){
				workbook = new XSSFWorkbook(inputStream);
			}
			if(workbook == null){
				throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null, "文件内数据为空!");
			}
			
			Sheet sheet = workbook.getSheetAt(0);
			resultList = handleSheet(sheet);
		} catch (FileNotFoundException e) {
			Xlogger.error(XMsgError.buildSimple("FileTool", "找不到Spring创建的临时文件", e));
		} catch (IOException e) {
			Xlogger.error(XMsgError.buildSimple("FileTool", "读取Spring临时文件失败", e));
		} finally {
			inputStream.close();
		}
		return resultList;
	}
	
	public static List<String[]> handleSheet(Sheet sheet) {
		//获取头部第一行
		Row headRow = sheet.getRow(0);
		//获取总行数
		int totalRow = sheet.getLastRowNum();
		int totalCell = headRow.getLastCellNum();//总列数
		List<String[]> list = new ArrayList<String[]>();
		//循环行里面的内容，会排除表头
		for(int i = 1; i <= totalRow; i++){
			//获取行
			Row currRow = sheet.getRow(i);//第i行
			if(currRow == null) {
				//空行跳过
				continue;
			}
			String[] line = new String[totalCell];
			for(int j = 0; j < totalCell; j++) {
				Cell cell = currRow.getCell(j);
				if(cell != null) {
					Object obj = getCellValue(cell);
					line[j] = obj == null ? "" : obj.toString().trim();
				}else{
					line[j] = "";
				}
			}
			//兼容空白行
			boolean blankRow = true;
			for(String cell : line) {
				if (!StringUtils.isBlank(cell)) {
					blankRow = false;
				}
			}
			if(!blankRow) {
				list.add(line);
			}
		}
		return list;
	}
	
	/**
	 * 获取列的数据项
	 * @return Object
	 * @author hongbo.zhao
	 * 2016年11月30日 下午2:26:31
	 */
	@SuppressWarnings("deprecation")
	public static Object getCellValue(Cell cell){
		Object object = null;
		switch (cell.getCellTypeEnum()) {
			case _NONE:
				break;
	
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat format = new SimpleDateFormat("YYYYMMddHHmmss");
					object = format.format(cell.getDateCellValue());
				} else {
					long longVal = Math.round(cell.getNumericCellValue());
					String str = null;
					if (Double.parseDouble(longVal + ".0") == cell.getNumericCellValue()) {
						str = String.valueOf(longVal);
					}else {
						str = String.valueOf(cell.getNumericCellValue());
					}
					BigDecimal bd =new BigDecimal(str);
					object = bd.toPlainString();
				}
				break;
	
			case STRING:
				object = cell.getStringCellValue().trim();
				break;
	
			case FORMULA:
				object = new BigDecimal(String.valueOf(cell.getNumericCellValue()));
				break;
			case BLANK:
				object = cell.getStringCellValue().trim();
				break;
			case BOOLEAN:
				break;
			case ERROR:
				break;
			default:
				break;
		}
		return object;
	}
	/**
	 * 判断文件是否是PDF文件
	 * @return boolean
	 * @author hongbo.zhao
	 * 2016年11月30日 上午11:12:49
	 */
	public static boolean isPdf(File file) {
		if(file == null || !file.exists() || !file.isFile()) {
			return false;
		}
		boolean result = true;
		String fileName = file.getName();
		if(!fileName.endsWith(".pdf")) {
			result = false;
		}
		return result;
	} 
	
	/**
	 * 判断文件是否是excel文件
	 * @return boolean
	 * @author hongbo.zhao
	 * 2016年11月30日 上午11:13:07
	 */
	public static boolean isExcel(File file) {
		if(file == null || !file.exists() || !file.isFile()) {
			return false;
		}
		boolean result = false;
		String fileName = file.getName();
		if(fileName.endsWith(".xls") || fileName.endsWith(".xlsx")) {
			result = true;
		}
		return result;
	}
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Public\\STS-workspace\\ygmd2.xlsx");
		try {
			List<String[]> list = readFirstSheetFromExcelFile(file);
			for (int i = 0; i < list.size(); i++) {
				String [] strArray = list.get(i);
				for(String str :strArray) {
					System.out.println(str);
				}
			}
			System.out.println(list.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
