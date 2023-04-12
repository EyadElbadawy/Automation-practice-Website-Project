package Pages.CompleteRegister;/*
 * Created on 05/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import Pages.ContactUs.ContactUs;
import Pages.Products.ProductsPage;
import Pages.TestCases.TestCasesPage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HomePage {

    //link for the signup button to open the register page
    private final By login_Signup_Link = By.xpath("//a[@href=\"/login\"]");

    private final By logout_Link = By.xpath("//a[@href=\"/logout\"]");

    private final By contactUs_Link = By.xpath("//a[@href=\"/contact_us\"]");

    private final By testCases_Link = By.xpath("//a[contains(text(), \" Test Cases\")]");

    private final By products_Link = By.xpath("//a[contains(text(), \" Products\")]");

    private final By footerElement = By.xpath("//footer[@id=\"footer\"]");

    private final By subscriptionText = By.xpath("//h2[contains(text(),\"Subscription\")]");

    private final By SubscriptionEmail = By.xpath("//input[@id=\"susbscribe_email\"]");

    private final By SubscriptionButton = By.xpath("//button[@id=\"subscribe\"]");

    private final By alertSubscriptionMessage = By.xpath("//div[@class=\"alert-success alert\"]");

    SHAFT.GUI.WebDriver driver;

    SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON("src/test/java/resources/testDataFiles/RegisterData.json");

    String url = "https://www.automationexercise.com/";

    //Constructor for the homepage
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //navigating to the website url and asserting that the url is correct
    public HomePage openUrl() {
        driver.browser().navigateToURL(url);
        return this;
    }

    //asserting that the url is correct
    public HomePage assertUrl() {
        driver.assertThat().browser().url().isEqualTo(url).perform();
        return this;
    }

    //click on register button and navigating to the second page
    public Login_Signup_Page clickOnSignup_LoginButton() {
        driver.element().click(login_Signup_Link);
        return new Login_Signup_Page(driver);
    }

    //clicking on logout button
    public HomePage clickOnLogoutButton() {
        driver.element().click(logout_Link);
        return new HomePage(driver);
    }

    //checking that the login text is showing
    public HomePage assertLogin_Text() {
        driver.assertThat().element(login_Signup_Link).isVisible();
        return new HomePage(driver);
    }

    //clicking on contact us button
    public ContactUs clickOnContactUsButton() {
        driver.element().click(contactUs_Link);
        return new ContactUs(driver);
    }

    //clicking on test cases button
    public TestCasesPage clickOnTestCasesButton() {
        driver.element().click(testCases_Link);
        return new TestCasesPage(driver);
    }

    //clicking on products button
    public ProductsPage clickOnProductsButton() {
        driver.element().click(products_Link);
        return new ProductsPage(driver);
    }

    //scrolling to the footer of the page
    public HomePage scrollToFooter() {
        driver.element().scrollToElement(footerElement);
        return this;
    }

    //asserting that subscription text exists
    public HomePage assertSubscriptionText() {
        driver.assertThat().element(subscriptionText).isVisible();
        return new HomePage(driver);
    }

    //entering the email in subscription field
    public HomePage enterSubscriptionEmail() {
        driver.element().type(SubscriptionEmail, testData.getTestData("Email"));
        return new HomePage(driver);
    }

    //clicking on subscribe button
    public HomePage clickOnSubscribeButton() {
        driver.element().click(SubscriptionButton);
        return new HomePage(driver);
    }

    //asserting on alert message
    public void assertOnAlertMessage() {
        driver.assertThat().element(alertSubscriptionMessage).isVisible();


    }
}

