package com.yourname.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class CartPage {
    WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(css = "span.title")
    WebElement title;

    @FindBy(css = "button[id*='remove']")
    WebElement removeButton;

    @FindBy(css = "span.shopping_cart_badge")
    WebElement cartBadge;

    @FindBy(css = "div.inventory_item_name ")
    List <WebElement> product;

    public void checkCartTitle(String cartTitle) {
        new WebDriverWait(driver, Duration.ofSeconds(5))  // wait up to 5 seconds
            .until(ExpectedConditions.visibilityOf(title));

        String actualTitle = title.getText();
        String expectedTitle = cartTitle;

        actualTitle.equals(expectedTitle);
        }

    public void checkProductName(String productName) {
        String cartProductName = product.get(0).getText();
        System.out.println("Product in cart: " + cartProductName);

        cartProductName.equals(productName);
    }
}
