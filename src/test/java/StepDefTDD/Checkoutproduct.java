package StepDefTDD;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

public class Checkoutproduct {
	WebDriver driver;
	String baseUrl = "https://www.saucedemo.com/";
	
	@Given("user already login saucedemo site")
	public void user_is_on_inventory_page(){
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
		
	@When("user click add to cart button on one product or more")
	public void user_click_add_to_cart(){
		driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
	}
	
	@And ("user click cart icon on the top right side")
	public void user_clickcarticon(){
		driver.findElement(By.className("shopping_cart_badge")).click();
	}
	
	@And ("user check shopping list product & click checkoutbutton")
	public void usercheckout(){
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
	}
	@And ("user fill firstname in biodata form")
	public void user_fillfirstname(){
		driver.findElement(By.id("first-name")).sendKeys("Ranti");
	}
	@And ("user fill lastname in biodata form")
	public void user_fillastname(){
		driver.findElement(By.id("last-name")).sendKeys("Ramadhiana");
	}
	@And ("user fill postal code in biodata form")
	public void user_fillpostalcode(){
		driver.findElement(By.id("postal-code")).sendKeys("23051");
	}
	
	@And ("user click continue button")
	public void user_clickcontinuebtn(){
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	
	@And ("user click the finish button")
	public void user_clickfinishbtn(){
		driver.findElement(By.xpath("//button[contains(text(),'Finish')]")).click();
	}
	
	@Then("user successfully purchased the product & user can back to inventory page")
	public void usersuccesspurchased() throws IOException{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/src/test/java/suksescheckout.png"));
		driver.close();
	}
	
	@And("user fill empty firstname in biodata form")
	public void user_fill_empty_firstname_in_biodata_form() {
		driver.findElement(By.id("first-name")).sendKeys("");
	}

	@And("user fill empty lastname in biodata form")
	public void user_fill_empty_lastname_in_biodata_form() {
		driver.findElement(By.id("last-name")).sendKeys("");
	}

	@And("user fill empty postal code in biodata form")
	public void user_fill_empty_postal_code_in_biodata_form() {
		driver.findElement(By.id("postal-code")).sendKeys("");
	}

	@Then("user failed to buy product & get warning message error")
	public void user_failed_to_buy_product_get_warning_message_error() throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/src/test/java/gagalcheckout.png"));
		driver.close();
	}
}
