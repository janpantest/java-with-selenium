package com.yourname.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class ValmezMesto {
    WebDriver driver;

    // Constructor
    public ValmezMesto(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(css = "h2.nazevVetve")
    WebElement header;

    @FindBy(css = "li strong a")
    List <WebElement> bodyMenuLinks;

    public boolean checkHeader(String title) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOf(header));

        header.getText().equals(title);
    

        return header.isDisplayed();
        }

    public void clickMenuLink(String menuLink) {
        for (WebElement link : bodyMenuLinks) {
            if (link.getText().equals(menuLink)) {
                link.click();
                break;
            }
        }
    }
}
