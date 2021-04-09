package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private WebDriver driver;
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(10000);
	String longusername = "JaghetererJaghetererJaghetererJaghetererJaghetererJaghetererJaghetererJaghetererJaghetererJaghetereri";
	
	
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
		public void i_have_entered_into_the_e_mail_text_field(String mail) {
			if(mail.equals("email")) {
				sendKeys(driver, By.name("email"), mail + randomInt + "@gmail.com");
			}else if(mail.equals("")) {
				
			}
		}


			@Given("I have also entered {string} into the username text field")
			public void i_have_also_entered_into_the_username_text_field(String usern) {
				if(usern.equals("username")) {
				sendKeys(driver, By.name("username"), usern);
				}else if(usern.equals("longusername")) {
					sendKeys(driver, By.name("username"), longusername);
				}
				else if(usern.equals("workingusername")) {
					sendKeys(driver, By.name("username"), usern + randomInt);
				}
			
			}
			

			@Given("I have also entered {string} into the password text field")
			public void i_have_also_entered_into_the_password_text_field(String passw) {
				sendKeys(driver, By.name("password"), passw);
			
			    
			}

				@When("I press sign up")
				public void i_press_sign_up() throws InterruptedException {
				   click(driver, By.id("create-account")); 
				   
				   Thread.sleep(3000);
				}



			@Then("I continue to {string} for verification")
			public void i_continue_to_for_verification(String veri) {
			  
				
				if (veri.equals("Check your email")) {
			  assertEquals(veri, driver.findElement(By.cssSelector(".\\!margin-bottom--lv3")).getText());
			}else if(veri.equals("Enter a value less than 100 characters long")) {
				assertEquals(veri, driver.findElement(By.className("invalid-error")).getText());
			}else if(veri.equals("Another user with this username already exists. Maybe it's your evil twin. Spooky.")) {
			    assertEquals(veri, driver.findElement(By.className("invalid-error")).getText());
			}else if(veri.equals("Please enter a value")) {
					assertEquals(veri, driver.findElement(By.className("invalid-error")).getText());	
				}
			}
			    
				

			@After
			public void teardown() {
				driver.quit();
			}


}
