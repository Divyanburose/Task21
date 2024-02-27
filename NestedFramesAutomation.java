package task21;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesAutomation {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

//Launch browser
		WebDriver driver = new ChromeDriver();
//load url
		driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
//maximize window
		driver.manage().window().maximize();
//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//inspect top frame
//WebElement topframe = driver.findElement(By.xpath("//frame[@name=\"frame-top\"]"));
//driver.switchTo().frame(topframe);

		
		// Switch to the top frame
        WebElement topFrame = driver.findElement(By.cssSelector("frame[name='frame-top']"));
        driver.switchTo().frame(topFrame);

        // Verify that there are three frames on the page
        int frameCount = driver.findElements(By.cssSelector("frame")).size();
        if (frameCount == 3) {
            System.out.println("There are three frames on the page.");
        } else {
            System.out.println("There are not three frames on the page.");
        }

        // Switch to the left frame
        WebElement leftFrame = driver.findElement(By.cssSelector("frame[name='frame-left']"));
        driver.switchTo().frame(leftFrame);

        // Verify that the left frame has a text "LEFT"
        String leftFrameText = driver.findElement(By.tagName("body")).getText();
        if (leftFrameText.contains("LEFT")) {
            System.out.println("Text 'LEFT' found in the left frame.");
        } else {
            System.out.println("Text 'LEFT' not found in the left frame.");
        }

        // Switch back to the top frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame(topFrame);

        // Switch to the middle frame
        WebElement middleFrame = driver.findElement(By.cssSelector("frame[name='frame-middle']"));
        driver.switchTo().frame(middleFrame);

        // Verify that the middle frame has a text "MIDDLE"
        String middleFrameText = driver.findElement(By.tagName("body")).getText();
        if (middleFrameText.contains("MIDDLE")) {
            System.out.println("Text 'MIDDLE' found in the middle frame.");
        } else {
            System.out.println("Text 'MIDDLE' not found in the middle frame.");
        }

        // Switch back to the top frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame(topFrame);

        // Switch to the right frame
        WebElement rightFrame = driver.findElement(By.cssSelector("frame[name='frame-right']"));
        driver.switchTo().frame(rightFrame);

        // Verify that the right frame has a text "RIGHT"
        String rightFrameText = driver.findElement(By.tagName("body")).getText();
        if (rightFrameText.contains("RIGHT")) {
            System.out.println("Text 'RIGHT' found in the right frame.");
        } else {
            System.out.println("Text 'RIGHT' not found in the right frame.");
        }

        // Switch back to the top frame
        driver.switchTo().defaultContent();
        //driver.switchTo().frame(topFrame);

        // Switch to the bottom frame
        WebElement bottomFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        driver.switchTo().frame(bottomFrame);

        // Verify that the bottom frame has a text "BOTTOM"
        String bottomFrameText = driver.findElement(By.tagName("body")).getText();
        if (bottomFrameText.contains("BOTTOM")) {
            System.out.println("Text 'BOTTOM' found in the bottom frame.");
        } else {
            System.out.println("Text 'BOTTOM' not found in the bottom frame.");
        }
	
        //Switch back to the top frame
        driver.switchTo().defaultContent();

        // Verify that the page title is "frames"
        String pageTitle = driver.getTitle();
        if (pageTitle.equals("Frames")) {
            System.out.println("Page title is 'Frames'.");
        } else {
            System.out.println("Page title is not 'Frames'.");
        }
        // Close the browser
        driver.quit();
	
	}

}
