package wrapper;

import org.openqa.selenium.NoSuchElementException;

public class LinkedInWrappers extends WrapperMethods{
	
	public boolean loginLinkedIn(String userName, String passWord){
		
		try {
			enterById("login-email",userName);
			enterById("login-password",passWord);
			clickByName("submit");
			return true;
		} 
		catch (NoSuchElementException e) 
		{
			System.out.println("Element for User Login is not found");
			e.printStackTrace();
			return false;
		}
	}
	
	public String Split(String data, char spliter) {
		String afterSplit = "";
		for (char c : data.toCharArray()) {
			if (c != spliter) {
				afterSplit = afterSplit + c;
			}
			
		}		
		return afterSplit;
	}
}
