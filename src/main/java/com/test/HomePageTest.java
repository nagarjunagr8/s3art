package com.test;

import com.example.HomePage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomePageTest {

    @Test
    public void versionMethod() {
        HomePage h=new HomePage();
        assertEquals("abc",h.version("abc"));
    }
}