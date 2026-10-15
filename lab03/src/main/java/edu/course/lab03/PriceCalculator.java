package edu.course.lab03;

public class PriceCalculator {
    private final DiscountPolicy policy;

    // Внедрение зависимости через конструктор
    public PriceCalculator(DiscountPolicy policy) {
        this.policy = policy;
    }

    public double calculate(double price) {
        return policy.apply(price);
    }
}