package tests;

import pages.CancelARidePage;
import org.testng.annotations.Test;
import pages.SignInPage;

public class CancelARide extends TestBase{
String email;
String password;

    @Test
    public void CancelARide() {
        SignInPage  Sign = new SignInPage(driver);
        Sign.logInFacebook(email,password);
        CancelARidePage Cancel = new CancelARidePage(driver);
        Cancel.cancelRide();
    }
}
