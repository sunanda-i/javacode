package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static Object[][]getExcelData(String filePath, String sheetName) throws IOException{
	
	FileInputStream fis = new FileInputStream(filePath);
	Workbook wb = new XSSFWorkbook(fis);
    Sheet sheet = wb.getSheet(sheetName);
    
    int rows = sheet.getPhysicalNumberOfRows();
    int cols = sheet.getRow(0).getPhysicalNumberOfCells();
    
    Object[][] data = new Object[rows - 1][cols];

    for (int i = 1; i < rows; i++) {
        Row row = sheet.getRow(i);

        for (int j = 0; j < cols; j++) {
            Cell cell = row.getCell(j);

            data[i - 1][j] = cell.getStringCellValue();
        }
    }

    wb.close();
    fis.close();

    return data;
	}
}
