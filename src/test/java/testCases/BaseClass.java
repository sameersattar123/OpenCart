package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    @BeforeClass
    public void setUp() {
        logger = LogManager.getLogger(this.getClass());
        
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

      public String randomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }

    public String randomNumber() {
        String generatedNumbers = RandomStringUtils.randomNumeric(5);
        return generatedNumbers;
    }

    public String randomAlphaNumber() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        String generatedNumbers = RandomStringUtils.randomNumeric(3);
        return (generatedString + "@" + generatedNumbers);
    }
}
