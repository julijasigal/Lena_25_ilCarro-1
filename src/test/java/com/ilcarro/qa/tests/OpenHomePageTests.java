package com.ilcarro.qa.tests;

import org.testng.annotations.Test;

public class OpenHomePageTests extends TestBase {

    @Test
    public void homePageTest() {
        System.out.println("site opened");

        //wd.findElement(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));
        System.out.println("FindCarForm : " + app.car().isFindCarFormPresent());
    }


}
