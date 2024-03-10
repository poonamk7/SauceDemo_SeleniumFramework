package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static List<Map<String, String>> getData() throws Exception {

		File file = new File(System.getProperty("user.dir") + "/src/test/resources/TestData/testdata.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet("login");

		XSSFRow headerRow = sheet.getRow(0);
		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

		List<Map<String, String>> data = new ArrayList<>();

		for (int i = 1; i < totalRows; i++) {
			XSSFRow row = sheet.getRow(i);
			Map<String, String> rowData = new HashMap<>();

			for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
				XSSFCell headerCell = headerRow.getCell(j);
				XSSFCell dataCell = row.getCell(j);

				// Assuming all data is treated as String for simplicity

				String columnName = headerCell.getStringCellValue();
				String cellValue = dataCell == null ? "" : dataCell.getStringCellValue();

				rowData.put(columnName, cellValue);
			}

			data.add(rowData);
		}

		workbook.close();
		fileInputStream.close();

		return data;

	}

	public static List<String> readData(String tetcasename) throws Exception {

		List<Map<String, String>> excelData = getData();
		List<String> loginDetails = new ArrayList<String>();

		// Access the data from the list of HashMap
		for (Map<String, String> row : excelData) {
			if (row.get("testcasename").equalsIgnoreCase(tetcasename)) {
				loginDetails.add(row.get("username"));
				loginDetails.add(row.get("password"));
				loginDetails.add(row.get("productnameone"));
				loginDetails.add(row.get("productnametwo"));
				loginDetails.add(row.get("expectedvalidationone"));
				loginDetails.add(row.get("expectedvalidationtwo"));
				loginDetails.add(row.get("expectedvalidationthree"));
			}
		}

		return loginDetails;

	}

}
