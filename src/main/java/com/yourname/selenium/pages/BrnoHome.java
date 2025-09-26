package com.yourname.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class BrnoHome {
    WebDriver driver;

    // Constructor
    public BrnoHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements    
    @FindBy(css = "svg.logo")
    WebElement brnoLogo;

    @FindBy(css = "h1.bno-title--alpha span")
    WebElement headerTitle;

    @FindBy(css = "span.bno-link")
    List<WebElement> menuLinks;

    @FindBy(css = "button.bno-toggle--search")
    WebElement buttonSearch;

    @FindBy(css = "input[id*='search-whisperer']")
    WebElement inputField;

    @FindBy(css = "button.bno-button--secondary")
    WebElement confirmButton;
    
    @FindBy(css = "div#bno-search")
    WebElement searchContainer;

    @FindBy(css = "a span.bno-link")
    List<WebElement> autocompleteSuggestion;

    

    // Check logo visibility
    public boolean checkLogo() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOf(menuLinks.get(0)));

        // Print out all menu links
        for (WebElement link : menuLinks) {
            System.out.println(link.getText());
        }
        return brnoLogo.isDisplayed();
    }

    // Search for information in the search field
    // public void searchInfo(String text) {
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increase timeout to 30 seconds

    //     try {
    //         // Wait for the search button to be clickable and click it
    //         System.out.println("Waiting for search button to be clickable...");
    //         wait.until(ExpectedConditions.elementToBeClickable(buttonSearch));
    //         buttonSearch.click();

    //         // Wait for the input field to be present in the DOM
    //         System.out.println("Waiting for input field to be present in DOM...");
    //         wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#search-whisperer-230")));

    //         // Wait for the input field to be visible before interacting
    //         System.out.println("Waiting for input field to be visible...");
    //         wait.until(ExpectedConditions.visibilityOf(inputField));

    //         // Ensure the field is displayed and interact with it
    //         if (inputField.isDisplayed()) {
    //             System.out.println("Input field is visible. Sending text...");
    //             inputField.sendKeys(text);
    //         } else {
    //             System.out.println("Input field is not visible.");
    //         }

    //         // Click the confirm button
    //         confirmButton.click();

    //     } catch (TimeoutException e) {
    //         System.out.println("Timeout waiting for input field to become visible: " + e.getMessage());
    //     }
    // }

    //     public void searchInfo(String text) {
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased timeout to 20 seconds

    //     try {
    //         // Wait for the search button to be clickable and click it
    //         System.out.println("Waiting for search button to be clickable...");
    //         wait.until(ExpectedConditions.elementToBeClickable(buttonSearch));
    //         buttonSearch.click();

    //         // Switch to iframe if input field is inside one
    //         System.out.println("Switching to iframe...");
    //         WebElement iframe = driver.findElement(By.tagName("iframe")); // Adjust selector as needed
    //         driver.switchTo().frame(iframe);  // Switch to iframe by element (or use By.id, By.name, etc.)

    //         // Wait for the input field to be present in the DOM
    //         System.out.println("Waiting for input field to be present in DOM...");
    //         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='search-whisperer-230']")));

    //         // Wait for the input field to be visible before interacting
    //         System.out.println("Waiting for input field to be visible...");
    //         wait.until(ExpectedConditions.visibilityOf(inputField));

    //         // Ensure the field is displayed and interact with it
    //         if (inputField.isDisplayed()) {
    //             System.out.println("Input field is visible. Sending text...");
    //             inputField.sendKeys(text);
    //         } else {
    //             System.out.println("Input field is not visible.");
    //         }

    //         // Click the confirm button
    //         confirmButton.click();

    //         // Switch back to the main content (default content)
    //         System.out.println("Switching back to the main content...");
    //         driver.switchTo().defaultContent();

    //     } catch (TimeoutException e) {
    //         System.out.println("Timeout waiting for input field to become visible: " + e.getMessage());
    //     }
    // }

    // public void searchInfo(String text) {
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased timeout to 20 seconds

    //     try {
    //         // Step 1: Wait for the search button (magnifying glass or len icon) to be clickable and click it
    //         System.out.println("Waiting for the search button to be clickable...");
    //         wait.until(ExpectedConditions.elementToBeClickable(buttonSearch));
    //         buttonSearch.click();

    //         // Step 2: Wait for the input field to appear after clicking the search button
    //         System.out.println("Waiting for input field to be visible...");
    //         WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#search-whisperer-230"))); // Adjust selector if needed

    //         // Step 3: Wait for the input field to be clickable for 5 seconds
    //         System.out.println("Waiting for input field to be clickable...");
    //         new WebDriverWait(driver, Duration.ofSeconds(5))  // Adding a 5-second wait here
    //             .until(ExpectedConditions.elementToBeClickable(inputField));

    //         // Step 4: Use JavaScript to focus on the input field (in case the field is not focused automatically)
    //         System.out.println("Focusing on input field...");
    //         ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", inputField);

    //         // Step 5: Enter the text into the input field
    //         System.out.println("Entering search text...");
    //         inputField.sendKeys(text);

    //         // Step 6: Wait for and click the confirm button (Hledat)
    //         WebElement searchButton = driver.findElement(By.cssSelector("button.bno-button--secondary")); // Adjust this if the button has a different selector
    //         System.out.println("Clicking search button...");
    //         searchButton.click();

    //     } catch (TimeoutException e) {
    //         System.out.println("Timeout waiting for elements: " + e.getMessage());
    //     }
    // }

    // public void searchInfo(String text) {
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased timeout to 20 seconds

    //     try {
    //         // Step 1: Wait for the search button (magnifying glass or len icon) to be clickable and click it
    //         System.out.println("Waiting for the search button to be clickable...");
    //         wait.until(ExpectedConditions.elementToBeClickable(buttonSearch));
    //         buttonSearch.click();

    //         // Step 2: Wait for the input field to appear after clicking the search button
    //         System.out.println("Waiting for input field to be visible...");
    //         WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#bno-search"))); // Adjust selector if needed

    //         // Step 3: Handle staleness by checking if the element is still valid and re-find it if needed
    //         try {
    //             // Step 3.1: Ensure the input field is visible and interactable
    //             wait.until(ExpectedConditions.elementToBeClickable(inputField));

    //             // Step 3.2: Focus on the input field using JavaScript in case the field is not focused automatically
    //             System.out.println("Focusing on input field...");
    //             ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", inputField);

    //             // Step 3.3: Enter the text into the input field
    //             System.out.println("Entering search text...");
    //             inputField.sendKeys(text);
    //         } catch (org.openqa.selenium.StaleElementReferenceException e) {
    //             // Handle the staleness: Re-locate the input field and try again
    //             System.out.println("Stale element detected. Re-locating input field and retrying...");
    //             inputField = driver.findElement(By.cssSelector("input#search-whisperer-230"));
    //             inputField.sendKeys(text);
    //         }

    //         // Step 4: Wait for and click the confirm button (Hledat)
    //         WebElement searchButton = driver.findElement(By.cssSelector("button.bno-button--secondary")); // Adjust this if the button has a different selector
    //         System.out.println("Clicking search button...");
    //         searchButton.click();

    //     } catch (TimeoutException e) {
    //         System.out.println("Timeout waiting for elements: " + e.getMessage());
    //     }
    // }

    // public void searchInfo(String text) {
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased timeout to 20 seconds

    //     try {
    //         // Step 1: Wait for the search button (magnifying glass or len icon) to be clickable and click it
    //         System.out.println("Waiting for the search button to be clickable...");
    //         wait.until(ExpectedConditions.elementToBeClickable(buttonSearch));
    //         buttonSearch.click();

    //         // Step 2: Wait for the input field to appear after clicking the search button
    //         System.out.println("Waiting for input field to be visible...");
    //         WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#search-whisperer-230"))); // Directly target the input field

    //         // Step 3: Wait for the input field to be clickable
    //         wait.until(ExpectedConditions.elementToBeClickable(inputField));

    //         // Step 4: Ensure the input field is focused using JavaScript (if needed)
    //         System.out.println("Focusing on input field...");
    //         ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", inputField);

    //         // Step 5: Enter the text into the input field
    //         System.out.println("Entering search text...");
    //         inputField.sendKeys(text);

    //         // Step 6: Wait for and click the confirm button (Hledat)
    //         WebElement searchButton = driver.findElement(By.cssSelector("button.bno-button--secondary")); // Adjust this if the button has a different selector
    //         System.out.println("Clicking search button...");
    //         searchButton.click();

    //     } catch (TimeoutException e) {
    //         System.out.println("Timeout waiting for elements: " + e.getMessage());
    //     } catch (org.openqa.selenium.StaleElementReferenceException e) {
    //         // Handle staleness: Re-locate the input field and try again
    //         System.out.println("Stale element detected. Re-locating input field and retrying...");
    //         searchInfo(text); // Retry the search action
    //     } catch (org.openqa.selenium.ElementNotInteractableException e) {
    //         System.out.println("Element is not interactable: " + e.getMessage());
    //     }
    // }
    // public void searchInfo(String text) {
    //         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased timeout to 20 seconds

    //         try {
    //             // Step 1: Wait for the search button (magnifying glass or len icon) to be clickable and click it
    //             System.out.println("Waiting for the search button to be clickable...");
    //             wait.until(ExpectedConditions.elementToBeClickable(buttonSearch));
    //             buttonSearch.click();

    //             // Step 2: Wait for the input field to appear after clicking the search button
    //             System.out.println("Waiting for input field to be visible...");
    //             WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bno-form-control"))); // Directly target the input field

    //             // Step 3: Wait for the input field to be clickable
    //             wait.until(ExpectedConditions.elementToBeClickable(container));

    //             // Step 4: Ensure the input field is focused using JavaScript (if needed)
    //             System.out.println("Focusing on input field...");
    //             WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id*='search-whisperer']"))); // Directly target the input field
    //             ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", inputField);

    //             // Step 5: Enter the text into the input field
    //             System.out.println("Entering search text...");
    //             inputField.sendKeys(text);

    //             // Step 6: Wait for and click the confirm button (Hledat)
    //             WebElement searchButton = driver.findElement(By.cssSelector("button.bno-button--secondary")); // Adjust this if the button has a different selector
    //             System.out.println("Clicking search button...");
    //             searchButton.click();

    //         } catch (TimeoutException e) {
    //             System.out.println("Timeout waiting for elements: " + e.getMessage());
    //         } catch (org.openqa.selenium.StaleElementReferenceException e) {
    //             // Handle staleness: Re-locate the input field and try again
    //             System.out.println("Stale element detected. Re-locating input field and retrying...");
    //             searchInfo(text); // Retry the search action
    //         } catch (org.openqa.selenium.ElementNotInteractableException e) {
    //             System.out.println("Element is not interactable: " + e.getMessage());
    //         }
    //     }

    public void searchInfo(String text) {
        buttonSearch.isDisplayed();
        buttonSearch.click();
        inputField.isDisplayed();
        inputField.sendKeys(text);
        confirmButton.isDisplayed();
        confirmButton.click();
    }

    public void clickLink() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOfAllElements(autocompleteSuggestion));
        for (WebElement suggestion : autocompleteSuggestion) {
            System.out.println("Here we go " + suggestion.getText());
        }
    }
}
