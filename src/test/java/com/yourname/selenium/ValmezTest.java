package com.yourname.selenium;

import com.yourname.selenium.pages.ValmezHome;
import com.yourname.selenium.pages.ValmezMesto;
import com.yourname.selenium.pages.ValmezVedeni;

import io.github.bonigarcia.wdm.WebDriverManager;

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
    String townTitle;
    String headerTitle;
    String menuLinkMesto;

    @Before
    public void setUp() {
        String url = "https://www.valasskemezirici.cz";

        WebDriverManager.chromedriver().setup();

        // Create a new instance of Chrome driver
        driver = new FirefoxDriver();
        // driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        townTitle = "Valašské Meziříčí";
        headerTitle = "Město a úřad";
        menuLinkMesto = "Vedení města";
    }

    @Test
    public void testLoginWorkflow() {
        ValmezHome valmezHome = new ValmezHome(driver);
        ValmezMesto valmezMesto = new ValmezMesto(driver);
        ValmezVedeni valmezVedeni = new ValmezVedeni(driver);

        assertTrue("Login form should be visible", valmezHome.checkLogo());
        valmezHome.checkTownTitle(townTitle);
        valmezHome.clickMenuLink(headerTitle);

        valmezMesto.checkHeader(headerTitle);
        valmezMesto.clickMenuLink(menuLinkMesto);

        valmezVedeni.getContacts();
        valmezVedeni.storeContacts();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
