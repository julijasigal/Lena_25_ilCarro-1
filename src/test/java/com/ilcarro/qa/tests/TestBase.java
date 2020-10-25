package com.ilcarro.qa.tests;

import com.ilcarro.qa.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp(){
        app.init();
        // login("aa@bb109.com", "1Aaaaaaaa");

    }



    @AfterSuite(enabled = true)
    public void tearDown(){
        app.stop();
    }


}
