package Pages.SearchProduct;/*
 * Created on 07/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchPage {
    private final By searchedProductsText = By.xpath("//h2[@class=\"title text-center\"]");

    SHAFT.GUI.WebDriver driver;

    //constructor for the page
    public SearchPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //assert on searched products text
    public SearchPage assertSearchedProductsText() {
        driver.verifyThat().element(searchedProductsText).isVisible().perform();
        return this;
    }

    //asserting that all products visible
    public void verifyAllProductsAreVisible() {
        for (int i = 1; i < 9; i++) {
            driver.getDriver().findElement(By.xpath("(//div[@class='productinfo text-center'])[\" + i + \"]")).isDisplayed();
        }
    }
}
