package Pages.ContactUs;/*
 * Created on 06/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import Pages.CompleteRegister.HomePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Feedback {
    private final By homeButton = By.xpath("//a[@class=\"btn btn-success\"]");

    private final By successMessage = By.xpath("//div[@class=\"status alert alert-success\"]");

    SHAFT.GUI.WebDriver driver;

    //constructor for the page
    public Feedback(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //clicking on home button
    public HomePage clickHome() {
        driver.element().click(homeButton);
        return new HomePage(driver);
    }

    //assert on success message text
    public Feedback assertSuccessMessage() {
        driver.verifyThat().element(successMessage).text().isEqualTo("Success! Your details have been submitted successfully.").perform();
        return this;
    }
}
