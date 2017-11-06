package UserRegistrationForm;


import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.support.ui.Select;

import com.test.general.GenerateData;

public class CreateUser {

	WebDriver driver;
	GenerateData genData;
	

	@Test
	public void testRegistrationForm() {
		
		Logger logger=Logger.getLogger("testRegistrationForm");
		PropertyConfigurator.configure("Log4j.properties");
		
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\kapil.verma\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		genData = new GenerateData();
		driver.get("http://adjiva.com/qa-test/");
		logger.info("Browser Opened");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[1]/div/div/input")).sendKeys(genData.generateRandomAlphaNumeric(30));
		 logger.info("First name Entered");
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[2]/div/div/input")).sendKeys(genData.generateRandomString(20));
		 logger.info("Last name Entered");
		WebElement Office = driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[3]/div/div/select"));
		Select a = new Select(Office);
		a.selectByVisibleText("Engineering");
		 logger.info("Department / Office selected");
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[4]/div/div/input")).sendKeys(genData.generateRandomAlphaNumeric(30));
		 logger.info("User name entered");
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[5]/div/div/input")).sendKeys("test1234");
		 logger.info("Password entered");
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[6]/div/div/input")).sendKeys("test1234");
		 logger.info("Confirm Password entered");
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[7]/div/div/input")).sendKeys(genData.generateEmail(30));
		 logger.info("Email Address entered");
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[8]/div/div/input")).sendKeys(genData.generateRandomNumber(10));
		 logger.info("Phone number entered");
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[10]/div/button")).click();
		 logger.info("Submit button clicked");
		Assert.assertEquals("Mismatch in the text", "Thanks", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/legend/center/h2/b")).getText());
		driver.get("http://adjiva.com/qa-test/");
		logger.info("Browser Opened");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[10]/div/button")).click();
		 logger.info("Submit button clicked");
		Assert.assertEquals("Mismatch in the text", "Please enter your First Name", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[1]/div/small[2]")).getText());
		 logger.info("First name field missing text message");
		Assert.assertEquals("Mismatch in the text", "Please enter your Last Name", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[2]/div/small[2]")).getText());
		 logger.info("Last name field missing text message");
		Assert.assertEquals("Mismatch in the text", "Please enter your Username", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[4]/div/small[2]")).getText());
		 logger.info("username field missing text message");
		Assert.assertEquals("Mismatch in the text", "Please enter your Password", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[5]/div/small[2]")).getText());
		 logger.info("Password field missing text message");
		Assert.assertEquals("Mismatch in the text", "Please confirm your Password", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[6]/div/small[2]")).getText());
		 logger.info("Confirm Password field missing text message");
		Assert.assertEquals("Mismatch in the text", "Please enter your Email Address", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[7]/div/small[1]")).getText());
		 logger.info("Email address  field missing text message");
		driver.get("http://adjiva.com/qa-test/");
		logger.info("Browser Opened");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[1]/div/div/input")).sendKeys("a");
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[2]/div/div/input")).sendKeys("b");
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[4]/div/div/input")).sendKeys(genData.generateRandomAlphaNumeric(5));
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[5]/div/div/input")).sendKeys("test12");
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[6]/div/div/input")).sendKeys("test12");
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[7]/div/div/input")).sendKeys(genData.generateInvalidEmail(10));
		driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[8]/div/div/input")).sendKeys("abcdjl");
		Assert.assertEquals("Mismatch in the text", "This value is not valid", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[1]/div/small[1]")).getText());
		logger.info("First name validation text message");
		Assert.assertEquals("Mismatch in the text", "This value is not valid", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[2]/div/small[1]")).getText());
		logger.info("Last name validation text message");
		Assert.assertEquals("Mismatch in the text", "This value is not valid", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[4]/div/small[1]")).getText());
		logger.info("user name validation text message");
		Assert.assertEquals("Mismatch in the text", "This value is not valid", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[5]/div/small[1]")).getText());
		logger.info("Password validation text message");
		Assert.assertEquals("Mismatch in the text", "This value is not valid", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[6]/div/small[1]")).getText());
		logger.info("Confirm password validation text message");
		Assert.assertEquals("Mismatch in the text", "This value is not valid", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[7]/div/small[2]")).getText());
		logger.info("Email validation text message");
		Assert.assertEquals("Mismatch in the text", "This value is not valid", driver.findElement(By.xpath(".//*[@id='contact_form']/fieldset/div[8]/div/small")).getText());
		logger.info("Contact Number validation text message");
	
		driver.close();
		}
}


