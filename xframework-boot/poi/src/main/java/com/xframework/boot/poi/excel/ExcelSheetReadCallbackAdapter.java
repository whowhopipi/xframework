package com.xframework.boot.poi.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelSheetReadCallbackAdapter implements ExcelSheetReadCallback {

	@Override
	public boolean readOneSheetBegin(Sheet sheet, int sheetIndex, int startRow) {
		return true;
	}

	@Override
	public void readOneSheetEnd(Sheet sheet, int sheetIndex) {
		// do nothing
	}

	@Override
	public boolean readOneRowBegin(Sheet sheet, Row row, int sheetIndex, int rowIndex) {
		return true;
	}

	@Override
	public void readOneRowEnd(Sheet sheet, Row row, int sheetIndex, int rowIndex) {
	}

	@Override
	public void readOneCell(Sheet sheet, Row row, Cell cell, String data, int sheetIndex, int rowIndex, int cellIndex) {
		// do nothing
	}

}
