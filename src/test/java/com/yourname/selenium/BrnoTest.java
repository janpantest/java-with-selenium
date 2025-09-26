package com.yourname.selenium;

import com.yourname.selenium.pages.BrnoPay;
import com.yourname.selenium.pages.BrnoResults;
import com.yourname.selenium.pages.BrnoHome;
import com.yourname.selenium.pages.BrnoNeed;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class BrnoTest {

    WebDriver driver;
    String username;
    String password;
    String baseUrl;
    String text;

    @Before
    public void setUp() {
        // String url = "https://www.brno.cz/w/mistni-poplatek-za-komunalni-odpad-v-brne";
        String url = "https://www.brno.cz/";

        WebDriverManager.chromedriver().setup();

        // Create a new instance of Chrome driver
        driver = new FirefoxDriver();
        // driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        text = "platba odpadu";
    }

    @Test
    public void testLoginWorkflow() {
        BrnoHome brnoHome = new BrnoHome(driver);
        BrnoPay brnoPay = new BrnoPay(driver);
        BrnoResults brnoResults = new BrnoResults(driver);
        BrnoNeed brnoNeed = new BrnoNeed(driver);

        assertTrue("Logo in place", brnoHome.checkLogo());
        brnoHome.searchInfo(text);
        assertTrue("Page is OK", brnoResults.checkPage(" Vyhledávání"));
        brnoResults.clickLink("Potřebuji zaplatit za odpad");

        assertTrue("Page is ok", brnoNeed.checkLogo("Potřebuji zaplatit za odpad"));
        brnoNeed.clickLink();

        brnoPay.checkLogo("Místní poplatek za komunální odpad v Brně v roce 2025");
        brnoPay.getInfo();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
