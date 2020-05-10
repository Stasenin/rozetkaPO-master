package Test_this;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import static Test_this.DriverWrapper.getDriver;

public class RozetkaTest {
    //WebDriver driver;
    //LoginField loginField ;
    DriverWrapper getDdriver;
    private MainPage mainPage;
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
        //emailField = new email(driver);
        //passwordField = new PasswordField(driver);
        //pushSubmit = new pushSubmit(driver);
        //assertErrorMassage = new AssertErrorMassage(driver);

    }

    @Test
    public void NegativeRegistrationTest() throws  IOException {
        mainPage.open();
        Test_this.Test_this.RegistrationPopup registrationPopup = mainPage.openRegistration();
        registrationPopup.setLogin("some name");
        registrationPopup.setPassword("some pass");
        registrationPopup.setEmail("@423423(*&@gamile.notvalid");
        registrationPopup.clickSubmit();
        registrationPopup.assertErrorMsgIsPresent("login", "Введите свое имя на кириллице");
        registrationPopup.assertErrorMsgIsPresent("email", "Введите свою эл. почту");
        registrationPopup.assertErrorMsgIsPresent(
                "password",
                "Пароль должен быть не менее 6 символов, содержать цифры и латинские буквы, в том числе заглавные, и не должен совпадать с именем и эл. почтой"
        );
         /*
         loginField.typeLogin();
         loginField.login();
         passwordField.typePassword();
         passwordField.password();
         emailField.typeWrongEmail();
         emailField.email();
         pushSubmit.submit();
         assertErrorMassage.assertBGcolor();
         */
         System.out.println("Passed");
    }

   @After
   public void postcondition () throws IOException {
       getDriver().quit();
   }

}
