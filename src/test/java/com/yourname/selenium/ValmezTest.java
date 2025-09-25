package com.yourname.selenium;

import com.yourname.selenium.pages.ValmezHome;
import com.yourname.selenium.pages.ValmezMesto;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class ValmezTest {

    WebDriver driver;
    String username;
    String password;
    String baseUrl;
    String headerTitle;
    String menuLinkMesto;

    @Before
    public void setUp() {
        String url = "https://www.valasskemezirici.cz";

        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriverManager.chromedriver().setup();

        // Create a new instance of Chrome driver
        driver = new FirefoxDriver();
        // driver = new ChromeDriver();
        // driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Dotenv dotenv = Dotenv.load();
        Dotenv dotenv = Dotenv.configure().load(); 

        baseUrl = dotenv.get("BASE_URL");
        headerTitle = "Město a úřad";
        menuLinkMesto = "Vedení města";
    }

    @Test
    public void testLoginWorkflow() {
        ValmezHome valmezHome = new ValmezHome(driver);
        ValmezMesto valmezMesto = new ValmezMesto(driver);

        assertTrue("Login form should be visible", valmezHome.checkLogo());
        valmezHome.clickMenuLink(headerTitle);

        valmezMesto.checkHeader(headerTitle);
        valmezMesto.clickMenuLink(menuLinkMesto);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
