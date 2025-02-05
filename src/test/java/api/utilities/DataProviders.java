package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders{
	@DataProvider(name= "AllData")
	public String  [][] AllDataProvider() {
		
		String path="C:\\Users\\Bhavna sharma\\eclipse-workspace\\RestAssuredAutomation\\TestData\\RestAssured test cases.xlsx";
		
		int totalrows=ExcelUtility.getRowCount(path, "Sheet2");
		int totalcolumn=ExcelUtility.getColCount(path, "Sheet2");
		
		String userData[][]= new String[totalrows-1][totalcolumn];
		
		for(int rowNo=1; rowNo<totalrows; rowNo++)
		{
			for(int colNo=0; colNo<totalcolumn; colNo++)
			{
				
				userData[rowNo-1][colNo]=ExcelUtility.getCellValue(path, "sheet2", rowNo, colNo);
	      
				/*   String cellValue = ExcelUtility.getCellValue(path, "Sheet2", rowNo, colNo);
	                 userData[rowNo - 1][colNo] = cellValue;

	            // Debug log to check the values being read
	                  System.out.println("Row: " + (rowNo) + ", Column: " + colNo + " -> " + cellValue);
				*/		
			}	}
	return userData;
}
	
	
	@DataProvider(name="UseNameData")
	public String  [] UserNameDataProvider() {
		
		String path="C:\\Users\\Bhavna sharma\\eclipse-workspace\\RestAssuredAutomation\\TestData\\RestAssured test cases.xlsx";
		
		int totalrows=ExcelUtility.getRowCount(path, "Sheet2");
		
		String userNameData[]= new String[totalrows-1];
		
		for(int rowNo=1; rowNo<totalrows; rowNo++)
		{
				userNameData[rowNo-1]=ExcelUtility.getCellValue(path, "Sheet2", rowNo, 1);
		}
		return userNameData;
	}}