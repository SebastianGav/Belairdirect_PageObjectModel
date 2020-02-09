package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	By getMyPrice = By.xpath("//button[@class='bttn bttn--width-240 bttn--animated bttn--blue bttn--left-desktop']");
	By car = By.xpath("//div[@class='on qc']//button[@class='bttn-box bttn-box-car'][contains(text(),'Car')]");
	By home = By.xpath("//div[@class='on qc']//button[@class='bttn-box bttn-box-home'][contains(text(),'Home')]");
	By textRetriveMyCarQuote = By.xpath("//a[@class='desktop']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getTextRetrieveMyCarQuote() {
		String text;
		text=driver.findElement(textRetriveMyCarQuote).getText();
		return text;
	}
	
	public void clickGetMyPrice() {
		driver.findElement(getMyPrice).click();
	}
	
	public void clickCar() {
		driver.findElement(car).click();
	}
	
	public void clickHome() {
		driver.findElement(home).click();
	}

}
