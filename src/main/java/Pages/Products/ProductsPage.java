package Pages.Products;/*
 * Created on 07/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import Pages.SearchProduct.SearchPage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ProductsPage {
    private final By allProductsText = By.xpath("//h2[contains(text(), \"All Products\")]");


    private final By firstProductText = By.xpath("//a[@href=\"/product_details/1\"]");

    private final By searchBox = By.xpath("//input[@id=\"search_product\"]");

    private final By submitSearch = By.xpath("//button[@id=\"submit_search\"]");
    private final By productsList = By.xpath("//div[@class='productinfo text-center']");

    SHAFT.GUI.WebDriver driver;

    SHAFT.TestData.JSON testData;

    //constructor for the page
    public ProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //assert on all products text
    public ProductsPage assertAllProducts() {
        driver.verifyThat().element(allProductsText).isVisible().perform();
        return this;
    }

    //assert on the products list
    public ProductsPage assertProductsList() {
        int x = driver.element().getElementsCount(productsList);
      for (int i = 1; i <= x; i++) {
            driver.getDriver().findElement(By.xpath("(//div[@class='productinfo text-center'])[\" + i + \"]")).isDisplayed();
        }
        return this;
    }

    //click on the product list
    public FirstProduct clickProductList() {
        driver.element().click(firstProductText);
        return new FirstProduct(driver);
    }

    //filling the search box and clicking on submit button
    public SearchPage fillSearchBox() {
        testData = new SHAFT.TestData.JSON("src/test/java/resources/testDataFiles/RegisterData.json");
        driver.element().type(searchBox, testData.getTestData("Search_Word"));
        driver.element().click(submitSearch);
        return new SearchPage(driver);
    }
}
