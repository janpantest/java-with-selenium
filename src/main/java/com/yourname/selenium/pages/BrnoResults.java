package com.yourname.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.interactions.Actions;

public class BrnoResults {
    WebDriver driver;

    // Constructor
    public BrnoResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements    
    @FindBy(css = "svg.logo")
    WebElement brnoLogo;

    @FindBy(css = "h1.bno-title--alpha")
    WebElement titleText;

    @FindBy(css = "ul li h4 a")
    List<WebElement> links;

    @FindBy(css = "h2.bno-title--alpha")
    WebElement resultHeader;

    public boolean checkPage(String resultTitle) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.and(
            ExpectedConditions.visibilityOf(brnoLogo),
            ExpectedConditions.visibilityOf(resultHeader)
            ));

            // for (WebElement link : links) {
            //         System.out.println(link.getText());
            //     }

        titleText.getText().equals(resultTitle);
        return brnoLogo.isDisplayed();
    }

    // public void clickLink(String linkText) {
    //     for (WebElement link : links) {
    //         System.out.println("tttt : " + link.getText());
    //         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
    //         if (link.getText().equals(linkText)) {
    //             link.click();
    //             break;
    //         }
    //     }
    // }

    // public void clickLink(String linkText) {
    //     for (WebElement link : links) {
    //         System.out.println("tttt : " + link.getText());
    //         if (link.getText().equals(linkText)) {
    //             // Scroll the element into view using JavaScript
    //             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", link);
                
    //             // Wait for the element to be clickable
    //             new WebDriverWait(driver, Duration.ofSeconds(15))
    //                 .until(ExpectedConditions.elementToBeClickable(link));
                
    //             // Now click the link
    //             link.click();
    //             break;
    //         }
    //     }
    // }
public void clickLink(String linkText) {
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
    new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(ExpectedConditions.visibilityOfAllElements(links));

    for (WebElement link : links) {
        if (link.getText().equals(linkText)) {
            // Scroll the element into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", link);

            // Use Actions to move the mouse to the element
            Actions actions = new Actions(driver);
            actions.moveToElement(link).perform();  // Move to the element

            // Wait for the element to be clickable
            new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(link));

            // Click the link
            link.click();
            break;
        }
    }
}


}
