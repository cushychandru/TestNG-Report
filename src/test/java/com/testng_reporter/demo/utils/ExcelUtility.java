package com.testng_reporter.demo.utils;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * <b>The Class ExcelUtility.</b><br>
 * Contains Excel Read, Write and other Operations related methods
 * @author Chandrashekhar Gouda
 * @version 1.0
 * @since 2018-10-22
 */
public class ExcelUtility {

	/**
	 * Gets the table data array.
	 *
	 * @param FilePath the excel file path
	 * @param sheetName the DATA Sheet name
	 * @param tableName the DATA table name
	 * @return the table data array
	 * @throws Exception the exception
	 */
	public static String[][] getTableArray(String FilePath, String sheetName, String tableName) {

		String[][] tabArray = null;
		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(FilePath));
		} catch (BiffException e) {
			e.printStackTrace();
			Assert.fail("Fail to read data file");
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Fail to read data file");
		}
		Sheet sheet = workbook.getSheet(sheetName);
		int startRow, startCol, endRow, endCol, ci, cj;
		Cell tableStart = sheet.findCell(tableName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();
		Cell tableEnd = findCell(sheet, tableName, startCol + 1, startRow + 1, 100, 64000, false);
		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;

		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}
		return (tabArray);

	}

	/**
	 * Gets the cell whose contents match the string passed in. If no match is found, then null is returned. The search is performed on a row by row basis, so the lower the row number, the more efficiently the algorithm will perform
	 * 
	 * @param contents the string to match
	 * @param firstCol the first column within the range
	 * @param firstRow the first row of the range
	 * @param lastCol the last column within the range
	 * @param lastRow the last row within the range
	 * @param reverse indicates whether to perform a reverse search or not
	 * @return the Cell whose contents match the parameter, null if not found
	 */
	public static Cell findCell(Sheet sheet, String contents, int firstCol, int firstRow, int lastCol, int lastRow, boolean reverse) {
		Cell cell = null;
		boolean found = false;

		int numCols = lastCol - firstCol;
		int numRows = lastRow - firstRow;

		int row1 = reverse ? lastRow : firstRow;
		int col1 = reverse ? lastCol : firstCol;
		int inc = reverse ? -1 : 1;

		for (int i = 0; i <= numCols && found == false; i++) {
			for (int j = 0; j <= numRows && found == false; j++) {
				int curCol = col1 + i * inc;
				int curRow = row1 + j * inc;
				if (curCol < sheet.getColumns() && curRow < sheet.getRows()) {
					Cell c = sheet.getCell(curCol, curRow);
					if (c.getType() != CellType.EMPTY) {
						if (c.getContents().equals(contents)) {
							cell = c;
							found = true;
						}
					}
				}
			}
		}

		return cell;
	}
}
