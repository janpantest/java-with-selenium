package com.yourname.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ValmezVedeni {
    WebDriver driver;

    // Constructor
    public ValmezVedeni(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(css = "div.utvary")
    WebElement contact;
    
    public void getContacts() {
        System.out.println(contact.getText());
    }

    public void storeContacts() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("outputContact.txt", true))) { // Open file in append mode
            writer.write(contact.getText());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
