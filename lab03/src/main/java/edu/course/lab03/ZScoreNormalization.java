package edu.course.lab03;

public class ZScoreNormalization implements NormalizationStrategy {
    @Override
    public double[] normalize(double[] values) {
        if (values.length == 0) return new double[0];

        
        double sum = 0;
        for (double v : values) {
            sum += v;
        }
        double mean = sum / values.length;

        double varianceSum = 0;
        for (double v : values) {
            varianceSum += Math.pow(v - mean, 2);
        }
        double variance = varianceSum / values.length;
        double stdDev = Math.sqrt(variance);

        double[] result = new double[values.length];
        
        
        if (stdDev == 0) {
            for (int i = 0; i < values.length; i++) {
                result[i] = 0.0; 
            }
            return result;
        }

        for (int i = 0; i < values.length; i++) {
            result[i] = (values[i] - mean) / stdDev;
        }
        return result;
    }
}