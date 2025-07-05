package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtilities {
	//DataProvider->1
		@DataProvider(name="dataSupplier")
		public static Object supplyPassword()
		{
			Object [] [] data= {{"12345"},{"abcdefghi"},{"abcd1234"},{"abcd12345"},{"ABCD045#"}};
					
			return data;
		}
		//DataProvider->2
		@DataProvider(name="loginData")
		public Object[][] getData() throws Exception
		{
			String path=System.getProperty("user.dir")+"\\testData\\loginData.xlsx";
			ExcelUtility utility=new ExcelUtility(path);
			int row=utility.getRowCount("Sheet1");
			int cell=utility.getCellCount("Sheet1", 1);
			
	      String[] [] loginData=new String [row][cell];
			for(int i=1;i<row;i++)
			{
				for(int j=0;j<cell;j++)
				{
					loginData[i-1][j]=utility.getCellData("Sheet1", i, j);
				}
			}
			return loginData;//returning two dimentional array
		}

}
