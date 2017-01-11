package com.xframework.boot.poi.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelSheetReadCallbackAdapter implements ExcelSheetReadCallback {

	@Override
	public void readOneSheet(Sheet sheet, int sheetIndex) {
		// do nothing		
	}

	@Override
	public void readOneRow(Sheet sheet, Row row, int sheetIndex, int rowIndex) {
		// do nothing		
	}

	@Override
	public void readOneCell(Sheet sheet, Row row, Cell cell, int sheetIndex, int rowIndex, int cellIndex) {
		// do nothing		
	}

	@Override
	public void readOneCell(Sheet sheet, Row row, Cell cell, String data, int sheetIndex, int rowIndex, int cellIndex) {
		// do nothing		
	}

}
