package RevisionSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Methods_In_Selenium {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Desktop\\Excel\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		driver.navigate().to("https://artoftesting.com/samplesiteforselenium");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,800)", "");

		WebElement maleRadioButton = driver.findElement(By.id("male"));

		if (maleRadioButton.isDisplayed()) {
			System.out.println("Test Case 1 of Male Radio button is passed");
			System.out.println("***********************************");
		} else {
			System.out.println("Test Case 1 of Male Radio button is Failed");
			System.out.println("***********************************");
		}

		if (maleRadioButton.isEnabled()) {
			maleRadioButton.click();
			System.out.println("Test Case 2 of Male Radio button is passed");
			System.out.println("***********************************");
		} else {
			System.out.println("Test Case 2 of Male Radio button is Failed");
			System.out.println("***********************************");
		}
		
		if (maleRadioButton.isSelected()) {
			
			System.out.println("Test Case 3 of Male Radio button is passed");
			System.out.println("***********************************");
		} else {
			
			System.out.println("Test Case 3 of Male Radio button is Failed");
			System.out.println("***********************************");
		}
		
		List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement checkbox:allCheckbox) {
			
			String checkboxText=checkbox.getAttribute("value");
			
			System.out.println("Checkbox Text As Follows:"+checkboxText);
			
			checkbox.click();
			
			if(checkbox.isSelected()) {
				System.out.println("Test Case 4 of Checkbox is passed");
				System.out.println("***********************************");
			}else {
				System.out.println("Test Case 4 of Checkbox is failed");
				System.out.println("***********************************");
			}
			
		}
		
		// Handling Alert In Selenium
		WebElement alertbox = driver.findElement(By.xpath("//button[text()='Generate Alert Box']"));
		
		alertbox.click();
		
		Alert alert = driver.switchTo().alert();
		
		String textOfAlert=alert.getText();
		
		System.out.println("Alert Text As Follows :"+textOfAlert);
		
		alert.dismiss();
		
		//Handling Dropdown In Selenium
		
		WebElement dropDownElement = driver.findElement(By.xpath("//select[@id='testingDropdown']"));
		
		Select s=new Select(dropDownElement);
		
		List<WebElement> alloptions = s.getOptions();
		
		for(WebElement dropdownOption: alloptions) {
			
			dropdownOption.click();
			
			Thread.sleep(1000);
			
			String dropdownOptionText=dropdownOption.getText();
			
			System.out.println("DropdownText As follows :"+dropdownOptionText);
			
		}
		
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,-250)", "");
		
		WebElement doubleClickOnalertbox = driver.findElement(By.xpath("//button[contains(text(),'Double-click to generate alert box')]"));
		
		Actions act=new Actions(driver);
		
		act.doubleClick(doubleClickOnalertbox).perform();
		
		driver.switchTo().alert();
		
		String textofalertdouble=alert.getText();
		
		System.out.println("Double Click Alert Text As Follows :"+textofalertdouble);
		
		alert.dismiss();
		
		js.executeScript("window.scrollBy(0,950)", "");
		
		WebElement draggableele = driver.findElement(By.id("myImage"));
		
		WebElement dropableele = driver.findElement(By.id("targetDiv"));
		
		act.dragAndDrop(draggableele, dropableele).build().perform();
		
		js.executeScript("window.scrollBy(0,-350)", "");
		
		WebElement confirmBox = driver.findElement(By.xpath("//button[text()='Generate Confirm Box']"));
		
		confirmBox.click();
		
        driver.switchTo().alert();
        
        String textofalertconfirm=alert.getText();
		
		System.out.println("Confirm Box Alert Text As Follows :"+textofalertconfirm);
		
		alert.accept();
		
		WebElement textofOk=driver.findElement(By.xpath("//p[@id='demo']"));
		
		System.out.println(textofOk.getText());
		
		if(textofOk.getText().equalsIgnoreCase("You pressed OK!")) {
			
			System.out.println("Test Case 5 is passed");
		}else {
			System.out.println("Test Case 5 is failed");
		}
		
		
	}

}
