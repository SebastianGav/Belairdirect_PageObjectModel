package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;

public class HomePageTests {
	
	WebDriver driver;
	HomePage hp;
	
	@BeforeSuite
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sebas\\Desktop\\Selenium Workspace\\Belairdirect_PageObjectModel\\src\\test\\resources\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void openApplication() {
		driver.get("https://www.belairdirect.com/?organization_source=TARGETMARKETWBSEcevei&mid=&gclid=CjwKCAiAxMLvBRBNEiwAKhr-nDcP1SmDxshm18EbKhYLbWngiVAbk3qrBgvIYQu8--8yR22aiXVgERoClNwQAvD_BwE");
	}
	
	@Test(priority=0)
	public void checkGetMyPriceButton() throws InterruptedException, IOException {
		Reporter.log("I'm inside the 1st Test");
		hp = new HomePage(driver);
		
		Reporter.log("I'm gonna get the text 'Retrieve my car quote'");
		String actual,expected;
		actual=hp.getTextRetrieveMyCarQuote();
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\sebas\\Desktop\\Selenium Workspace\\Belairdirect_PageObjectModel\\src\\test\\resources\\properties\\text.properties");
		prop.load(fis);
		expected=prop.getProperty("text", "It wasn't found the string value for key=text");
        SoftAssert sfa = new SoftAssert();
		sfa.assertEquals(actual, expected);
		//sfa.assertAll();
		
		Reporter.log("I'm gonna click 'Get My Price' button");
		hp.clickGetMyPrice();
		Thread.sleep(2000);
	
		Reporter.log("I'm gonna click 'Car' button");
		hp.clickCar();
		Thread.sleep(2000);
		
		Reporter.log("I'm gonna click 'Next' button");
		driver.findElement(By.xpath("//button[@class='bttn bttn--animated bttn--blue bttn--min-width-200 bttn--line-height-1']")).click();
	    Thread.sleep(2000);
	    
	    Reporter.log("I'm gonna click 'Skip' button");
		driver.findElement(By.xpath("//a[@class='form-link']")).click();
	    
		Reporter.log("I'm gonna select 'Car year'");
		Select selectCarYear = new Select(driver.findElement(By.xpath("//select[@id='select-year']")));
		selectCarYear.selectByValue("2017");
		
		Reporter.log("I'm gonna select 'Car make'");
		Select selectCarMake = new Select(driver.findElement(By.xpath("//select[@id='select-make']")));
		selectCarMake.selectByValue("VOLKSWAGEN");
		
		Reporter.log("I'm gonna select 'Car model'");
		Select selectCarModel = new Select(driver.findElement(By.xpath("//select[@id='select-model']")));
		selectCarModel.selectByValue("959900");
		
		Reporter.log("I'm gonna click 'Next' button");
		driver.findElement(By.xpath("//button[@id='btn_next']")).click();
		Thread.sleep(2000);
		
		Reporter.log("I'm gonna input 'daily km'");
		driver.findElement(By.xpath("//input[@id='car-driven-km']")).sendKeys("15");
		
		Reporter.log("I'm gonna select 'Annual km'");
		Select selectAnnualKM = new Select(driver.findElement(By.xpath("//select[contains(@id,'car-annual-km')]")));
		selectAnnualKM.selectByValue("15999");
		List<WebElement> list=selectAnnualKM.getOptions();
		System.out.println(list.get(1).getText());
		
		Reporter.log("I'm gonna click 'Next' button");
		driver.findElement(By.xpath("//button[@id='btn_next']")).click();
		
		
		sfa.assertAll();
	}
	
	//@Test(priority=1)
	//public void checkCarButton() throws InterruptedException {
		//Reporter.log("Sunt in the 2nd Test");
		//hp.clickGetMyPrice();
		//hp.clickHome();
		//driver.findElement(By.xpath("//button[@class='bttn bttn--animated bttn--blue bttn--min-width-200 bttn--line-height-1']")).click();
	//}

}
