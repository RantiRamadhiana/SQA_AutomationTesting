package StepDefTDD;

import java.util.ArrayList;
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

public class addtocart {
	WebDriver driver;
	String baseUrl = "https://www.saucedemo.com/";
	String baseUrlinv = "https://www.saucedemo.com/inventory.html";
	String baseUrlcart = "https://www.saucedemo.com/cart.html";
	String baseUrlcheckout1 = "https://www.saucedemo.com/checkout-step-one.html";
	String baseUrlcheckout2 = "https://www.saucedemo.com/checkout-step-two.html";
	String baseUrlcheckoutcomplete = "https://www.saucedemo.com/checkout-complete.html";
	
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
		//driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
	}
	
	@And ("user click cart icon on the top right side")
	public void user_clickcarticon(){
		//driver.findElement(By.xpath("//a[@class='shopping_cart_lin']")).click();
	}
	
	@And ("user check shopping list product & click checkoutbutton")
	public void usercheckout(){
		//driver.findElement(By.className("btn btn_action btn_medium checkout_button")).click();
	}
	@And ("user fill firstname in biodata form")
	public void user_fillfirstname(){
		//driver.findElement(By.id("first-name")).sendKeys("Ranti");
	}
	@And ("user fill lastname in biodata form")
	public void user_fillastname(){
		//driver.findElement(By.id("last-name")).sendKeys("Ramadhiana");
	}
	@And ("user fill postal code in biodata form")
	public void user_fillpostalcode(){
		//driver.findElement(By.id("postal-code")).sendKeys("23051");
	}
	
	@And ("user click continue button")
	public void user_clickcontinuebtn(){
		//driver.findElement(By.xpath("//input[@class,'submit-button btn btn_primary cart_button btn_action']")).click();
	}
	
	@And ("user click the finish button")
	public void user_clickfinishbtn(){
		//driver.findElement(By.xpath("//button[@class,'btn btn_action btn_medium cart_button']")).click();
	}
	
	@Then("user successfully purchased the product & user can back to inventory page")
	public void userGetErrorMessage1(){
		
	}
	
}
