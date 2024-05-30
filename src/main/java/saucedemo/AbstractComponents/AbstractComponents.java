package saucedemo.AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * AbstractComponents class provides common functionalities that can be used
 * across different page objects in the SauceDemo application.
 * It includes methods to handle common web interactions such as waiting for
 * elements to appear.
 */
public class AbstractComponents {

    protected WebDriver driver;

    /**
     * Constructor to initialize AbstractComponents.
     *
     * @param driver The WebDriver instance to interact with the browser.
     */
    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Waits for an element to appear on the page.
     *
     * @param findBy The locator used to find the element.
     */
    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
}
