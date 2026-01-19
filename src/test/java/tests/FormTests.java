package tests;

import io.qameta.allure.*;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.DriverFactory;

@Epic("Homework 3")
@Feature("Practice Form")
public class FormTests extends BaseTest {

    @Test
    @Story("Submit form and verify data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Fill the automation practice form and check that all entered data appears correctly in the modal popup")
    public void fillFormAndCheckPopup() {

        FormPage form = new FormPage(DriverFactory.getDriver());

        form.open();
        form.enterFirstName("Natia");
        form.enterLastName("Chkhetiani");
        form.enterEmail("natikochkhetianni@gmail.com");
        form.selectFemaleGender();
        form.enterPhone("5980051200");
        form.setDateOfBirth("19 Mar 202619");
        form.setSubject("Computer Science");
        form.selectHobbies();
        form.enterAddress("999 Street, Tbilisi, Georgia");
        form.selectState("NCR");
        form.selectCity("Delhi");
        form.submitForm();

        Assert.assertTrue(form.isModalDisplayed(), "Popup not displayed!");

        Assert.assertEquals(form.getTableValue("Student Name"), "Natia Chkhetiani");
        Assert.assertEquals(form.getTableValue("Student Email"), "natikochkhetianni@gmail.com");
        Assert.assertEquals(form.getTableValue("Gender"), "Female");
        Assert.assertEquals(form.getTableValue("Mobile"), "5980051200");
        Assert.assertEquals(form.getTableValue("Date of Birth"), "19 March,202619");
        Assert.assertEquals(form.getTableValue("Subjects"), "Computer Science");
        Assert.assertEquals(form.getTableValue("Hobbies"), "Reading, Music");
        Assert.assertEquals(form.getTableValue("Address"), "999 Street, Tbilisi, Georgia");
        Assert.assertEquals(form.getTableValue("State and City"), "NCR Delhi");
    }
}