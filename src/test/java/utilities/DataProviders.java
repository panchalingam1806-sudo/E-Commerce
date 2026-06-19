package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public String [][] getData() throws IOException
	{
		String path =(".\\testData\\Login_data.xlsx");
//		String path = (System.getProperty("user.dir")+"\\testData\\Login_data.xlsx");
		
		ExcelUtility utility = new ExcelUtility(path);
		
		int totalrows = utility.getRowCount("sheet1");
		int totalcols = utility.getCellCount("sheet1",1);
		
		String logindata[][] = new String [totalrows][totalcols];
		
		for(int r=1; r<=totalrows; r++)
		{
			for(int c=0;c<totalcols;c++)
			{
				logindata[r-1][c]=utility.getCellData("sheet1", r, c);
			}
		}
	return logindata;
	}
	
	/*
	@DataProvider(name="testData")
	public Object[][] testData() throws IOException
	{
		String path =(".\\testData\\Login_data.xlsx");

		
		ExcelUtility utility = new ExcelUtility(path);
		
		int totalrows = utility.getRowCount("testData")-1;
		int totalcols = utility.getCellCount("testData", 1);
//		
		
		List<Object[]> dataList = new ArrayList<>();
		
		   
		   for(int r=1; r<=totalrows; r++)
		   {
			   String execute = utility.getCellData("testData", r, totalcols - 1);
			   
			   if(execute.equalsIgnoreCase("yes"))
			   {
				   Object rowData[] = new Object[totalcols - 1];
			   
			   for(int c=0; c<totalcols-1; c++)
			   {
				   rowData[c] = utility.getCellData("testData", r, c);
				   System.out.println("Excel Value" + rowData[c]);
			   }
			   dataList.add(rowData);
			   } 
		   }
		   
		   Object[][] data = new Object[dataList.size()][];
		   
		   for(int i=0; i<dataList.size(); i++)
		   {
			   data[i] = dataList.get(i);
		   }
		   
	
		 return data;
	}
	
	
	
	
//    data[0][0] = utility.getCellData("testData", 1, 0);
//    System.out.println("Excel value: " + data[0][0]);
//    data[1][0] = utility.getCellData("testData", 2, 0);
//    System.out.println("Excel value: " + data[1][0]);
	
	*/
	
	
}
