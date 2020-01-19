package tests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SignInPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SignIn extends TestBase {
    String email;
    String password;

    @BeforeTest
    public void getProps() {
        try (InputStream input = new FileInputStream("src/test/java/tests/data.properties")) {

            Properties prop = new Properties();
            prop.load(input);

            email = prop.getProperty("email");
            password =prop.getProperty("password");

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @Test
    public void SignInFacebook(){
        SignInPage Sign = new SignInPage(driver);
        Sign.logInFacebook(email, password);
    }

}
