package WebTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PvrCinemas {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		// Launch the url
		driver.get("https://www.pvrcinemas.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Search as "Chennai"
		WebElement searchForCity = driver.findElement(
				By.xpath("//input[@class='p-inputtext p-component p-autocomplete-input p-autocomplete-input']"));
		searchForCity.sendKeys("Chennai");

		// Select "Chennai" from the list
		WebElement chennaiList = driver.findElement(By.xpath("//li[text()='Chennai']"));
		chennaiList.click();

		// Choose "Cinema"
		WebElement cinemaOption = driver.findElement(By.xpath("//span[text()='Cinema']"));
		cinemaOption.click();

		// Click on "Select Cinema" box
		WebElement selectCinema = driver.findElement(By.xpath("//span[text()='Select Cinema']"));
		selectCinema.click();

		// select "PVR AEROHUB Chennai"
		Thread.sleep(2000);
		WebElement pvr = driver.findElement(By.xpath("//li/span[text()='PVR AEROHUB Chennai']"));
		pvr.click();

		// select Tomorrow's date
		Thread.sleep(3000);
		WebElement tmrDate = driver.findElement(By.xpath("(//li[@class='p-dropdown-item'])[2]"));
		tmrDate.click();

		// select movie
		Thread.sleep(2000);
		WebElement movieName = driver.findElement(By.xpath("(//li[@class='p-dropdown-item'])[1]"));
		movieName.click();

		// select timing
		Thread.sleep(2000);
		WebElement timing = driver.findElement(By.xpath("//li[@class='p-dropdown-item']"));
		timing.click();

		// Click "Book" button
		WebElement bookBtn = driver.findElement(By.xpath("//button[@class='p-button p-component sc-ikkyvV putEh bgColor filter-btn']"));
		bookBtn.click();

		// Click "Accept"
		WebElement accept = driver.findElement(By.xpath("//button[text()='Accept']"));
		accept.click();

		// select seat
		WebElement selectSeat = driver.findElement(By.xpath("//span[@class='seat-current-pvr']"));
		selectSeat.click();

		// Print the summary details
		WebElement summary = driver.findElement(By.xpath("//div[@class='summary-movies-content']"));
		String summary1 = summary.getText();
		System.out.println("Movie Summary : " + summary1);

		// Print the grand total 
		WebElement tot = driver.findElement(By.xpath("//div[@class='grand-prices']"));
		String grandTotal = tot.getText();
		System.out.println("Grand Total : " + grandTotal);

		// close the browser
		driver.close();

	}
}
