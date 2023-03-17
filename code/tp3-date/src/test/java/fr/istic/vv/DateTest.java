package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

@Test
    public void testValidDate() {
        assertTrue(Date.isValidDate(1, 1, 2000));
        assertTrue(Date.isValidDate(31, 12, 2022));
        assertTrue(Date.isValidDate(29, 2, 2020));
        assertFalse(Date.isValidDate(29, 2, 2021));
        assertFalse(Date.isValidDate(-1, 1, 2000));
        assertFalse(Date.isValidDate(32, 12, 2022));
        assertFalse(Date.isValidDate(31, 13, 2022));
    }

    @Test
    public void testIsLeapYear() {
        assertTrue(Date.isLeapYear(2000));
        assertTrue(Date.isLeapYear(2020));
        assertFalse(Date.isLeapYear(1900));
        assertFalse(Date.isLeapYear(2021));
    }

    @Test
    public void testNextDate() {
        assertTrue(new Date(2, 1, 2000).compareTo(new Date(1, 1, 2000).nextDate())==0);
        assertTrue(new Date(1, 2, 2000).compareTo(new Date(31, 1, 2000).nextDate())==0);
        assertTrue(new Date(1, 3, 2000).compareTo(new Date(29, 2, 2000).nextDate())==0);
        assertTrue(new Date(1, 1, 2001).compareTo(new Date(31, 12, 2000).nextDate())==0);
    }

    private void assertEquals(boolean b) {
    }

    @Test
    public void testPreviousDate() {
        assertTrue(new Date(31, 12, 1999).compareTo(new Date(1, 1, 2000).previousDate())==0);
        assertTrue(new Date(30, 1, 2000).compareTo(new Date(31, 1, 2000).previousDate())==0);
        assertTrue(new Date(28, 2, 2000).compareTo(new Date(29, 2, 2000).previousDate())==0);
        assertTrue(new Date(30, 12, 2000).compareTo(new Date(31, 12, 2000).previousDate())==0);
    }

    @Test
    public void testCompareTo() {
        assertTrue(new Date(1, 1, 2000).compareTo(new Date(1, 1, 2000)) == 0);
        assertTrue(new Date(1, 1, 2000).compareTo(new Date(2, 1, 2000)) < 0);
        assertTrue(new Date(2, 1, 2000).compareTo(new Date(1, 1, 2000)) > 0);
        assertTrue(new Date(1, 1, 2000).compareTo(new Date(1, 2, 2000)) < 0);
        assertTrue(new Date(1, 2, 2000).compareTo(new Date(1, 1, 2000)) > 0);
        assertTrue(new Date(1, 1, 2000).compareTo(new Date(1, 1, 2001)) < 0);
        assertTrue(new Date(1, 1, 2001).compareTo(new Date(1, 1, 2000)) > 0);
    }
}