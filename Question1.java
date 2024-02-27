package task21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Launch browser
WebDriver driver = new ChromeDriver();
//load url
driver.get("https://the-internet.herokuapp.com/iframe");
//maximize the window
driver.manage().window().maximize();
//implicit wait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//switch to frame
driver.switchTo().frame(0);
//Inspect content and clear the content
driver.findElement(By.xpath("//p[text()='Your content goes here.']")).clear();
//Display new content
driver.findElement(By.xpath("//body[@id=\"tinymce\"]")).sendKeys("Hello People");
//close the window
//driver.close();

	}

}
