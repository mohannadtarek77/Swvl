package pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
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
        WebElement clickOnTrip;// maybe wrong selector still not exectued

        @FindBy(id = "io.swvl.customer:id/next_btn")
        WebElement nextButton;

        @FindBy(id = "io.swvl.customer:id/book_btn")
        WebElement bookButton;

        @FindBy(id = "io.swvl.customer:id/done_btn")
        WebElement doneButton;

    WebElement getDropOff= driver.findElement(By.id("io.swvl.customer:id/places_rv")).findElement(By.className("android.view.ViewGroup")) ;

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
        public void bookingRide(String pickup,String dropoff){
            clickWhereTo();
            EnterPickupPoint(pickup);
            EnterDropOff(dropoff);
            chooseDropOff();
            chooseTrip();
            clickNextButton();
            clickBookButton();
            clickDoneButton();
        }
    }
