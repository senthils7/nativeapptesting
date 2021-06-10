package nativeapp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capability {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		
//		File fs = new File("/Users/senthils/Library/Android/sdk/platform-tools/ApiDemos-debug.apk");
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		//few capabilities which are common for web, native, hybrid
		//common things
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Senthil Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//optional for android but mandatory for iOS
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		
		//for iOS
//		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		//Only for Android
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.android.apis");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.appium.android.apis.ApiDemos");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		return driver;
			}

}
