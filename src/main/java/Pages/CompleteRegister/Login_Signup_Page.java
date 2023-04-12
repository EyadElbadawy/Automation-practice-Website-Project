package Pages.CompleteRegister;/*
 * Created on 05/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Login_Signup_Page {

    private final By login_Signup_Text = By.xpath("//div[@class=\"signup-form\"]//h2");

    private final By login_Account_Text = By.xpath("//div[@class=\"login-form\"]//h2");

    private final By registerName = By.xpath("//input[@data-qa=\"signup-name\"]");

    private final By emailAddress = By.xpath("//input[@data-qa=\"signup-email\"]");

    private final By loginEmailAddress = By.xpath("//input[@data-qa=\"login-email\"]");

    private final By loginPassword = By.xpath("//input[@data-qa=\"login-password\"]");

    private final By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

    private final By signupButton = By.xpath("//button[@data-qa=\"signup-button\"]");

    private final By incorrectEmailMessage = By.xpath("//form[@action=\"/login\"]//p");

    private final By signUpErrorMessage = By.xpath("//form[@action=\"/signup\"]//p");

    SHAFT.GUI.WebDriver driver;

    SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON("src/test/java/resources/testDataFiles/RegisterData.json");

    //Constructor for the page
    public Login_Signup_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //asserting that the signup text exists
    public Login_Signup_Page assertSignup_Text() {
        driver.assertThat().element(login_Signup_Text).isVisible().perform();
        return this;
    }

    //asserting that the login text exists
    public Login_Signup_Page assertLogin_Text() {
        driver.assertThat().element(login_Account_Text).isVisible().perform();
        return this;
    }

    //entering the name and email texts
    public SignUp_Information_page enterNameAndEmail() {
        driver.element().type(registerName, testData.getTestData("Name"));
        driver.element().type(emailAddress, testData.getTestData("Email"));
        driver.element().click(signupButton);
        return new SignUp_Information_page(driver);
    }

    //entering login and email and password
    public AccountDeleted enterLoginEmailAndPassword() {
        driver.element().type(loginEmailAddress, testData.getTestData("Email"));
        driver.element().type(loginPassword, testData.getTestData("Password"));
        driver.element().click(loginButton);
        return new AccountDeleted(driver);
    }

    //entering incorrect email and password
    public Login_Signup_Page enterIncorrectLoginEmailAndPassword() {
        driver.element().type(loginEmailAddress, testData.getTestData("IncorrectEmail"));
        driver.element().type(loginPassword, testData.getTestData("IncorrectPassword"));
        driver.element().click(loginButton);
        return new Login_Signup_Page(driver);
    }

    //asserting the incorrect email error message
    public void assertIncorrectEmailText() {
        driver.assertThat().element(incorrectEmailMessage).isVisible().perform();
    }

    //asserting signup error message
    public void assertSignUpError() {
        driver.assertThat().element(signUpErrorMessage).isVisible().perform();
    }
}
