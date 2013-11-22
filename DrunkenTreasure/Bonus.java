package airgames.airg.DrunkenTreasures;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Bonus {

	WebDriver driver = null;
	int turns = 0;
	int position = 1;
	Random generator = new Random();
	int array[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
	
	public Bonus( WebDriver w){
		this.driver = w;
		
		
	}
	
	public boolean isBomb() {
		
		return true;
	}
	
	public void quitBonus() {
		
		driver.findElement(By.xpath("//*[@id='done']/img")).click();
	}
	
	public int setTurns()
	{
		
		turns = generator.nextInt(16)+1;
		return turns;
	}

	public void randomPositionArray()
	{
		for (int i=array.length; i>1; i--){
			int j = generator.nextInt(i);
			int tmp = array[j];
			array[j] = array[i-1];
			array[i-1] = tmp;
		}
	}
	
	public void clickChest(int position)
	{
		String path = "//*[@id='xs']/canvas["+position+"]";
		driver.findElement(By.xpath(path)).click();
	}
	
	
}
