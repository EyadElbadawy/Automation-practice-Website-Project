package Pages.CompleteRegister;/*
 * Created on 05/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountDeleted {
    private final By loggedInCreatedText = By.xpath("//a[contains(text(),\"Logged in\")]");

    private final By accountDeletedText = By.xpath("//h2[@data-qa=\"account-deleted\"]");

    private final By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    private final By deletedAccountButton = By.xpath("//a[@href=\"/delete_account\"]");

    SHAFT.GUI.WebDriver driver;

    //constructor for the page
    AccountDeleted(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //assert on logged in text
    public AccountDeleted assertLoggedInText() {
        driver.verifyThat().element(loggedInCreatedText).text().isEqualTo("Logged in as Eyad").perform();
        return this;
    }

    //assert on deleted text
    public AccountDeleted assertDeletedAccount() {
        driver.verifyThat().element(accountDeletedText).text().isEqualTo("ACCOUNT DELETED!").perform();
        return this;
    }

    //clicking continue button
    public void clickContinue() {
        driver.element().click(continueButton);
        new AccountDeleted(driver);
    }

    //clicking on delete account button
    public AccountDeleted deleteAccount() {
        driver.element().click(deletedAccountButton);
        return new AccountDeleted(driver);
    }
}

