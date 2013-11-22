package airgames.airg.DrunkenTreasures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;





public class DrunkenTreasuresTest extends BaseTest {
	
	private static final String BufferedWriter = null;

	Random generator = new Random();
	
	long energy;
	Long tempTime=(long) 0;
	long tempEnergy;
	long totEnergy=(long)0;
	long gameEnergy=(long)0;
	Boolean above100 = false;
	long betNum;
	int totGameNum = 0;
	long totScore = 0;
	
	@Test
	public void LaunchGame() throws InterruptedException{
		jsErrorFinder();
		 Thread.sleep(2000);
		 
//		 
				driver.findElement(By.id("garowslots")).click();	
				Thread.sleep(1000);
//				driver.findElement(By.className("txt")).click();	
		System.out.println("herere");
		driver.get("http://test.airgames.com/gc/sm/static/slotd.html");
		
		
		Thread.sleep(10000);

	}
	
	
	@Test (dependsOnMethods = "LaunchGame")
	public void StartGame() throws InterruptedException {
		jsErrorFinder();
		
		driver.findElement(By.xpath("//div[@class='inlineFlexBoxH gc_ibutton']")).click();
		Thread.sleep(1000);
		if (isPresent())
		{
			closeTip();
		}
	}
	
	@Test (dependsOnMethods = "StartGame")
	public void Spin() throws InterruptedException {
		
		logFile("**   "+getEnergy()+"         **");
		logFile("**   "+getScore()+"         **");
		logFile("**   "+totScore+"           **");
		logFile("****game start *****");
		
		jsErrorFinder();
		
		if (isPresent())
		{
			closeTip();
		}
		
		addBet();
		addBet();
		
		long time = (long) ((JavascriptExecutor)(driver)).executeScript("return gc.nextRefill");
		long nexttime = time - System.currentTimeMillis();
		tempTime=nexttime;
		
		while (!isGameEnd())
		{
			if (isPresent())
			{
				closeTip();
			}
			
			
			
			
			 // game start
			energy= getEnergy();
			//logFile("jgeignerigf");
			
		//	System.out.println(energy + " test4");
			tempEnergy = energy;
					
					
			//System.out.print(".");
			
			if (energy >2){	
			//	System.out.println(isPresent());
	
				Thread.sleep(1000);
				
				if (isPresent())
				{
					closeTip();
				}
				
			
				Thread.sleep(1000);
				int randomNum = generator.nextInt(4);
			//	System.out.println(randomNum);
//				if (randomNum >2)
//				{
//			//		System.out.println("add bet");
//					addBet();
//				}
//				
			//	System.out.println(energy + " test0");
				
				
				if (isPresent())
				{
					closeTip();
				}
				
				fullSpin((int)getBet());
				
				 energy = energy - getBet();
				 betNum = getBet();
				spin();
				totEnergy = totEnergy+3;
				
				 
				Thread.sleep(1000);
				if (isPresent())
				{
					closeTip();
				}
			
				
		
				List  winning = getWins();
				
				int s = 0;
				int mutil = 0;	
				int refill = 0;
		
					
					 while(  s < winning.size()) {
				     //     System.out.println(winning.get(s));
				          if (       winning.get(s).toString().contains("ship"))
				          {
				        	  mutil++;
				          }
				          if ( winning.get(s).toString().contains("energy"))
				          {
				        	  refill++;
				          }
				       	s++;
					 }
					 
						 if (       winning.toString().contains("ship"))
					        {
					        	logFile("Bonus Game");
					    //    	System.out.println("base mutilpler is: " + mutil);
					        	Thread.sleep(6000);
					        	//driver.findElement(By.xpath("//span[contains(text(),'DIG WHAT YOU DARE!')]")).click();
					        	playBonus();
					        	
					        
					        		
								       
					        }
						 if (       winning.toString().contains("energy"))
						 {
							 energy= energy+100*refill;
							 logFile(100*refill + " energy refill");
							 Thread.sleep(5000);
							 above100 = true;
							 totEnergy = totEnergy +100;
						 }
						 
						 int randomNum2 = generator.nextInt(48);
							//System.out.println (randomNum2);
							if (randomNum2>46)
							{
							// clickEnergy();
							}
					 }
					 else
						 {
						 Thread.sleep(1000);
						if ( driver.findElements(By.xpath("//img[@src='/gc/sm/static/images/slots/MenuTop.png']")).size()>0)
						{
							driver.findElement(By.xpath("//img[@src='/gc/sm/static/images/slots/BackButton.png']")).click();
						 time = (long) ((JavascriptExecutor)(driver)).executeScript("return gc.nextRefill");
						  nexttime = time - System.currentTimeMillis() + 2000;
						// System.out.println ("hjweiogweginwoignwe"+nexttime);
						 Thread.sleep(nexttime);
						 totEnergy = totEnergy+5;
					//	 logFile ("current bet is "+getBet());
						
						 }
						 
						}
						 }
			
			
			if (energy<100)
			{
				
				 time = (long) ((JavascriptExecutor)(driver)).executeScript("return gc.nextRefill");
						 nexttime = time - System.currentTimeMillis();
//				System.out.println(nexttime);
//				System.out.println(tempTime);
				if (tempTime <nexttime)
				{
//					System.out.println("add 5 energy");
//					System.out.println(energy + "test1");
					if ((energy+5)<=100)
					{	energy=energy+5;}
					else
					{//	System.out.println(energy + "test2");
						energy=100;}
					
				}
					tempTime=nexttime;
			}
			
//			System.out.println(energy + "test3");
//			System.out.println ("Before:" + tempEnergy + " bet#: " + betNum + " After: " + getEnergy());
 //			System.out.println ("========"+ above100 +"==========");
			
		//	Assert.assertEquals(energy, getEnergy());
			
			List error = (List)((JavascriptExecutor) driver).executeScript("return window.collectedErrors");
			
			if (error.size()>0)
			{
				System.out.println ("error!!!!");
				System.out.println (error+"/n");
			}
			Assert.assertTrue(error.size()==0);
			 
			//System.out.println (((JavascriptExecutor) driver).executeScript("return window.collectedErrors")); 
			
			
			 }

		
			
			
	
