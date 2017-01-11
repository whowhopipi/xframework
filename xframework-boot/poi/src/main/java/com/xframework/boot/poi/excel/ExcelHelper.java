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

	@SuppressWarnings("deprecation")
	public static void readExcel(Workbook workbook, ExcelSheetReadCallback callback, int[] sheets, int[] startRow)
			throws FileNotFoundException, IOException {
		if (sheets.length != startRow.length) {
			throw new RuntimeException("读取页和起始行，数目不一致。");
		}

		for (int sheetIndex : sheets) {
			Sheet sheet = workbook.getSheetAt(sheetIndex);

			if (callback.readOneSheetBegin(sheet, sheetIndex, startRow[sheetIndex])) {
				int maxRows = sheet.getPhysicalNumberOfRows();

				for (int rowIndex = startRow[sheetIndex]; rowIndex < maxRows; rowIndex++) {
					Row row = sheet.getRow(rowIndex);
					if (callback.readOneRowBegin(sheet, row, sheetIndex, rowIndex)) {

						int maxCell = row.getLastCellNum();

						for (int cellIndex = 0; cellIndex < maxCell; cellIndex++) {
							Cell cell = row.getCell(cellIndex);

							String value = null;

							// FIXME 待官方提供新的API
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
				}

				callback.readOneSheetEnd(sheet, sheetIndex);
			}
		}
	}

	public static void readExcel(Workbook workbook, ExcelSheetReadCallback callback)
			throws FileNotFoundException, IOException {
		int sheetNum = workbook.getNumberOfSheets();

		int[] sheets = new int[sheetNum];
		int[] startRow = new int[sheetNum];

		for (int i = 0; i < sheetNum; i++) {
			sheets[i] = i;
			startRow[i] = 0;
		}

		readExcel(workbook, callback, sheets, startRow);
	}

	public static Workbook readWorkbook(File file) throws FileNotFoundException, IOException {
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
