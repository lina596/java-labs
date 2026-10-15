package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataSampleTest {

    @Test
    void testValidDataSampleCreation() {
        double[] features = {1.5, 2.0, 2.5};
        DataSample sample = new DataSample("img_01", "cat", features);
        
        // По правилам свежесозданный объект имеет статус NEW, 
        // значит метод isReady() должен возвращать false
        assertFalse(sample.isReady());
    }

    @Test
    void testChangeStatusAndIsReady() {
        DataSample sample = new DataSample("img_02", "dog", new double[]{1.0});
        
        assertFalse(sample.isReady()); // Сначала не готов
        
        sample.changeStatus(SampleStatus.READY);
        assertTrue(sample.isReady());  // Теперь готов
    }

    @Test
    void testCalculateAverageFeature() {
        // Среднее между 10, 20 и 30 — это 20
        DataSample sample = new DataSample("text_01", "spam", new double[]{10.0, 20.0, 30.0});
        assertEquals(20.0, sample.calculateAverageFeature(), 0.0001);
    }

    @Test
    void testEncapsulationOfFeatures() {
        double[] originalFeatures = {1.0, 2.0};
        DataSample sample = new DataSample("audio_01", "voice", originalFeatures);
        
        // Пытаемся испортить исходный массив снаружи
        originalFeatures[0] = 999.0;
        assertNotEquals(999.0, sample.getFeatures()[0], "Конструктор должен копировать массив!");

        // Пытаемся испортить массив через геттер
        double[] returnedFeatures = sample.getFeatures();
        returnedFeatures[0] = 888.0;
        assertNotEquals(888.0, sample.getFeatures()[0], "Геттер должен возвращать копию массива!");
    }

    @Test
    void testInvalidConstructorArguments() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("", "label", new double[]{1.0}));
        assertThrows(IllegalArgumentException.class, () -> new DataSample("id", null, new double[]{1.0}));
        assertThrows(IllegalArgumentException.class, () -> new DataSample("id", "label", null));
    }

    @Test
    void testNormalizationImmutability() {
        double[] features = {5.0, 10.0, 20.0};
        DataSample original = new DataSample("norm_01", "test", features);
        
        DataSample normalized = original.normalize();
        
        assertEquals(20.0, original.getFeatures()[2], 0.0001);
        
        // Проверяем, что у нового объекта признаки поделились на максимум (20.0)
        assertEquals(1.0, normalized.getFeatures()[2], 0.0001); // 20.0 / 20.0 = 1.0
        assertEquals(0.5, normalized.getFeatures()[1], 0.0001); // 10.0 / 20.0 = 0.5
    }

}
