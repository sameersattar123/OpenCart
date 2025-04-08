package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({ "os", "browser" })
    public void setUp(String os, String br) throws IOException {
        logger = LogManager.getLogger(this.getClass());
        FileReader fr = new FileReader("./src//test//resources//config.properities");
        p = new Properties();
        p.load(fr);
        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid Browser Name...");
                return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("AppURL1")); // reading url from property file
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
