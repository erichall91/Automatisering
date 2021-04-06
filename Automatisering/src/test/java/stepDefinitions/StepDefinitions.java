package stepDefinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private WebDriver driver;
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(10000);
	String name = "JaghetererJaghetererJaghetererJaghetererJaghetererJaghetererJaghetererJaghetererJaghetererJaghetereri";
	
	
	@Before
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();                 
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
        click(driver, By.cssSelector("button[id=onetrust-accept-btn-handler]"));
        
	}
        
        private void click(WebDriver driver, By by) {
    		(new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(by));
                        driver.findElement(by).click();
    				
        }
    				
    	private void sendKeys(WebDriver driver, By by, String keys) {
    		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(by));
    					driver.findElement(by).sendKeys(keys);
	    
	}
	
		@Given("I have entered {string} into the e-mail text field")
		public void i_have_entered_into_the_e_mail_text_field(String first) {
			if(first.equals("email")) {
				sendKeys(driver, By.name("email"), first + randomInt + "@gmail.com");
			}else if(first.equals("")) {
				
			}
		}


			@Given("I have also entered {string} into the username text field")
			public void i_have_also_entered_into_the_username_text_field(String second) {
				sendKeys(driver, By.name("username"), second);
			}


			@Given("I have also entered {string} into the password text field")
			public void i_have_also_entered_into_the_password_text_field(String third) {
				sendKeys(driver, By.name("password"), third);
			
			    
			}

				@When("I press sign up")
				public void i_press_sign_up() {
				   click(driver, By.id("create-account")); 
				}



			@Then("I continue to {string} for verification")
			public void i_continue_to_for_verification(String string) {
			  
			}


}
