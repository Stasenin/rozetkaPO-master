package Test_this;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class RozetkaTest {
//    WebDriver driver;
    //LoginField loginField ;
    DriverWrapper getDdriver;
    MainPage mainPage;
    RegistrattionPage registrationPage;  
    //email emailField;
    //PasswordField passwordField;
    //pushSubmit pushSubmit;
    //AssertErrorMassage assertErrorMassage;


    @Before
    public void precondition(){
        /*System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();*/
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage = new MainPage();
        registrationPage = new RegistrattionPage(); 
        //emailField = new email(driver);
        //passwordField = new PasswordField(driver);
        //pushSubmit = new pushSubmit(driver);
        //assertErrorMassage = new AssertErrorMassage(driver);

    }

    @Test
    public void NegativeRegistrationTest() throws InterruptedException, IOException {
        mainPage.open();
        mainPage.openRegistration();
        registrationPage.login();
        registrationPage.password();
        registrationPage.email();
        registrationPage.submit();
        registrationPage.assertBGcolor();
        //   loginField.typeLogin();
       /* loginField.login();
       // passwordField.typePassword();
        passwordField.password();
       // emailField.typeWrongEmail();
        emailField.email();
        pushSubmit.submit();
        assertErrorMassage.assertBGcolor(); */
        System.out.println("Passed: Right Error massage and bg input color.");

    }
//
//   @After
//   public void poscondition(){
//       getDriver().quit();
//   }

}
