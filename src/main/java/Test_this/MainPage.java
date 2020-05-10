package Test_this;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static Test_this.DriverWrapper.getDriver;

public class MainPage {

//    private WebDriver driver;


//    public MainPage(WebDriver driver) {
//        this.driver = driver;
//    }

    private final By SignInLink = By.cssSelector("a.header-topline__user-link");
    private final By RegistrationLink = By.cssSelector("a.auth-modal__register-link");

    void open() throws IOException {
        getDriver().get("http://rozetka.com.ua");
    }

    Test_this.Test_this.RegistrationPopup openRegistration() throws IOException {
        getDriver().findElement(SignInLink).click();
        getDriver().switchTo().activeElement();
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(RegistrationLink));
        getDriver().findElement(RegistrationLink).click();

        return new Test_this.Test_this.RegistrationPopup();
    }
}