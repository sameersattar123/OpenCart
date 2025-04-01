package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//span[normalize-space()='My Account']") WebElement linkMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']") WebElement linkRegister;

    @FindBy(xpath = "//a[normalize-space()='Login']") WebElement linkLogin;

    // Actions
    public void ClickMyAccount() {
        linkMyAccount.click();
    }

    public void ClickRegister() {
        linkRegister.click();
    }

    public void ClickLogin() {
        linkLogin.click();
    }
}
