package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelReader {
	
	public List<HashMap<String, String>> readTestSuiteData() {
	
	File file = new File(System.getProperty("user.dir")+ "/TestSuite/testsuite.xls");
	FileInputStream fis;
	String [][] testSuiteData = null;
	List<HashMap<String, String>> testData = new ArrayList<>();
	HashMap<String, String> testSuiteDataMap = new HashMap<>();
	try {
		fis = new FileInputStream(file);
		
		
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet("Sheet1");
		
		HSSFRow row = null ;
		HSSFCell keywordCell;
		HSSFCell locatorCell;
		HSSFCell inputCell;
		String keywordCellData;
		String locatorCellData;
		String inputCellData;
		int rowNum = sheet.getLastRowNum();
		
		
		
		for (int i = 1; i <= rowNum; i++) {
			
			row = sheet.getRow(i);
			
			keywordCell = row.getCell(0);
			locatorCell = row.getCell(1);
			inputCell = row.getCell(2);

			keywordCellData = keywordCell.getStringCellValue();
			locatorCellData = locatorCell.getStringCellValue();
			inputCellData = inputCell.getStringCellValue();
			
			testSuiteDataMap.put("keyword", keywordCellData);
			testSuiteDataMap.put(Constant.locator, locatorCellData);
			testSuiteDataMap.put(Constant.input, inputCellData);
			testData.add(testSuiteDataMap);
			/*testSuiteData[i][0] = keywordCellData;
			testSuiteData[i][1] = locatorCellData;
			testSuiteData[i][2] = inputCellData;*/
		}
		
		
	}catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return testData;
}

}
