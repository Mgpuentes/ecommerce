package com.code4life.ecommerce.unit;

import com.code4life.ecommerce.controller.HomeController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeUnitTest {

    private HomeController homeController;

    @Before
    public void setUp() throws Exception {
        homeController = new HomeController();
    }

    @After
    public void tearDown() throws Exception {
        homeController = null;
    }

    @Test
    public void returnContentOfHomeMethod() throws Exception {
        String expected = "home";

        String actual = homeController.home();

        assertEquals(expected, actual);
    }
}
