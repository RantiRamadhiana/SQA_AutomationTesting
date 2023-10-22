package StepDefTDD;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Addproduct {
	WebDriver driver;
	String baseUrl = "https://www.saucedemo.com/";
	
	@Given("user already login saucedemo site home")
	public void user_is_on_inventory_pagehome(){
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(false);
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@value='Login']")).click();		
	}
		
	@When("user click one product detail")
	public void user_click_detail_product(){
		driver.findElement(By.xpath("//a[@id='item_0_img_link']")).click();
	}
	
	@And ("user click add to cart")
	public void user_click_addone_product(){
		driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
	}
	
	@Then("user success add product")
	public void usersuccesspurchased() throws IOException{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/src/test/java/successaddproduct.png"));
		driver.close();
	}
}
