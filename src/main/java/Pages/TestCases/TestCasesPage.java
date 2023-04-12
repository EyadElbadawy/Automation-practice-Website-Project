package Pages.TestCases;/*
 * Created on 06/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class TestCasesPage {
    private final By testCasesText = By.xpath("//h2[@class=\"title text-center\"]//b");

    SHAFT.GUI.WebDriver driver;

    //constructor for the page
    public TestCasesPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //assert on test cases text
    public void assertTestCases() {
        driver.verifyThat().element(testCasesText).isVisible().perform();
    }
}
