package RevisionSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownSeleniumWithoutSelectClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Desktop\\Excel\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		driver.navigate().to("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		
		List<WebElement> alloptions = driver.findElements(By.xpath("//select[@id='first']//option"));
		
		for(WebElement ele:alloptions) {
			
			if(ele.getText().equalsIgnoreCase("Google")) {
				       
				ele.click();
				
				break;
			}
			
		}
	}

}
