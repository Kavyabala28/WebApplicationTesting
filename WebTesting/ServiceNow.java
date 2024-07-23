package WebTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNow {

public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		// Launch the url
		driver.get("https://dev210045.service-now.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// locate to "userName"
		WebElement uname = driver.findElement(By.xpath("//div[@class='login-form-field']/input"));
		uname.sendKeys("admin");
		
		// locate to "password"
		WebElement pass = driver.findElement(By.xpath("//div[@class='input-group password-group']/input"));
		pass.sendKeys("tdY0ES=5luW-");
		
		// Click "Login"
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Log in']"));
		loginBtn.click();
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(10);
		
		// choose "Service catalog"
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		
		// Switching to frame
		WebElement frame = shadow.findElementByXPath("//iframe[@name='gsft_main']");
		driver.switchTo().frame(frame);
		
		// clicking mobile
		WebElement mob = driver.findElement(By.xpath("(//td[@class='homepage_category_only_description_cell'])[8]/a"));
		mob.click();
		
		// clicking apple iphone 13 pro
		WebElement iphone = driver.findElement(By.xpath("(//a[@class='service_catalog'])[3]"));
		iphone.click();
		
		// select 'yes' for a lost or broken iPhone
		WebElement yesOption = driver.findElement(By.xpath("//span[@class='input-group-radio']/label"));
		yesOption.click();
		
		// Passing '99' in phone number
		WebElement phoneNum = driver.findElement(By.xpath("(//div[@class='col-xs-6  form-field input_controls sc-form-field '])[2]/input[2]"));
		phoneNum.sendKeys("99");
				
		// select 'Unlimited [add $4.00]' in dropdown
		WebElement dropdown = driver.findElement(By.xpath("(//div[@class='col-xs-6  form-field input_controls sc-form-field '])[3]/select"));
		dropdown.click();
		Select select = new Select(dropdown);
		
		// Select by using "selectByVisibleText" method
		select.selectByVisibleText("Unlimited [add $4.00]");
		
		// click 'SierraBlue' for color
		WebElement color = driver.findElement(By.xpath("//div[@class='sc-radio']//label[text()='Yes']"));
		color.click();
		
		// click '512 GB'
		WebElement gb = driver.findElement(By.xpath("//span[@class='input-group-radio']//label[text()='512 GB [add $300.00]']"));
		gb.click();
		
		// clicking order now button
		WebElement orderNowBtn = driver.findElement(By.xpath("//button[contains(text(),'Order Now')]"));
		orderNowBtn.click();
		
		// Printing request number
		String reqNo = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
		System.out.println("Request Number : "+reqNo);
		
		// close the browser
		driver.quit();
	}

}
