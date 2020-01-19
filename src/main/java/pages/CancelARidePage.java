package pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class CancelARidePage  extends PageBase {
    CancelARidePage Cancel;
    public CancelARidePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(id = "cio.swvl.customer:id/menu_iv")
    WebElement menu;

    @FindBy(className = "//android.widget.CheckedTextView[@text=‘BUE’]")
    WebElement yourTrips;

    @FindBy(id = "io.swvl.customer:id/ride_card_view")
    WebElement bookedTrip;

    @FindBy(id = "io.swvl.customer:id/cancel_booking_iv")
    WebElement cancelTrip;

    @FindBy(id = " io.swvl.customer:id/confirm_btn")
    WebElement confirmCancel;

    @FindBy(id = "")
    WebElement slideBar; // selector still

    public void clickMenu() {
        clickButton(menu);
    }
    public void clickYourTrips() {
        clickButton(yourTrips);
    }
    public void clickOnBookedTrip(){
        clickButton(bookedTrip);
    }
    public void slideTheBarUp(){
        clickButton(slideBar);
    }
    public void clickCancelButton(){
        clickButton(cancelTrip);
    }
    public void clickConfirmCancel(){
        clickButton(confirmCancel);
    }
    public void cancelRide() {
        Cancel.clickMenu();
        Cancel.clickYourTrips();
        Cancel.clickOnBookedTrip();
        Cancel.slideTheBarUp();
        Cancel.clickCancelButton();
        Cancel.clickConfirmCancel();
    }
}

