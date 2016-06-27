package rnd;

import org.testng.annotations.Test;

public class Priority 
{
	@Test(priority=0)
	public void Priority7() 
	{
	System.err.println("Priority 7");	
	}
	
	@Test(priority=4)
	public void Priority4() 
	{
	System.err.println("Priority 4");	
	}
	
	@Test(priority=5)
	public void Priority5() 
	{
	System.err.println("Priority 5");	
	}
	
	@Test(priority=2)
	public void Priority2() 
	{
	System.err.println("Priority 2");	
	}
	
	@Test(priority=3)
	public void Priority3() 
	{
	System.err.println("Priority 3");	
	}
	
	@Test(priority=1)	
	public void Priority1() 
	{
	System.err.println("Priority 1");	
	}
	
}
