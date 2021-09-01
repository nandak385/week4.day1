package week4.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunWithFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src=\"default.html\"]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[@id=\"Click\"]")).click();
		
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@src=\"page.html\"]"));
		driver.switchTo().frame(frame2);
		
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@src=\"nested.html\"]"));
		driver.switchTo().frame(frame3);
		
		driver.findElement(By.xpath("//button[@id=\"Click1\"]")).click();
		
		driver.switchTo().defaultContent();
		
        List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The frames in the page is : "+ findElements.size());
	}

}
