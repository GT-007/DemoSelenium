package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadTestData {
	 
	/*public static void main (String[] ar)
	{
		Map<String, String> checkMap = new HashMap();
		try {
			checkMap = fun_fetchTestData("src/test/resources/TestData.xlsx", 
					"AutomationExercise", "TC01_RegisterNewUser");
			System.out.print(checkMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Not Found :(");
			e.printStackTrace();
			System.exit(0);
		}
		
	}*/
	
	 public static Map<String, String> fun_fetchTestData(String filePath, String sheetName, String strTestClass) throws IOException
	 {
		 int intTestDataRow = 0;
		 boolean bolDataFound = false;
		 Map<String, String> hashMap_testData = new HashMap<>();
		 
		 FileInputStream fis = new FileInputStream(filePath);
		 Workbook workbook = new XSSFWorkbook(fis);
		 Sheet sheet = workbook.getSheet(sheetName);

		 

	     int rows = sheet.getPhysicalNumberOfRows();
	     int cols = sheet.getRow(0).getPhysicalNumberOfCells();
	     
	     for( int i = 0; i < rows; i++)
	     {
	    	 Row row = sheet.getRow(i);
	    	 //if (row == null) continue;
	    	 String strTestName = row.getCell(0).toString();
	    	 if (strTestName.equalsIgnoreCase(strTestClass))
	    	 {
	    		 intTestDataRow = row.getRowNum();
	    		 bolDataFound = true;
	    		 System.out.println("Test data found");
	    		 break;
	    	 }
	     }
	     
	     if (!bolDataFound)
	     {
	    	 System.err.println("Test data not found");
	    	 workbook.close();
	    	 throw new RuntimeException("Test data not found for: " + strTestClass);
	     }
	     
	     Row headerRow = sheet.getRow(0);
	     Row dataRow = sheet.getRow(intTestDataRow);
	     
	     for (int j = 1; j < cols; j++) 
	     {
	    	 String strColHeader, strData;
	    	 
	    	 strColHeader = headerRow.getCell(j).toString();
	    	 strData = dataRow.getCell(j).toString();
	    	 hashMap_testData.put(strColHeader, strData);

	     }
	        
	     workbook.close();
	     fis.close();
	     return hashMap_testData;
	 }

}
