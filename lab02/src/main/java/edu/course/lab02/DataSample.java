package edu.course.lab02;

public class DataSample {
    private String id;
    private String label;
    private SampleStatus status;
    private double[] features;

    public DataSample(String id, String label, double[] features) {
        if (id == null || id.isEmpty()) {
             throw new IllegalArgumentException("id не может быть пустой"); 
            }

        if (label == null || label.isEmpty()) {
            throw new IllegalArgumentException("метка не может быть пустой");
        }

        if (features == null) {
            throw new IllegalArgumentException("массив признаков не может быть null");
        }

        this.id = id;
        this.label = label;
        this.status = SampleStatus.NEW; 
        this.features = features.clone();
    }
    
public void changeStatus(SampleStatus newStatus) {
    if (newStatus == null) {
        throw new IllegalArgumentException("Статус не может быть null");
    }
    this.status = newStatus;
}

// Операция: определить, готово ли наблюдение
public boolean isReady() {
    return this.status == SampleStatus.READY;
}

// Операция: вычислить среднее значение признаков
public double calculateAverageFeature() {
    if (this.features.length == 0) {
        return 0.0; 
    }
    
    double sum = 0.0;
    for (double feature : this.features) {
        sum += feature;
    }
    return sum / this.features.length;
}

// Требование из "Общего контракта" п.5: массив копируется при возврате
public double[] getFeatures() {
    return this.features.clone();
}
}
