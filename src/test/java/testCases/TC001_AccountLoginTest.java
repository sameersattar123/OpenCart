package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;

public class TC001_AccountLoginTest extends BaseClass {
    @Test
    public void login_Account(){
        HomePage hp = new HomePage(driver);
        hp.ClickMyAccount();
        hp.ClickLogin();

        AccountLoginPage logPage = new AccountLoginPage(driver);
        logPage.enterEmail("sameersattar@gmail.com");
        logPage.enterPassword("password123");
        logPage.clickLoginButton();
    }
}
