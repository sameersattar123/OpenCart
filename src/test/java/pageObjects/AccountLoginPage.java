package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage{
     // Constructor
    public AccountLoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//input[@id='input-email']") WebElement textEmail;

    @FindBy(xpath = "//input[@id='input-password']") WebElement textPassword;

    @FindBy(xpath = "//input[@value='Login']") WebElement btnLogin;

    // Actions
    public void enterEmail(String email) {
        textEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        textPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }
}
