package com.xframework.boot.poi.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

	final public static String XLS = ".xls";
	final public static String XLSX = ".xlsx";
	final public static String XLSM = ".xlsm";

	public static void readExcel(File file, ExcelSheetReadCallback callback) throws FileNotFoundException, IOException {
		Workbook workbook = readWorkbook(file);

		for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
			Sheet sheet = workbook.getSheetAt(sheetIndex);

			callback.readOneSheetBegin(sheet, sheetIndex);

			int maxRows = sheet.getPhysicalNumberOfRows();

			for (int rowIndex = 0; rowIndex < maxRows; rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				callback.readOneRowBegin(sheet, row, sheetIndex, rowIndex);

				short lastCellNum = row.getLastCellNum();

				for (int cellIndex = 0; cellIndex < lastCellNum; cellIndex++) {
					Cell cell = row.getCell(cellIndex);

					callback.readOneCell(sheet, row, cell, sheetIndex, rowIndex, cellIndex);

					String value = null;
					switch (cell.getCellTypeEnum()) {
					case NUMERIC:
						value = String.valueOf(cell.getNumericCellValue());
						break;
					case STRING:
						value = cell.getStringCellValue();
						break;
					case FORMULA:
						value = cell.getCellFormula();
						break;
					case BOOLEAN:
						value = String.valueOf(cell.getBooleanCellValue());
						break;
					case ERROR:
						value = String.valueOf(cell.getErrorCellValue());
						break;
					case BLANK:
					case _NONE:
						break;
					}
					callback.readOneCell(sheet, row, cell, value, sheetIndex, rowIndex, cellIndex);
				}
				callback.readOneRowEnd(sheet, row, sheetIndex, rowIndex);
			}
			
			callback.readOneSheetEnd(sheet, sheetIndex);
		}
	}

	private static Workbook readWorkbook(File file) throws FileNotFoundException, IOException {
		if (!file.exists())
			throw new NullPointerException("文件[" + file.getAbsolutePath() + "]不存在");

		String name = file.getName().toLowerCase();
		if (name.endsWith(XLS)) {
			return new HSSFWorkbook(new FileInputStream(file));
		} else if (name.endsWith(XLSX) || name.endsWith(XLSM)) {
			return new XSSFWorkbook(new FileInputStream(file));
		} else {
			throw new RuntimeException("不是excel文件");
		}
	}
}
