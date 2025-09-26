package com.yourname.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ValmezHome {
    WebDriver driver;

    // Constructor
    public ValmezHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(css = "h1 strong")
    WebElement townTitle;
    
    @FindBy(css = "img#znak")
    WebElement logo;

    @FindBy(css = "li[id*='p']")
    List <WebElement> menuLinks;

    public boolean checkLogo() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOf(logo));

        return logo.isDisplayed();
        }

    public void checkTownTitle(String title) {
        townTitle.getText().equals(title);
    }

    public void clickMenuLink(String menuLink) {
    //     for (WebElement link : menuLinks) {
    //         if (link.getText().equals(menuLink)) {
    //             writer.write(link.getText());
    //             writer.newLine();
    //             link.click();
    //             break;
    //         }
    //     }
    // }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("outputLinks.txt", true))) { // Open file in append mode
            for (WebElement link : menuLinks) {
                if (link.getText().equals(menuLink)) {
                    writer.write(link.getText());  // Write the link text to the file
                    writer.newLine();              // Add a newline after each entry
                    link.click();                  // Click the link
                    break;                         // Exit the loop once the link is clicked
                }
            }
        } catch (IOException e) {
            e.printStackTrace();  // Handle IOExceptions (e.g., if file can't be written)
        }
    }
}
