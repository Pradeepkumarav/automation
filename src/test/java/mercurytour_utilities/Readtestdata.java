package mercurytour_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Readtestdata {
	
	public static String[][] getExcelData(String fileName, String sheetName) throws Exception  {
        String[][] data = null;
       
 
            FileInputStream fis = new FileInputStream(fileName);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheet(sheetName);
            
            
            HSSFRow row = sheet.getRow(0);
            
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            
            
            Cell cell;
            data = new String[noOfRows][noOfCols];
           
            
            DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
          
            for (int i = 0; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    //data[i][j] = cell.getStringCellValue();
                    data[i][j]=  formatter.formatCellValue(cell);
                }
            }
     
        return data;
	    }
	
	
	
}