	@Test
	private long getEnergy()
	{
		return (long) ((JavascriptExecutor)driver).executeScript("return gc.energy");
		
	}
	
	@Test
	private long getScore()
	{
		return (long) ((JavascriptExecutor)driver).executeScript("return gc.score.val");
		
	}
	
	@Test
	private List getWins()
	{
		return (List) ((JavascriptExecutor)driver).executeScript("return gc.winnings");
	}
	
	@Test
	private void spin() throws InterruptedException
	{
		//((JavascriptExecutor)driver).executeScript("gc.addBet()");
		((JavascriptExecutor)driver).executeScript("gc.spin()");
		Thread.sleep(1100);
	}
	
	@Test
	private long getBet()
	{
		return (long) ((JavascriptExecutor)driver).executeScript("return gc.bet");
	}
	
	@Test
	private void addBet()
	{
		((JavascriptExecutor)driver).executeScript("gc.addBet()");
		
	}
	
	@Test
	private boolean isPresent()
	{
		return  driver.findElements(By.xpath("//img[@src='/gc/sm/static/images/slots/Tip.png']")).size()>0;
	}
	
	@Test
	private void closeTip() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='gc_ibutton inlineFlexBoxH']")).click();
	}
	
	@Test
	private void playBonus() throws InterruptedException
	{
		logFile (getScore()+" ");
		int [] array = {7,4,1,5,11,6,14,12,13,10,9,0,15,3,8,2};
		  for (int n=0;n<16;n++)
		    {

	        	if (isPresent())
				{
	        		closeTip();
				}
				
		    	
		    	if( ((JavascriptExecutor)driver).executeScript("return gc.bgame").toString().equals("true"))
		    	{
		    		driver.findElement(By.className("exit")).click();
		    	}
		    	
		    	
		    	String path = "//*[@id='xs']/canvas[@_index="+array[n]+"]";
		       
			        	
		        	driver.findElement(By.xpath( path)).click();
		            Thread.sleep(1000);
		        	
		        	
		            if( ((JavascriptExecutor)driver).executeScript("return gc.bgame").toString().contains("=3"))
		            {
		            		Thread.sleep(7000);
		            		break;
		            }
		          
		          
		         		         
		           
		    }
		  	
		  if (isGameEnd())
			{
			  totScore = totScore+getScore();
			  totGameNum++;
			  logFile("********************");
				logFile("*****Game # "+ totGameNum + "ends*****");
				
				
				if (above100)
				{
					logFile("** start energy:  "+getEnergy()+"         **");
					logFile("** end points:  "+getScore()+"         **");
					logFile("** total points:  "+totScore+"           **");
					logFile("***spent energy: " +totEnergy + "  *********");
					logFile("********************");
				}
				else
				{
					logFile("**   "+getEnergy()+"         **");
					logFile("**   "+getScore()+"          **");
					logFile("**   "+totScore+"           **");
					logFile("***spent energy: " +totEnergy + "  *********");
					logFile("********************");
				}
				
				continueGame();
			}
			else
			{
			//	viewMap();
			}
		  
		  logFile (getScore()+" ");    			        
	}
	
	@Test
	private boolean isGameEnd()
	{
		
		return driver.findElements(By.xpath("//img[@src='/gc/sm/static/images/slots/CompleteGraphic.png']")).size()>0;
	}
	
	@Test
	private void continueGame() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='gc_ibutton inlineFlexBoxH']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='/gc/sm/static/images/slots/BackButton.png']")).click();
	}
	
	@Test
	private void viewMap() throws InterruptedException
	{
		driver.findElement(By.id("buttonMap")).click();
		if (isPresent())
		{
			closeTip();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='/gc/sm/static/images/slots/MapBack.png']")).click();
	}
	
	
	
	
	
	
	@Test
	private void clickEnergy() throws InterruptedException
	{
		driver.findElement(By.id("bottle")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='price'][4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='gc_ibutton flexBoxH'][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("exit")).click();
	}
	
	
	@Test
	private void jsErrorFinder()
	{

		
		String script = "window.collectedErrors = [];"
				  + "window.onerror = function(errorMessage, url, line) { "
				  + "window.collectedErrors.push(errorMessage);"
				  +"window.collectedErrors.push(url);"
				  +"window.collectedErrors.push(line);"
				  + "}";
		
		
				((JavascriptExecutor) driver).executeScript(script);
					
	}
	
	
	private void logFile (String s)
	{
		try{
			String filename = "stat/"+key;
			BufferedWriter out = new BufferedWriter(new FileWriter(filename,true));
			out.write(s);
			 out.newLine();
			 out.close();
			 System.out.println(key + " : " + s);
		}catch (IOException e){
			System.out.println(e);
			System.out.println("fail to write the file");
		}
	}
	
	private void fullSpin(int b)
	{
		 switch (b) {
		 	case 1: addBet(); addBet();break;
		 	case 2: addBet(); break;
		 	case 0: addBet();addBet();addBet();break;
		 	default: break;
		 }
}
	
	}

