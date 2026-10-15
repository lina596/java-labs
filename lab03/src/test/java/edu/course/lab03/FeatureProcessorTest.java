package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FeatureProcessorTest {

    @Test
    void testMinMaxNormalization() {
        FeatureProcessor processor = new FeatureProcessor(new MinMaxNormalization());
        double[] input = {0.0, 5.0, 10.0};
        double[] expected = {0.0, 0.5, 1.0}; // Сжимаем диапазон от 0 до 10 в диапазон от 0 до 1
        assertArrayEquals(expected, processor.process(input), 0.001);
    }

    @Test
    void testMeanCenteringNormalization() {
        FeatureProcessor processor = new FeatureProcessor(new MeanCenteringNormalization());
        double[] input = {2.0, 4.0, 6.0};
        double[] expected = {-2.0, 0.0, 2.0}; // Среднее = 4.0. Вычитаем 4.0 из каждого числа
        assertArrayEquals(expected, processor.process(input), 0.001);
    }

    @Test
    void testImmutability() {
        double[] original = {10.0, 20.0, 30.0};
        FeatureProcessor processor = new FeatureProcessor(new MinMaxNormalization());
        
        processor.process(original); 
        
        assertEquals(10.0, original[0], 0.001);
        assertEquals(30.0, original[2], 0.001);
    }

    @Test
    void testStrategyReplacement() {
        // Тест, показывающий заменяемость реализаций 
        double[] data = {0.0, 10.0, 20.0};
        
        FeatureProcessor minMaxProc = new FeatureProcessor(new MinMaxNormalization());
        double[] minMaxResult = minMaxProc.process(data);
        assertEquals(0.5, minMaxResult[1], 0.001); // 10.0 превращается в 0.5
        
        FeatureProcessor meanProc = new FeatureProcessor(new MeanCenteringNormalization());
        double[] meanResult = meanProc.process(data);
        assertEquals(0.0, meanResult[1], 0.001); // Среднее 10.0, поэтому 10.0 - 10.0 = 0.0
    }
}