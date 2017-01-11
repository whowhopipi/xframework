package com.xframework.boot.poi.excel.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.xframework.boot.poi.excel.ExcelHelper;
import com.xframework.boot.poi.excel.ExcelSheetReadCallbackAdapter;
import com.xframework.boot.poi.test.XframeworkBootPoiApplicationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = XframeworkBootPoiApplicationTest.class)
@WebAppConfiguration
public class ExcelHelperTest {

	@Test
	public void test1() throws FileNotFoundException, IOException {
		File file = new File("e:\\excel.xlsx");
		Workbook workbook = ExcelHelper.readWorkbook(file);
		ExcelHelper.readExcel(workbook, new ExcelSheetReadCallbackAdapter() {
			@Override
			public void readOneCell(Sheet sheet, Row row, Cell cell, String data, int sheetIndex, int rowIndex,
					int cellIndex) {
				System.out.println("第" + sheetIndex + "页，第" + rowIndex + "行，第" + cellIndex + "列，数据：" + data);
			}
		});
	}
}
