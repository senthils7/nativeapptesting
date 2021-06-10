package nativeapp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class Nativetest extends Capability {
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(enabled = false)
	public void testcase1() throws InterruptedException
	{
		System.out.println("New app is working in the emulator");
		
		driver.findElementByAccessibilityId("Preference").click();
		//driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		
		driver.findElementByAccessibilityId("3. Preference dependencies").click();
		
		driver.findElement(By.id("android:id/checkbox")).click();
		//driver.findElementByClassName("android.widget.CheckBox").click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();		
		//driver.findElement(By.linkText("WiFi settings")).click();
		
		//Enter data
		driver.findElement(By.id("android:id/edit")).sendKeys("Senthil");
		
		//Open & hide the keyboard
		driver.hideKeyboard();
		
		//click on button with class name & index
		WebElement cancelBtn = driver.findElements(By.className("android.widget.Button")).get(0);
		
		cancelBtn.click();
		
		//Navigate back
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
	}
	
	@Test(enabled = false)
	public void testcase2() {
		
		  driver.findElementByAccessibilityId("Views").click();
		
		  //tap and click are same. Tap is a gesture in mobile testing
		  
		  TouchAction t = new TouchAction(driver);
		  
		  
		  WebElement EL = driver.findElementByAccessibilityId("Expandable Lists");
		  t.tap(tapOptions().withElement(element(EL))).perform();
		  
		  driver.findElementByAccessibilityId("1. Custom Adapter").click();
		  
		  //Long press on People name to get 2 buttons in alert view
		  WebElement PN = driver.findElement(By.xpath("//*[@text='People Names']"));
		  //One more way for the above people name
		  //driver.findElementsByAndroidUIAutomator("text(\"People Names\")");
		  t.longPress(longPressOptions().withElement(element(PN)).withDuration(ofSeconds(3))).release().perform();
		  
		 //get the text of the element in console
		 // WebElement secondName = driver.findElement(By.xpath("//*[@text='Sample action']"));
		  String Sample= driver.findElements(By.className("android.widget.TextView")).get(1).getText();
	    	 System.out.println(Sample);

	}
	
	
	@Test(enabled=false)
	public void testcase3() {
		  driver.findElementByAccessibilityId("Views").click();
		  
		  //scroll to bottom of the page
		  // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
		  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));").click();
		  String Sample= driver.findElements(By.className("android.widget.TextView")).get(1).getText();
	    	 System.out.println(Sample);
	}
	
	//work with notifications
	@Test(enabled=false)
	public void testcase4() {
		driver.openNotifications();
		
		//AccessibiltyID is same as content description
		driver.findElementByAccessibilityId("Battery Saver").click();
	}
	
	//swipe actions
	@Test(enabled=false)
	public void testcase5() throws InterruptedException {
		  driver.findElementByAccessibilityId("Views").click();
		  driver.findElementByAccessibilityId("Date Widgets").click();
		  driver.findElementByAccessibilityId("2. Inline").click();
		  driver.findElementByAccessibilityId("9").click();
		  
		  Thread.sleep(3000);
		  //Swipe date from 15 to 45
		  WebElement btn1 = driver.findElementByAccessibilityId("15");
		  WebElement btn2 = driver.findElementByAccessibilityId("45");

		  TouchAction t = new TouchAction(driver);
		  t.longPress(longPressOptions().withElement(element(btn1)).withDuration(ofSeconds(3))).moveTo(element(btn2)).release().perform();


	}
	
	//dragand drop
	@Test(enabled=true)
	public void testcase6() throws InterruptedException {
		  driver.findElementByAccessibilityId("Views").click();
		  driver.findElementByAccessibilityId("Drag and Drop").click();			

		  WebElement btn1 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		  WebElement btn2 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));

		  TouchAction t = new TouchAction(driver);
		  t.longPress(longPressOptions().withElement(element(btn1))).moveTo(element(btn2)).release().perform();


	}

}
