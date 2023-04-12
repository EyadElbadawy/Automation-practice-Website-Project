package Pages.CompleteRegister;/*
 * Created on 05/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountCreated {
    private final By accountInCreatedText = By.xpath("//h2[@data-qa=\"account-created\"]");

    private final By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    SHAFT.GUI.WebDriver driver;

    //constructor for the page
    AccountCreated(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //asserting create account text is showing
    public AccountCreated assertCreateAccount() {
        driver.verifyThat().element(accountInCreatedText).text().isEqualTo("ACCOUNT CREATED!").perform();
        return this;
    }

    //clicking continue button
    public AccountDeleted clickContinue() {
        driver.element().click(continueButton);
        return new AccountDeleted(driver);
    }
}

