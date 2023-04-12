package Tests;/*
 * Created on 05/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import Pages.CompleteRegister.HomePage;
import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest {
    SHAFT.GUI.WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Description(("TC01 from Automation practice website"))
    @Test
    public void completeRegister() {
        new HomePage(driver).openUrl()
                .assertUrl()
                .clickOnSignup_LoginButton()
                .assertSignup_Text()
                .enterNameAndEmail()
                .assertInformationText()
                .enterPersonalData()
                .assertCreateAccount()
                .clickContinue()
                .assertLoggedInText()
                .deleteAccount()
                .assertDeletedAccount()
                .clickContinue();
    }
}

