package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import static org.junit.jupiter.api.Assertions.assertEquals;


class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForPrimeNumber() {
        
        boolean result = CourseToolkit.isPrime(5);
        assertTrue(result);

    }

    @Test
    void returnsFalseForCompositeNumber() {
        boolean result = CourseToolkit.isPrime(4);
        assertFalse(result);
    }

    @Test void returnsTrueForPalindrome() {
        boolean result = CourseToolkit.isPalindrome("radar");
        assertTrue(result);
    }

    @Test void returnsFalseForNonPalindrome() {
        boolean result = CourseToolkit.isPalindrome("java");
        assertFalse(result);
    }


    @Test
    void calculatesAverageCorrectly() {
        double result = CourseToolkit.average(new int[]{1, 2, 3});
        assertEquals(2.0, result);
    }
}
