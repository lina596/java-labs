package edu.course.lab01;


public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }


    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public static boolean isPrime(int number) {
        // Базовая проверка: числа меньше 2 не являются простыми
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    } 

    public static boolean isPalindrome(String text) {
        String reversedText = new StringBuilder(text).reverse().toString();
        return text.equals(reversedText);
    } 

    public static double average(int[] numbers) {
        // Базовая проверка: если массив пустой, возвращаем 0, чтобы избежать деления на ноль
        if (numbers == null || numbers.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        
        return sum / numbers.length;
    } 
}