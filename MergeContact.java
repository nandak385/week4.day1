package week4.day1;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id=\'password\']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class=\'decorativeSubmit\']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/')]")).click();
		driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Merge Contacts\"]")).click();
		driver.findElement(By.xpath("//table[@class=\"twoColumnForm\"]/tbody/tr[1]/td[2]/a/img")).click();
		
		Set<String> win = driver.getWindowHandles();
		ArrayList<String> windowList=new ArrayList<String>(win);
		WebDriver window = driver.switchTo().window(windowList.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		driver.switchTo().window(windowList.get(0));
		
		driver.findElement(By.xpath("//table[@class=\"twoColumnForm\"]/tbody/tr[2]/td[2]/a/img")).click();
		Set<String> windowSet2 = driver.getWindowHandles();
		ArrayList<String> windowList2=new ArrayList<String>(windowSet2);
		driver.switchTo().window(windowList2.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]//a")).click();
		driver.switchTo().window(windowList2.get(0));

		driver.findElement(By.xpath("//a[text()=\"Merge\"]")).click();

		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
	    String title = driver.getTitle();
	    if (title.contains("opentaps ")) {
	    	System.out.println("You are on the " + "View Contact | opentaps CRM " + "page" );
			
		}else {
	    	System.out.println("You are on the other page" );

		}
	    


		
		
	}

}
