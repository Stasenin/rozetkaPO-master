package Test_this.Test_this;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static Test_this.DriverWrapper.getDriver;

public class RegistrationPopup {
    private final By _email = By.xpath("//*[@formcontrolname=\"username\"]");
    private final By _login = By.cssSelector("[formcontrolname=\"name\"]");
    private final By _password = By.cssSelector("[formcontrolname=\"password\"]");
    private final By _submit = By.cssSelector(".button_color_green.auth-modal__submit");


    public void setLogin(String name) throws IOException {
        getDriver().findElement(this._login).sendKeys(name, Keys.TAB);
    }

    public void setPassword(String password) throws IOException {
        getDriver().findElement(this._password).sendKeys(password, Keys.TAB);
    }

    public void setEmail(String email) throws IOException {
        getDriver().findElement(this._email).sendKeys(email, Keys.TAB);
    }

    public void clickSubmit() throws IOException {
        getDriver().findElement(this._submit).click();
    }


    public void assertErrorMsgIsPresent(String fieldName, String expectedErrText) {
        String actualMsg = this.getErrorMsg(fieldName);
        try {
            Assert.assertEquals("Error msg in field - " + fieldName + " - does not math the following: " + expectedErrText, expectedErrText, actualMsg);
        } catch (NoSuchElementException err) {
            System.out.println("error msg is not displayed");
            err.printStackTrace();
        }
    }

    private String getErrorMsg(String fieldName) {
        String errMsgSelector = "";
        switch (fieldName) {
            case "login":
                errMsgSelector = ".js-name .validation-message p";
                break;
            case "password":
                errMsgSelector = ".js-new_password p";
                break;
            case "email":
                errMsgSelector = ".js-contact .validation-message p";
                break;
            default:
                throw new Error("no match -  wrong fieldName specified");
        }

        String actualText = "";
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 15);
            wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector(errMsgSelector))));
            actualText = getDriver().findElement(By.cssSelector(errMsgSelector)).getAttribute("innerText");
        } catch (NoSuchElementException GGsee) {
            System.out.println("error msg is not displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return actualText;
    }

}
