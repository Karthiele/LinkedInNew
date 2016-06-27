	//package wrapper;
	
	package groups;
	
	import java.util.List;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;
	
	import wrapper.LinkedInWrappers;
	import wrapper.LinkedInWrappersKarthi;
	
	public class TestCase_06 extends LinkedInWrappersKarthi {
	
		@Test(invocationCount = 2,invocationTimeOut=120000)
		public void linkIn() throws InterruptedException {
	
			String mailTo;
			String getMailTo;
			String getSummary;
			mailTo = "Karthikeyan S";
	
			// Launch Chrome
			invokeApp("Chrome", "https://www.linkedin.com/");
	
			// Login Linkedin
			loginLinkedInKarthi("karthielex@gmail.com", "sjb@1986");
			Thread.sleep(5000);
			
			//Click the Mail icon
			clickByXPath("//*[@id='account-nav']/ul/li[1]/a");
			Thread.sleep(5000);
	
			//Click the Compose icon
			clickById("compose-button");
	
			//Enter the Person name 
			enterById("pillbox-input", mailTo);
			Thread.sleep(5000);
	
			//Send the Enter key
			sendEndterKeyByID("pillbox-input");
	
			//Compose the Mail message
			enterById("compose-message", "Karthi");
	
			//Uncheck the Press to enter to send checkbox
			clickById("enter-to-send-checkbox");
	
			//Click the Send button
			clickByClassName("message-submit");
			Thread.sleep(5000);
			
			//Get the Text from Left side All messages area.
			getMailTo = getTextByXPath("//*[@id='thread-list']/li[1]/div[1]/a/div[2]/div/h4");		
			Thread.sleep(500);
			
			//Get the message from Left side All messages area.
			getSummary = getTextByXPath("//*[@id='thread-list']/li[1]/div[1]/a/div[2]/p");		
					
			//If Left side contains MailTo and Summary not contains New Message, Message Sent Successfully	
			if (mailTo.equalsIgnoreCase(getMailTo) && !getSummary.contains("New message")) {
				System.out.println("Mail Sent Successfully");
			}
		}
	}
