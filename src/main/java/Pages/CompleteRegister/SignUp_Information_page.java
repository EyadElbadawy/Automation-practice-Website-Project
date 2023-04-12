package Pages.CompleteRegister;/*
 * Created on 05/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignUp_Information_page {
    private final By accountInformationText = By.xpath("//div[@class=\"login-form\"]/h2[1]//b");

    private final By registerForm_Title = By.xpath("//input[@id='id_gender1']");

    private final By registerForm_Password = By.xpath("//input[@type='password']");

    private final By dateOfBirth_Days = By.xpath("//select[@id='days']");

    private final By dateOfBirth_Month = By.xpath("//select[@id='months']");

    private final By dateOfBirth_Years = By.xpath(" //select[@id='years']");

    private final By signUp_NewsLetter = By.xpath("//input[@name=\"newsletter\"]");

    private final By receiveSpecialOffers = By.xpath("//input[@name=\"optin\"]");

    private final By firstName = By.xpath("//input[@data-qa='first_name']");

    private final By lastName = By.xpath("//input[@data-qa='last_name']");

    private final By company = By.xpath("//input[@data-qa='company']");

    private final By address = By.xpath("//input[@data-qa='address']");

    private final By address2 = By.xpath("//input[@data-qa='address2']");

    private final By country = By.xpath("//select[@data-qa='country']");

    private final By state = By.xpath("//input[@data-qa='state']");

    private final By city = By.xpath("//input[@data-qa='city']");

    private final By zipCode = By.xpath("//input[@data-qa='zipcode']");

    private final By mobileNumber = By.xpath("//input[@data-qa='mobile_number']");

    private final By createAccount = By.xpath("//button[@data-qa='create-account']");

    SHAFT.GUI.WebDriver driver;

    SHAFT.TestData.JSON testData;

    //constructor for the page
    SignUp_Information_page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //asserting information text is visible
    public SignUp_Information_page assertInformationText() {
        driver.verifyThat().element(accountInformationText).text().isEqualTo("ENTER ACCOUNT INFORMATION").perform();
        return this;
    }

    //entering the input personal data
    public AccountCreated enterPersonalData() {
        testData = new SHAFT.TestData.JSON("src/test/java/resources/testDataFiles/RegisterData.json");
        driver.element().click(registerForm_Title);
        driver.element().type(registerForm_Password, testData.getTestData("Password"));
        driver.element().select(dateOfBirth_Days, testData.getTestData("Day"));
        driver.element().select(dateOfBirth_Month, testData.getTestData("Month"));
        driver.element().select(dateOfBirth_Years, testData.getTestData("Year"));
        driver.element().click(registerForm_Title);
        driver.element().click(signUp_NewsLetter);
        driver.element().click(receiveSpecialOffers);
        driver.element().type(firstName, testData.getTestData("FirstName"));
        driver.element().type(lastName, testData.getTestData("LastName"));
        driver.element().type(company, testData.getTestData("Company"));
        driver.element().type(address, testData.getTestData("Address"));
        driver.element().type(address2, testData.getTestData("Address2"));
        driver.element().select(country, testData.getTestData("Country"));
        driver.element().type(state, testData.getTestData("State"));
        driver.element().type(city, testData.getTestData("City"));
        driver.element().type(zipCode, testData.getTestData("ZipCode"));
        driver.element().type(mobileNumber, testData.getTestData("MobileNumber"));

        driver.element().click(createAccount);
        return new AccountCreated(driver);
    }
}

