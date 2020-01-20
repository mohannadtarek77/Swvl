package pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

    public class BookARidePage extends PageBase{

        public BookARidePage(AndroidDriver<AndroidElement> driver) {
            super(driver);
        }
        @FindBy(id = "io.swvl.customer:id/where_to_coach_marks")
        WebElement whereTo;

        @FindBy(id = "io.swvl.customer:id/pickup_et")
        WebElement pickUpField;

        @FindBy(id = "io.swvl.customer:id/dropoff_et")
        WebElement dropOffField;

        @FindBy(id = "io.swvl.customer:id/trip_item_without_date_layout")
        WebElement clickOnTrip;

        @FindBy(id = "io.swvl.customer:id/next_btn")
        WebElement nextButton;

        @FindBy(id = "io.swvl.customer:id/book_btn")
        WebElement bookButton;

        @FindBy(id = "io.swvl.customer:id/done_btn")
        WebElement doneButton;

        @FindBy(id = "io.swvl.customer:id/desc_tv")
        WebElement getPickUp;

        @FindBy(className = "android.view.ViewGroup")
        WebElement getDropOff;

        @FindBy(id = "io.swvl.customer:id/desc_tv")
            WebElement clickDropOff;


        public void EnterPickupPoint(String pickup) {
            clickButton(pickUpField);
            pickUpField.sendKeys(pickup);
        }
        public void EnterDropOff(String dropoff){
            clickButton(dropOffField);
            dropOffField.sendKeys(dropoff);
        }

         public void chooseTrip(){
            clickButton(clickOnTrip);
}
        public void clickOnDropOff(){
            clickButton(clickDropOff);
        }
        public  void clickNextButton(){
            clickButton(nextButton);
        }
        public  void clickBookButton() {
            clickButton(bookButton);
        }
        public  void clickDoneButton() {
            clickButton(doneButton);
        }
        public void clickWhereTo(){
            clickButton(whereTo);
        }
        public void chooseDropOff(){
            clickButton(getDropOff);
        }
        public CancelARidePage bookingRide(String pickup, String dropoff) throws InterruptedException {

            clickWhereTo();
            EnterPickupPoint(pickup);
            Thread.sleep(3000l);
            EnterDropOff(dropoff);
            Thread.sleep(3000l);
            chooseDropOff();
            Thread.sleep(3000l);
            clickOnDropOff();
            chooseTrip();
            clickNextButton();
            clickBookButton();
            clickDoneButton();
            return new CancelARidePage(driver);
        }
    }
