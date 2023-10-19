package StepDefTDD;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginTDD {
	WebDriver driver;
	String baseUrl = "https://www.saucedemo.com/";
	
	@Given("user is on saucedemo login page")
	public void user_is_on_saucemode_login_page(){
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(false);
		
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@When("I input (.*) as username$")
	public void user_input_tdd_selenium_as_username(String username){
		driver.findElement(By.id("user-name")).sendKeys(username);
	}
	
	@And("I input (.*) as password$")
	public void user_input_tdd_selenium_as_password(String pass){
		driver.findElement(By.id("password")).sendKeys(pass);
	}
	
	@And("user login button")
	public void user_click_submit(){
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	@Then ("I verify login result")
	public void user_verify_success_login_result(){
		driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
	}
}
