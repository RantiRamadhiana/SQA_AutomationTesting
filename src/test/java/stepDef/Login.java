package stepDef;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class Login {
	WebDriver driver;
	String baseUrl = "https://www.saucedemo.com/";
	
	@Given("user is on login page")
	public void user_is_on_saucemode_login_page1(){
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(false);
		
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@When("Input username")
	public void user_input_tdd_selenium_as_username1(){
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
	}
	
	@And("Input Password")
	public void user_input_tdd_selenium_as_password1(){
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	
	@And("user login button click")
	public void user_click_submit1(){
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	@Then ("user in on dashboard page")
	public void user_verify_success_login_result1(){	
		driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
	}
	
	@And("Input Invalid Password")
	public void inputInvalidPassword1(){
		driver.findElement(By.id("password")).sendKeys("12345");
	}
	
	@Then("user get error message")
	public void userGetErrorMessage1(){
		
	}
}
