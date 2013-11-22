package  airgames.airg.DrunkenTreasures;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	@Test
	public void LaunchGame() throws InterruptedException{
		 Thread.sleep(2000);
		 System.out.print("hahaha");
		//driver.findElement(By.id("snLandSky"));
		//driver.findElement(By.id("snLandBtn")).click();
		 driver.findElement(By.id("tabLogin")).click();
		 Thread.sleep(2000);
	}
	
	@Test (dependsOnMethods = "LaunchGame")
	public void Login() throws InterruptedException{
//		driver.findElement(By.id("snEmailInput")).sendKeys(key);
//		driver.findElement(By.id("snEmailBtn")).click();
//		Thread.sleep(500);
//		driver.findElement(By.id("ppMessage")).getText().equals("Please provide a valid email.");
//		driver.findElement(By.className("circleBtn")).click();
//		
//		driver.findElement(By.id("snEmailInput")).clear();
//		Thread.sleep(500);
		//driver.findElement(By.id("snEmailInput")).click();
		//Thread.sleep(500);
		driver.findElement(By.id("snEmailInput")).sendKeys("qq1@qq1.com");
		Thread.sleep(500);
		driver.findElement(By.id("snEmailBtn")).click();
		Thread.sleep(500);
		
//		driver.findElement(By.id("snPassInput")).sendKeys("adgjm");
//		
//		driver.findElement(By.id("snPassBtn")).click();
//		Thread.sleep(500);
//		driver.findElement(By.id("ppMessage")).getText().equals("Email or password is incorrect");
//		Thread.sleep(500);
//		driver.findElement(By.id("ppMessage")).click();
//		
//		Thread.sleep(500);
//		driver.findElement(By.id("snPassInput")).clear();
		driver.findElement(By.id("snPassInput")).sendKeys("1234");
		driver.findElement(By.id("snPassBtn")).click();	
		Thread.sleep(1000);
	}
//	
	@Test (dependsOnMethods = "Login")
	public void clickGameList() throws InterruptedException{
		driver.findElement(By.id("tabGames")).click();	
		Thread.sleep(500);
		driver.findElement(By.id("tabFriends")).click();
		Thread.sleep(500);
		driver.findElement(By.id("tabProfile")).click();
		Thread.sleep(500);
		driver.findElement(By.id("tabGames")).click();	
		Thread.sleep(500);
	}
	
}
