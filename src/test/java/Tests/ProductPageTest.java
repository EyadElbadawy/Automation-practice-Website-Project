package Tests;/*
 * Created on 07/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import Pages.CompleteRegister.HomePage;
import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductPageTest {
    SHAFT.GUI.WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver).openUrl()
                .assertUrl();
    }
    @Description("Test Case 8: Verify All Products and product detail page")
    @Test
    public void contactTest() {
        new HomePage(driver)
                .clickOnProductsButton()
                .assertAllProducts()
                .assertProductsList()
                .clickProductList()
                .assertProductUrl()
                .assertProductDetails();



    }
}
