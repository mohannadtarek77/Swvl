package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BookARidePage;
import pages.CancelARidePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CancelARide extends TestBase {
    String email;
    String password;
    String pickUp;
    String dropOff;
    @BeforeTest
    public void getProps() {
        try (InputStream input = new FileInputStream("src/test/java/tests/data.properties")) {

            Properties prop = new Properties();
            prop.load(input);

            email = prop.getProperty("email");
            password =prop.getProperty("password");
            pickUp = prop.getProperty("pickUp");
            dropOff =prop.getProperty("dropOff");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @Test
    public void cancelARide() throws InterruptedException {
        BookARidePage book = new BookARidePage(driver);
        book.bookingRide(pickUp,dropOff);
        CancelARidePage cancel = new CancelARidePage(driver);
        cancel.cancelRide();
    }

}
