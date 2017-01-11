package com.xframework.boot.poi.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Excel读取回调
 *
 */
public interface ExcelSheetReadCallback {

	/**
	 * @param sheet
	 * @param sheetIndex
	 * @param startRow
	 * @return
	 */
	public boolean readOneSheetBegin(Sheet sheet, int sheetIndex, int startRow);

	/**
	 * 读取一个Sheet结束
	 * 
	 * @param sheet
	 * @param sheetIndex
	 */
	public void readOneSheetEnd(Sheet sheet, int sheetIndex);

	/**
	 * 开始读取一行数据
	 * 
	 * @param sheet
	 * @param row
	 * @param sheetIndex
	 * @param rowIndex
	 */
	public boolean readOneRowBegin(Sheet sheet, Row row, int sheetIndex, int rowIndex);

	/**
	 * 读取一行数据结束
	 * 
	 * @param sheet
	 * @param row
	 * @param sheetIndex
	 * @param rowIndex
	 */
	public void readOneRowEnd(Sheet sheet, Row row, int sheetIndex, int rowIndex);

	/**
	 * 读取一个格
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param data
	 * @param sheetIndex
	 * @param rowIndex
	 * @param cellIndex
	 */
	public void readOneCell(Sheet sheet, Row row, Cell cell, String data, int sheetIndex, int rowIndex, int cellIndex);
}
