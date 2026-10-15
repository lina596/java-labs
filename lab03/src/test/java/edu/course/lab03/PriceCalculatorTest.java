package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    @Test
    void testNoDiscount() {
        PriceCalculator calc = new PriceCalculator(new NoDiscount());
        assertEquals(100.0, calc.calculate(100.0), 0.001);
    }

    @Test
    void testPercentDiscount() {
        PriceCalculator calc = new PriceCalculator(new PercentDiscount(20));
        // Скидка 20% от 100 должна дать 80
        assertEquals(80.0, calc.calculate(100.0), 0.001);
    }

    @Test
    void testNegativePriceThrowsException() {
        PriceCalculator calc = new PriceCalculator(new NoDiscount());
        assertThrows(IllegalArgumentException.class, () -> calc.calculate(-10.0));
    }

    @Test
    void testPolicyReplacement() {
        // Тест замены политики (главная цель лабы)
        DiscountPolicy noDisc = new NoDiscount();
        DiscountPolicy percentDisc = new PercentDiscount(10);
        
        // Один и тот же товар (50.0), но с разными стратегиями скидок
        PriceCalculator calc1 = new PriceCalculator(noDisc);
        assertEquals(50.0, calc1.calculate(50.0), 0.001);
        
        PriceCalculator calc2 = new PriceCalculator(percentDisc);
        assertEquals(45.0, calc2.calculate(50.0), 0.001);
    }
}