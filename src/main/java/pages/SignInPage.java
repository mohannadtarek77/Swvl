package pages;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignInPage extends PageBase{
    public SignInPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    WebElement allowPermission;

    @FindBy(id = "io.swvl.customer:id/continue_btn")
    WebElement continueTutorial;

    @FindBy(xpath ="//android.widget.TextView[@resource-id ='io.swvl.customer:id/facebook_tv']")
    WebElement FaceBook;

    @FindBy (xpath ="//android.widget.EditText[@resource-id='m_login_email']")
    WebElement enterEmail;

    @FindBy (xpath ="//android.widget.EditText[@resource-id='m_login_password']")
    WebElement enterPassword;

    @FindBy(className = "android.widget.Button")
    WebElement logInButton;

    @FindBy(xpath ="//android.widget.Button[@resource-id='u_0_1']")
    WebElement continueButton;

    public void enterEmail(String email) {
       clickButton(enterEmail);
        enterEmail.sendKeys(email);
    }
    public void enterPassword(String password){
        clickButton(enterPassword);
        enterPassword.sendKeys(password);
    }

    public  void clickAllowPermission(){
        clickButton(allowPermission);
    }
    public void clickContinueTutorial(){
        clickButton(continueTutorial);
    }
    public PhoneNumber fakeMobileNumber(){
        Faker fake =new Faker ();
          PhoneNumber number= fake.phoneNumber();
          return number;
    }
    public void clickFB (){
        clickButton(FaceBook);
    }

    public void clickLogInButton() {
        clickButton(logInButton);
    }
    public  void clickContinueButton(){
        clickButton(continueButton);
    }

    public BookARidePage logInFacebook(String email, String password) {
        clickAllowPermission();
        for (int i = 0; i < 3; i++) {
           clickContinueTutorial();
        }
        clickFB();
        enterEmail(email);
        enterPassword(password);
        clickLogInButton();
        clickContinueButton();

        return new BookARidePage(driver);
    }
}

