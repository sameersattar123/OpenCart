package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test
    public void accountRegister() {
        logger.info("Starting TC001_AccountRegistrationTest ....");
        try {
            HomePage hp = new HomePage(driver);
            logger.info("Clicked on Account");
            hp.ClickMyAccount();
            logger.info("Clicked on Register");
            hp.ClickRegister();

            logger.info("Write User Details");
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

            logger.info("Validating Expected Message");
            String comfrimMsg = regPage.getComfirmationMsg();
            if (comfrimMsg.equals("Your Account Has Been Created!")) {
                Assert.assertTrue(true);
            } else {
                logger.error("Test Failed ....");
                logger.debug("Debug ...");
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("finished TC001_AccountRegistrationTest ....");

    }
}
