package com.test;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.util.Constant;
import com.util.ExcelReader;

public class TestSuiteClass  extends BaseClass{
	
	@Test
	public void TestMethod() {
		
		ExcelReader excel = new ExcelReader();
		CommonMethods common = new CommonMethods();
		driver.get("http://www.automationpractice.com/");
		
		List<HashMap<String, String>> excelData = excel.readTestSuiteData();
		for (HashMap<String, String> hashMap : excelData) {
			System.out.println(hashMap.get("keyword"));
			/*System.out.println(hashMap.get(Constant.locator));
			System.out.println(hashMap.get(Constant.input));*/
			
			switch (hashMap.get(Constant.keyword)) {
			case "click":
				common.clickMethod(driver, hashMap.get(Constant.locator));
				break;
			case "enter_text":
				common.enter_text(driver, hashMap.get(Constant.locator), hashMap.get(Constant.input));
				break;
			default:
				break;
			}
			
		}
		
	}

}
