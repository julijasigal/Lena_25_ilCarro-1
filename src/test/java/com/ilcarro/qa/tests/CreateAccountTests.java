package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {
    //preconditions: user shoud be logged out
    @DataProvider
    public Iterator<Object[]>validUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"fName1", "lname", "lname+2@gmail.com", "1Qaaaaaaa"});
        list.add(new Object[]{"aab", "FF", "1111+2@ss.com", "lkjhgfd2Q"});
        list.add(new Object[]{"112", "66", "11_11+2@ss.com", "lkjhgfd2Q"});

        return list.iterator();
    }

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.header().isSignUpTabPresentInHeader()) {    //sign up not present
            app.header().clickLogout();
        }
    }

    @Test
    public void testSignUp() throws InterruptedException {
        app.header().clickSignUp();
        app.session().fillRegistrationForm(new User()
                .setfName("AS")
                .setlName("FV")
                .setEmail("aa" + System.currentTimeMillis() + "@bb318.com")
                .setPassword("1Aaaaaaaa"));

        //click submit button
        app.session().submitForm();

        //check, login form displayed
        Assert.assertTrue(app.session().isLoginFormPresent());
        logger.info(String.valueOf(app.session().isLoginFormPresent()));
    }

    @Test(dataProvider = "validUser")
    public void testSignUpFromDataProvider(
            String fName, String lName, String email, String password ) throws InterruptedException {
        app.header().clickSignUp();
        app.session().fillRegistrationForm(new User()
                .setfName(fName)
                .setlName(lName)
                .setEmail(email)
                .setPassword(password));

        //click submit button
        app.session().submitForm();

        logger.info("Login form present. actual result: "+ app.session().isLoginFormPresent()
                + " expected result is: true ");
        //check, login form displayed
        Assert.assertTrue(app.session().isLoginFormPresent());

    }


}
