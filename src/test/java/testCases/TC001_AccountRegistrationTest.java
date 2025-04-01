package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass{

    @Test
    public void accountRegister() {
        HomePage hp = new HomePage(driver);
        hp.ClickMyAccount();
        hp.ClickRegister();

        AccountRegisterPage regPage = new AccountRegisterPage(driver);
        regPage.enterFirstName(randomString().toUpperCase());
        regPage.enterLastName(randomString().toUpperCase());
        regPage.enterEmail(randomString() + "@gmail.com");
        regPage.enterTelephone(randomNumber());

        String password = randomAlphaNumber();
        regPage.enterPassword(password);
        regPage.enterConfirmPassword(password);
        regPage.clickPolicyCheck();
        regPage.clickContinueButton();

        String comfrimMsg = regPage.getComfirmationMsg();
        Assert.assertEquals(comfrimMsg, "Your Account Has Been Created!");

    }
}
