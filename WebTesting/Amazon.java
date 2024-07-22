package WebTesting;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) throws IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		// Maximize the window
		driver.manage().window().maximize();

		// Launch the URL
		driver.get("https://www.amazon.in/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Locating to 'Mobile'
		WebElement mobile = driver.findElement(By.linkText("Mobiles"));
		mobile.click();

		// locating to 'Smartphones & Basic Mobiles'
		WebElement smartMobiles = driver.findElement(By.xpath("//span[text()='Smartphones & Basic Mobiles']"));
		smartMobiles.click();

		// Locate to '128GB'
		WebElement gb = driver.findElement(By.xpath("//li[@class='a-spacing-micro']//a/span[text()='128 GB']"));
		gb.click();

		// Locate to 'See more' link
		WebElement seeMoreLink = driver
				.findElement(By.xpath("//a[contains(@class,'a-expander-header')]/span[text()='See more']"));
		seeMoreLink.click();

		// Locating to 'POCO' Model Mobile
		WebElement poco = driver.findElement(By.xpath("//span[text()='POCO']"));
		poco.click();

		// Printing the first filtered mobile details
		WebElement mobileDetails = driver
				.findElement(By.xpath("//div[contains(@class,'a-section a-spacing-small puis')]"));
		String mobDetails = mobileDetails.getText();
		System.out.println("Details of 1st filtered mobile : " + mobDetails);

		// Clicking the 1st filtered mobile
		WebElement firstMob = driver.findElement(
				By.xpath("//a[contains(@class,'a-link-normal s-underline-text s-underline-link-text s-link-style')]"));
		firstMob.click();

		// redirect to another page
		Set<String> windowHandle1 = driver.getWindowHandles();
		List<String> windowSwitch = new ArrayList<String>(windowHandle1);
		driver.switchTo().window(windowSwitch.get(1));

		// Print the title of the webPage
		String pageTitle = driver.getTitle();
		System.out.println("The title of current page : " + pageTitle);

		// Taking screenshot of the page
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./Snap/AmazonMob.png");
		FileUtils.copyFile(src, des);

		// Scroll down and Click 'Add to cart' button
		WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
		driver.executeScript("arguments[0].click()", addToCart);
		// closing all page
		driver.quit();

	}

}
