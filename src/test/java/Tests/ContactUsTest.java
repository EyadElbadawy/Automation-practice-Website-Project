package Tests;/*
 * Created on 06/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import Pages.CompleteRegister.HomePage;
import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactUsTest {
    SHAFT.GUI.WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Description("Test Case 6: Contact Us Form")
    @Test
    public void contactTest() {
        new HomePage(driver).openUrl()
                .clickOnContactUsButton()
                .assertGetInTouch()
                .enterData()
                .sendFile()
                .clickSubmit()
                .assertSuccessMessage()
                .clickHome()
                .assertUrl();
    }
}
