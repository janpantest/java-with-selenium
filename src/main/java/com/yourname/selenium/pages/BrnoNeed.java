package com.yourname.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BrnoNeed {
    WebDriver driver;

    // Constructor
    public BrnoNeed(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements    
    @FindBy(css = "svg.logo")
    WebElement brnoLogo;

    @FindBy(css = "h1.bno-title--alpha span")
    WebElement headerTitle;

    @FindBy(css = "h2 a")
    WebElement payLink;

    

    // Check logo visibility
    public boolean checkLogo(String title) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOf(headerTitle));

        headerTitle.getText().equals(title);
        return brnoLogo.isDisplayed();
    }

    public void clickLink() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOfAllElements(payLink));

            payLink.click();
    }
}
