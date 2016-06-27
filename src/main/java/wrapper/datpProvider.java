package wrapper;

import org.testng.annotations.DataProvider;

public class datpProvider 
{

	
	@DataProvider(name="data")
	public Object[][] data() 
	
	{
		
		Object[][] datavalue = new Object[3][1];
		
		datavalue[0][0]="Selenium";
		datavalue[1][0]="RFT";
		datavalue[2][0]="Testing";
//		datavalue[3][0]="";
		
		return datavalue;
		
	}
}
