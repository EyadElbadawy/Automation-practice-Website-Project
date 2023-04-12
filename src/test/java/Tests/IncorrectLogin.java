package Tests;/*
 * Created on 06/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import Pages.CompleteRegister.HomePage;
import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IncorrectLogin {
    SHAFT.GUI.WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();

        new HomePage(driver).openUrl()
                .assertUrl()
                .clickOnSignup_LoginButton()
                .enterNameAndEmail()
                .enterPersonalData()
                .clickContinue();
    }

    @Description("Test Case 3: Login User with incorrect email and password")
    @Test
    public void incorrectLogin() {
        new HomePage(driver)
                .clickOnLogoutButton()
                .clickOnSignup_LoginButton()
                .assertLogin_Text()
                .enterIncorrectLoginEmailAndPassword()
                .assertIncorrectEmailText();
    }
}
