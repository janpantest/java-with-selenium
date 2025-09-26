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

public class BrnoPay {
    WebDriver driver;

    // Constructor
    public BrnoPay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements    
    @FindBy(css = "svg.logo")
    WebElement brnoLogo;

    @FindBy(css = "h3 strong")
    List <WebElement> infoTexts;

    @FindBy(css = "h1.bno-title--alpha span")
    WebElement headerTitle;

    public void checkLogo(String title) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOf(brnoLogo));

        headerTitle.getText().equals(title);
    }

    public void getInfo() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfAllElements(infoTexts));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("outputPayments.txt", true))) { // Open file in append mode
            for (WebElement info : infoTexts) {

                System.out.println(info.getText());
                writer.write(info.getText());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
