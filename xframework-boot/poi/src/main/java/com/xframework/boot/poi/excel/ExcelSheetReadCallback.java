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
	 * 读取一个Sheet
	 * 
	 * @param sheet
	 * @param sheetIndex
	 */
	public void readOneSheet(Sheet sheet, int sheetIndex);

	/**
	 * 读取一行
	 * 
	 * @param sheet
	 * @param row
	 * @param sheetIndex
	 * @param rowIndex
	 */
	public void readOneRow(Sheet sheet, Row row, int sheetIndex, int rowIndex);

	/**
	 * 读取一个格
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param sheetIndex
	 * @param rowIndex
	 * @param cellIndex
	 */
	public void readOneCell(Sheet sheet, Row row, Cell cell, int sheetIndex, int rowIndex, int cellIndex);

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
