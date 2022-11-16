package lesson12;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Automation_screenshot {

	public static void main(String[] args) throws IOException {
		

//		System.setProperty("webdriver.gecko.driver", "G:\\firefox driver\\geckodriver.exe");
		
//		WebDriver driver = new FirefoxDriver();
		
       System.setProperty("webdriver.edge.driver", "G:\\edge driver\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://127.0.0.1:5500/Qa-automation-7thmar/index.html");
		
//		Date currentDate = new Date();
		
//		String theActualDate = currentDate.toString().replace(":", "-");
		
//		System.out.println(currentDate);
		
		driver.manage().window().maximize();
		
//		TakesScreenshot src = ((TakesScreenshot)driver);
//		
//		File SrcFile = src.getScreenshotAs((OutputType.FILE));
//		
//		File Dest = new File (".\\my pictures/"+theActualDate+".png");
//		
//		FileUtils.copyFile (SrcFile,Dest);
		

		
		List<WebElement> theStudents = driver.findElements(By.tagName("option"));
		
		int theTotalNumberOfStudents = theStudents.size();
		
		System.out.println(theTotalNumberOfStudents+" "+"this is the orginal number");
		
//		..... i need to remove 1 items ....
		
		int howManyOfItems = 1;
		
		System.out.println(howManyOfItems+" "+"this is the number of removed");
		
		for (int i=0 ; i < howManyOfItems ; i++) {
			
			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
		}
		
		List<WebElement> theStudentsAfterRemove = driver.findElements(By.tagName("option"));
		
		int actualNumber = theStudentsAfterRemove.size();
		
		System.out.println(actualNumber+" "+"this is the new number after remove");
				
		int expectedNumber = theTotalNumberOfStudents - howManyOfItems;
		
		System.out.println(expectedNumber+" "+"this is the expected remaining number");
		
		Assert.assertEquals(actualNumber,expectedNumber);
		
//		..... i need to remove all items ....
		
//		List<WebElement> theStudents = driver.findElements(By.tagName("option"));
//		for (int i=0 ; i < theStudents.size() ; i++) {
			
//			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
//		}
		
		
	}

}
