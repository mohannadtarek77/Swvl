package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import utilities.AppiumServerJava;

public class TestBase {
	public  AndroidDriver<AndroidElement> driver;
	private AppiumServerJava appiumServer;
	@BeforeTest
	public void setupEnvironment() throws MalformedURLException {
		//Open Appium Server
		AppiumServerJava appiumServer = new AppiumServerJava();
		int port = 4723;
		if(!appiumServer.checkIfServerIsRunnning(port)) {
			appiumServer.startServer();
		} else {
			System.out.println("Appium Server already running on Port - " + port);
		}



		//Set Desired Capabilities for appium
		File appFolder = new File("Apps");
		File appSrc = new File(appFolder,"Swvl Bus Booking App_v5.7.1_apkpure.com.apk");//

		
		//Select your desired capabilities that will be send to APPIUM server 
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability(capabilityName, value);
		//I need Zoza_Emulator to open so i can work on it
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Zoza");
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability("appPackage", "io.swvl.customer");
		cap.setCapability("appActivity","io.swvl.customer.features.LaunchScreenActivity");
		//Select what APP you need to invoke
		cap.setCapability(MobileCapabilityType.APP,appSrc.getAbsolutePath());	
		//Send connection to APPIUM server 
		//AndroidDriver takes two parameters 
		//Connection to APPIUM server/This part local host "http://127.0.0.1" is common for every windows device
		//4723 is port number
		//Desired Capabilities
		
		driver = new AndroidDriver<> (new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
//	@AfterTest
//	public void tearDownEnvironment() {
//		appiumServer.stopServer();
//	}
	
}
