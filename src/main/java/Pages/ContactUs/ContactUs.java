package Pages.ContactUs;/*
 * Created on 06/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ContactUs {
    private final By getInTouchText = By.xpath("//h2[contains(text(),\"Get In Touch\")]");

    private final By nameField = By.xpath("//input[@data-qa=\"name\"]");

    private final By emailField = By.xpath("//input[@data-qa=\"email\"]");

    private final By subjectField = By.xpath("//input[@data-qa=\"subject\"]");

    private final By messageField = By.xpath("//textarea[@data-qa=\"message\"]");

    private final By sendFileField = By.xpath("//input[@name=\"upload_file\"]");

    private final String filePath = "C:\\Users\\AfifiE\\OneDrive - Vodafone Group\\Desktop\\ShaftProject\\New_Shaft_Project\\Json.txt";

    private final By submitButton = By.xpath("//input[@data-qa=\"submit-button\"]");

    SHAFT.GUI.WebDriver driver;

    SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON("src/test/java/resources/testDataFiles/RegisterData.json");

    //constructor for the page
    public ContactUs(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //assert getting in touch is visible
    public ContactUs assertGetInTouch() {
        driver.verifyThat().element(getInTouchText).isVisible().perform();
        return this;
    }

    //entering contact data fields
    public ContactUs enterData() {

        driver.element().type(nameField, testData.getTestData("FirstName"));
        driver.element().type(emailField, testData.getTestData("Email"));
        driver.element().type(subjectField, testData.getTestData("Subject"));
        driver.element().type(messageField, testData.getTestData("Message"));
        return this;
    }

    //sending file
    public ContactUs sendFile() {
        driver.element().typeAppend(sendFileField, filePath);
        return this;
    }

    //clicking submit button and accepting the alert message
    public Feedback clickSubmit() {
        driver.element().click(submitButton);
        driver.alert().acceptAlert();
        return new Feedback(driver);
    }
}
