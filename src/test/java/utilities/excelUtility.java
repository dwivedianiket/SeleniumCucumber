package utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {
    private static final String filePath = "C:\\Users\\2408461\\eclipse-workspace\\SeleniumMajorProjectCucumber\\testdata\\TestData.xlsx";

    public static String getCellData(String sheetName, int rowNum, int colNum) {
    	DataFormatter formatter = new DataFormatter();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            if (row == null) return "";
            Cell cell = row.getCell(colNum);
            return cell != null ? formatter.formatCellValue(cell) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String[] getRowData(String sheetName, int rowNum) {
        String[] data = new String[5];
        for (int i = 0; i < 5; i++) {
            data[i] = getCellData(sheetName, rowNum, i);
        }
        return data;
    }
}
