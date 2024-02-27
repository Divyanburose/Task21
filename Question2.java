package task21;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Launch browser
				WebDriver driver = new ChromeDriver();
		//load url
				driver.navigate().to("https://the-internet.herokuapp.com/windows");
		//maximize window
				driver.manage().window().maximize();
		//implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
				// Inspect the "Click Here" button to open a new window
		        WebElement clickHereButton = driver.findElement(By.xpath("//a[text()='Click Here']"));
		        clickHereButton.click();

		        // Get the handles of all windows
		        Set<String> windowHandles = driver.getWindowHandles();

		        // Switch to the newly opened window
		        for (String handle : windowHandles) {
		            driver.switchTo().window(handle);
		        }

		        // Verify that the text "New Window" is present on the page
		        String newWindowTitle = driver.getTitle();
		        if (newWindowTitle.contains("New Window")) {
		            System.out.println("Text 'New Window' found on the page.");
		        } else {
		            System.out.println("Text 'New Window' not found on the page.");
		        }

		        // Close the new window
		        driver.close();

		        // Switch back to the original window
		        driver.switchTo().window((String) windowHandles.toArray()[0]);

		        // Verify that the original window is active
		        String originalWindowTitle = driver.getTitle();
		        if (originalWindowTitle.contains("The Internet")) {
		            System.out.println("Switched back to the original window.");
		        } else {
		            System.out.println("Failed to switch back to the original window.");
		        }

		        // Close the browser
		        driver.quit();
			
	
	}

}
