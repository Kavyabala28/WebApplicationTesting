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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tatacliq {
	
	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.tatacliq.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions actions = new Actions(driver);
		
		// To handle 'Avail coupon'
		/*
		 * WebElement availcoupon =
		 * driver.findElement(By.xpath("//iframe[@id='wiz-iframe-intent']"));
		 * 
		 * driver.switchTo().frame(availcoupon);
		 * 
		 * driver.findElement(By.xpath("//span[@class='CT_InterstitialClose']")).click()
		 * ;
		 * 
		 * driver.switchTo().defaultContent();
		 */
		
        // locate to brand
		WebElement brand = driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryAndBrand'])[2]"));

		actions.moveToElement(brand).perform();

		// locate to watches & accessories
		WebElement watchAcc = driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryDetailsValue'])[4]"));

		actions.moveToElement(watchAcc).perform();

		// click 1st featured brands
		WebElement brands = driver.findElement(By.xpath("(//div[@class='DesktopHeader__brandsDetails'])[1]"));
		brands.click();

		// sort
		WebElement sort = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select s = new Select(sort);
		s.selectByVisibleText("New Arrivals");
		Thread.sleep(2000);

		// select men
		WebElement men = driver.findElement(By.xpath("//div[@class='CheckBox__base']/following::div[text()='Men']"));
		men.click();

		Thread.sleep(2000);

		// Printing all price
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']"));

		Thread.sleep(3000);

		for (WebElement price : prices) {
			String allPrice = price.getText();
			String allPrices = allPrice.replaceAll("[^0-9]", "");
			System.out.println("The price are : " + allPrices);
		}

		String text2 = prices.get(1).getText();
		String text3 = text2.replaceAll("[^0-9]", "");

		Thread.sleep(2000);

		// clicking second resulting watch
		WebElement clicking = driver.findElement(By.xpath("(//div[@class='ProductDescription__headerText'])[2]"));
		driver.executeScript("arguments[0].click();", clicking);

		Set<String> window = driver.getWindowHandles();

		List<String> windows = new ArrayList<String>(window);

		// switching to next window
		driver.switchTo().window(windows.get(1));

		// getting price of second watch
		String text = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText();
		String replacedText = text.replaceAll("[^0-9]", "");

		System.out.println("Price of the Mobile : " + replacedText);

		// To take Screenshot

		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./Snap/Viewcard.png");
		FileUtils.copyFile(src, des);

		// comparing the price
		if (replacedText.equals(text3)) {
			System.out.println("Yes, the price is available in the list");
		} else {
			System.out.println("No, the price is not available");
		}

		// clicking add to bag
		WebElement addToBag = driver.findElement(By.xpath("(//div[@class='Button__base'])[3]/span[text()='ADD TO BAG']"));
		addToBag.click();

		String text4 = driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']/span")).getText();
		System.out.println("No.of.Watches available in 'Add to Bag' : " + text4);
		
		// closing child browser
		driver.close();
		
		// closing parent browser
		driver.switchTo().window(windows.get(0));
		driver.close();
	}

}
