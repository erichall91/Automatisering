package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	String name = "JaghetererJaghetererJaghetererJaghetererJaghetererJaghetererJaghetererJaghetererJaghetererJaghetereri";
	
	
	@Before
	public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");

	    driver = new ChromeDriver();                 
	    driver.manage().window().maximize();
	    driver.get("https://www.grolls.se/helags-t-shirt--svart1100099.html");
	
	

		@Given("I have entered {string} into the e-mail text field")
		public void i_have_entered_into_the_e_mail_text_field(String string) {
		   System.out.println(string); 
		}


			@Given("I have also entered {string} into the username text field")
			public void i_have_also_entered_into_the_username_text_field(String string) {
			    
			}


			@Given("I have also entered {string} into the password text field")
			public void i_have_also_entered_into_the_password_text_field(String string) {
			    
			}
			@Then("I continue to {string} for verification")
			public void i_continue_to_for_verification(String string) {
			    
			}


}
