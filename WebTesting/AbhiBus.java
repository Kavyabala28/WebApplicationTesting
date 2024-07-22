package WebTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AbhiBus {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		// Launch the url
		driver.get("https://www.abhibus.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(3000);

		// sending 'chennai' to from box
		WebElement fromBox = driver.findElement(By.xpath("//input[@placeholder='From Station']"));
		fromBox.sendKeys("Chennai");
        
		// clicking chennai
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();

		// sending 'bangalore' to To box
		WebElement toBox = driver.findElement(By.xpath("//input[@placeholder='To Station']"));
		toBox.sendKeys("Bangalore");
        
		// clicking bangalore
		WebElement clickBangalore = driver.findElement(By.xpath("//div[text()='Bangalore']"));
		clickBangalore.click();
		
		// clicking tomorrow
		WebElement date = driver.findElement(By.xpath("(//button[@class='btn active text tertiary md active button'])[2]"));
		date.click();

		// click search button
		WebElement searchBtn = driver.findElement(By.xpath("//a[text()='Search']"));
		searchBtn.click();

		// Getting first bus title
		WebElement firstBusTitle = driver.findElement(By.xpath("//h5[@class='title']"));
		String busTitle = firstBusTitle.getText();
        System.out.println("First Bus Title : " + busTitle);

		// clicking 'Sleeper' 
		driver.findElement(
				By.xpath("//a[@class='btn  outlined tertiary sm inactive button']/span[text()='Sleeper']"))
				.click();

		// getting the text of 'no.of.seats'  
		WebElement noOfSeats = driver.findElement(By.xpath("//div[@class='text-grey']"));

		String seatsNum = noOfSeats.getText();

		System.out.println("Available seat : " + seatsNum);

		// clicking show seats
		driver.findElement(By.xpath("//button[@class='btn bus-info-btn filled primary sm inactive button']")).click();

		WebElement seat2 = driver.findElement(By.xpath("//table[@id='seat-layout-details']//button"));
		seat2.click();

		// Select boarding point
		WebElement boardingList = driver.findElement(By.xpath("(//div[@class='label']/p)[1]"));
		boardingList.click();

		// Select dropping point
		WebElement droppingList = driver.findElement(By.xpath("(//div[@class='label']/p)[1]"));
		droppingList.click();

		// Printing the 'Seat No'
		WebElement seatText = driver.findElement(By.xpath("(//div[@class='selected-seat col auto']//div)[2]"));
		String seatNum = seatText.getText();

		System.out.println("Seat name  : " + seatNum);

		//Printing the 'Price'
		WebElement seatFare = driver.findElement(By.xpath("(//div[@class='seat-fare col auto']//div)[2]"));
		String BaseFare = seatFare.getText();

		System.out.println("Base Fare  : " + BaseFare);

		// Printing the 'Title'
		String title = driver.getTitle();
		System.out.println("Title : " + title);

		// Closing the page
		driver.close();
	}

}
