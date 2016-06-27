package rnd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class datakarthi

{

	 @DataProvider(name = "Searchitem1",parallel= true)
	
	public static Object[][] searchitem()

	{
		//return new Object[][] { { "RFT" }, { "Selenium" }, { "Manual Testing"} };

		Object[][] karthi = new Object[3][1];

		karthi[0][0] = "RFT";
		karthi[1][0]= "Selenium";
		//karthi[2][0]= "Manual Testing";
		return karthi;
		
/*
 * 
		List<Object[]> dataToBeReturned = new ArrayList<Object[]>();
		for (Object[] userData : karthi) {
			dataToBeReturned.add(new Object[] { userData });
		}
		// / Arrays.

		for (Object[] objects : dataToBeReturned) {
			System.out.println(dataToBeReturned);
		}

*/ 	//return new Object[][] { new Object[] { "kk" } };
	}

}
