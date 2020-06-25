package frameWorkBuild;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.*;

import Utilities.BrowserUtilities;
import Utilities.ConfigurationReader;
import Utilities.Driver;

public class kayakTestCases {

	@BeforeMethod
	public void BeforeMethod() {

		/*
		 * //1) Open the Browser //2) Enter The URL "www.kayka.com" (edited)
		 * 
		 */
		Driver.getDriver().get(ConfigurationReader.getProperty("webSite"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void AfterMethod() {

		Driver.getDriver().close();

	}

	@Test
	public void BookFlight01() {
		// 3) Get * the Title of the page
		System.out.println("The title of the LandingPage is: " + Driver.getDriver().getTitle());
		// 4) Click Sign In —userName: SignIn Window will pop-up
		// ---------techcircleschool@gmail.com Password: freedom1 --------
		Driver.getDriver()
				.findElement(
						By.xpath("/html/body/div[1]/div[1]/header/div/div/div/div[3]/div/div[1]/button/div/div[2]/div"))
				.click();
		BrowserUtilities.waitFor(3);
		// 5) Enter User & Password and Click SignIN
		Driver.getDriver().findElement(By.xpath("(//input[@aria-label=\"Email Address\"])[1]"))
				.sendKeys(ConfigurationReader.getProperty("userName"));
		BrowserUtilities.waitFor(3);
		Driver.getDriver().findElement(By.xpath("(//input[@aria-label=\"Password\"])[1]"))
				.sendKeys(ConfigurationReader.getProperty("passWord"));
		Driver.getDriver().findElement(By.xpath("(//button[@aria-label=\"Sign in\"])[2]")).click();
		// 6)* Click Flight Tab
		BrowserUtilities.waitFor(3);
		Driver.getDriver().findElement(By.xpath("//a[@aria-label=\"Flights\"]")).click();
		// 7) select the city you want to go by using Three Key letter & Select return
		// city by sending Full name of the Airport —toCity: URC fromCity: Dulles Intl
		/// html/body/div[1]/div[1]/main/div[1]/div/div/div[1]/div/div/section[2]/div/div/div[2]/form[1]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/div/div[2]/button
		WebElement defaultFromCityXButton = Driver.getDriver().findElement(By.xpath(
				"/html/body/div[1]/div[1]/main/div[1]/div/div/div[1]/div/div/section[2]/div/div/div[2]/form[1]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/div/div[2]/button"));
		// 7) fromCity inputBox
		if (defaultFromCityXButton.isDisplayed()) {
			defaultFromCityXButton.click();
			BrowserUtilities.waitFor(3);
			Driver.getDriver().findElement(By.xpath("(//input[@aria-label=\"Flight origin input\"])[1]"))
					.sendKeys(ConfigurationReader.getProperty("fromCity"));
			Driver.getDriver().findElement(By.xpath("//li[@aria-label=\"Washington, DC - Dulles Intl - Airport\"]"))
					.click();
		} else {
			BrowserUtilities.waitFor(3);
			Driver.getDriver().findElement(By.xpath("(//input[@aria-label=\"Flight origin input\"])[1]"))
					.sendKeys(ConfigurationReader.getProperty("fromCity"));
			Driver.getDriver().findElement(By.xpath("//li[@aria-label=\"Washington, DC - Dulles Intl - Airport\"]"))
					.click();
		}
		// toCity inputBox
		Driver.getDriver().findElement(By.xpath("(//div[@aria-label=\"Flight destination input\"])[1]")).click();
		BrowserUtilities.waitFor(3);
		Driver.getDriver().findElement(By.xpath("(//input[@aria-label=\"Flight destination input\"])[1]"))
				.sendKeys(ConfigurationReader.getProperty("toCity"));
		Driver.getDriver().findElement(By.xpath("//li[@aria-label=\"Ürümqi, China - Urumqi - Airport\"]")).click();
		// 8) select number of Traveling people including Kids
		// 2 adults, 2 senior, 2 youth, 2 child, 2 lapInfant, 2 seatInfant
		Driver.getDriver().findElement(By.xpath(
				"/html/body/div[1]/div[1]/main/div[1]/div/div/div[1]/div/div/section[2]/div/div/div[1]/div[2]/div/button/div/div[1]/div/div"))
				.click();
		BrowserUtilities.waitFor(4);
		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("travelerAdult"))).click();
//		WebElement travelSenior = Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("travelerSenior")));
//		WebElement travelYouth = Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("travelerYouth")));
//		WebElement travelChild = Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("travelerChild")));
//		WebElement travelSeatInfant = Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("travelerSeatInfant")));
//		WebElement travelLapInfant = Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("travelerLapInfant")));
//		travelSenior.click();
//		travelSenior.click();
//		
//		travelYouth.click();
//		travelYouth.click();
//
//		travelChild.click();
//		travelChild.click();
//		
//		travelSeatInfant.click();
//		travelSeatInfant.click();
//
//		travelLapInfant.click();
		// 9) select departure/return dates
		// DATA: December 19, 2020 ------ January 5, 2021
		Driver.getDriver().findElement(By.xpath("(//div[@data-placeholder=\"Depart\"])[1]")).click();
		BrowserUtilities.waitFor(3);
		// depart date
		Driver.getDriver().findElement(By.xpath("(//div[@aria-label=\"Departure date input\"])[3]")).clear();
		Driver.getDriver().findElement(By.xpath("(//div[@aria-label=\"Departure date input\"])[3]"))
				.sendKeys(ConfigurationReader.getProperty("departureDate"));
		// return date
		Driver.getDriver().findElement(By.xpath("(//div[@aria-label=\"Return date input\"])[3]")).clear();
		Driver.getDriver().findElement(By.xpath("(//div[@aria-label=\"Return date input\"])[3]"))
				.sendKeys(ConfigurationReader.getProperty("returnDate"));

		// click Search
		Driver.getDriver().findElement(By.xpath("(//button[@aria-label=\"Search flights\"])[1]")).click();
		BrowserUtilities.waitFor(10);

		Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

		Iterator<String> iterator = allWindowHandles.iterator();

		String parentWindow = iterator.next();
		String childWindow = iterator.next();

		System.out.println(parentWindow);
		System.out.println(childWindow);

		Driver.getDriver().switchTo().window(childWindow);

//		for(String handle : allWindowHandles)
//		{
//		System.out.println("Window handle - > " + handle);
		BrowserUtilities.waitFor(10);
		Driver.getDriver().findElement(By.xpath("/html/body/div[80]/div[3]")).click();
//		
//		
//		}
//		if (Driver.getDriver().findElement(By.xpath("(//button[@aria-label=\"Close\"])[11]")).isDisplayed()) {
//			
//
//			Driver.getDriver().findElement(By.xpath("(//button[@aria-label=\"Close\"])[11]")).click();
//		} else {
//
//			// switch windows to newer tab
//			// //switch windows to newer tab
//			Set<String> Ids = Driver.getDriver().getWindowHandles();
//			Iterator<String> it = Ids.iterator();
//
//			String parentID = it.next();
//			String childID_1 = it.next();
//
//			Driver.getDriver().switchTo().window(childID_1);
//			System.out.println("This the title if WINDOW HANDLE SWITCHED OVER" + Driver.getDriver().getTitle());
//
//			Driver.getDriver().findElement(By.xpath("(//button[@aria-label=\"Close\"])[11]")).click();
//
//		}
//		BrowserUtilities.waitForClickablility(
//				Driver.getDriver().findElement(By.xpath("(//button[@aria-label=\"Close\"])[11]")), 10);
//		Driver.getDriver().findElement(By.xpath("(//button[@aria-label=\"Close\"])[11]")).click();
//		 * //9) Go to Next Page And select the Most expensive ticket(Business Class)
//		 * //10)Go to Next Page enter Passenger Info and click Book
//		 */

	}

}
