package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {
    // Constructor
    public AccountRegisterPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//input[@id='input-firstname']") WebElement textFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']") WebElement textLastName;

    @FindBy(xpath = "//input[@id='input-email']") WebElement textEmail;

    @FindBy(xpath = "//input[@id='input-telephone']") WebElement textTelephone;

    @FindBy(xpath = "//input[@id='input-password']") WebElement textPassword;

    @FindBy(xpath = "//input[@id='input-confirm']") WebElement textComfirmPassword;

    @FindBy(xpath = "//input[@name='agree']") WebElement checkPolicy;

    @FindBy(xpath = "//input[@value='Continue']") WebElement continueBtn;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")  WebElement msgComfirmation;

    // Actions
    public void enterFirstName(String firstName) {
        textFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        textLastName.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        textEmail.sendKeys(email);
    }

    public void enterTelephone(String telephone) {
        textTelephone.sendKeys(telephone);
    }

    public void enterPassword(String password) {
        textPassword.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        textComfirmPassword.sendKeys(password);
    }

    public void clickPolicyCheck() {
        checkPolicy.click();
    }

    public void clickContinueButton() {
        continueBtn.click();
    }

    public String getComfirmationMsg() {
        try {
            return (msgComfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());
        }
    }

}
