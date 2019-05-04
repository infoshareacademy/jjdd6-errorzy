package com.infoshareacademy.jjdd6.userinput;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetUserInputTest {

    @Test
    void testIfGetStringFromUserIsCorrect() {
        final String actualValue = "test String";
        System.setIn(new ByteArrayInputStream(actualValue.getBytes()));
        assertEquals("test String", GetUserInput.getStringFromUser("Display text"));
    }

    @Test
    void testIfGetIntegerFromUserIsCorrect() {
        final String actualValue = "1234";
        System.setIn(new ByteArrayInputStream(actualValue.getBytes()));
        assertEquals(1234, GetUserInput.getIntegerFromUser("Display text"));
    }

    @Test
    void getDoubleFromUser() {
        final String actualValue = "1.234";
        System.setIn(new ByteArrayInputStream(actualValue.getBytes()));
        assertEquals(1.234, GetUserInput.getDoubleFromUser("Display text"));
    }
}