package Pages.Products;/*
 * Created on 07/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class FirstProduct {

    private final By productDetails = By.xpath("//h2[contains(text(),\"Blue Top\")]");

    private final By availability = By.xpath("//b[contains(text(),\"Availability:\")]");

    private final By condition = By.xpath("//b[contains(text(),\"Condition:\")]");

    private final By brand = By.xpath("//b[contains(text(),\"Brand:\")]");

    SHAFT.GUI.WebDriver driver;

    String url = "https://www.automationexercise.com/product_details/1";

    //constructor for the page
    public FirstProduct(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //assert on the page url
    public FirstProduct assertProductUrl() {
        driver.assertThat().browser().url().isEqualTo(url).perform();
        return this;
    }

    //assert on the product details
    public void assertProductDetails() {
        driver.verifyThat().element(productDetails).isVisible().perform();
        driver.verifyThat().element(availability).isVisible().perform();
        driver.verifyThat().element(condition).isVisible().perform();
        driver.verifyThat().element(brand).isVisible().perform();

    }
}
