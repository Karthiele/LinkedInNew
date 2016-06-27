package rnd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import wrapper.LinkedInWrappersKarthi;

public class Datakarthiiterator extends LinkedInWrappersKarthi {

	@Test
	public void data()

	{

		Object[][] data = new Object[2][1];

		List<String> list = new ArrayList<String>();

		list.add("RFT");
		list.add("Selenium");

		Iterator it = list.iterator();
		while (it.hasNext()) {
			String value = (String) it.next();
			System.out.println("Value :" + value);
		}

		data = new Object[][] { { list } };

		// return new Object[][] {{list}};

	}
}
