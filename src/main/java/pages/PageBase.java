package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PageBase {
    protected AndroidDriver<AndroidElement> driver;

    //Constructor
    public PageBase(AndroidDriver<AndroidElement>  driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickButton(WebElement element) {
        element.click();
    }

}


