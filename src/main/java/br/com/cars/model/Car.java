package br.com.cars.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.List;
@MongoEntity(collection = "cars")
public class Car extends PanacheMongoEntity {
    private String model;
    private String plateNumber;
    private int year;
    private boolean isAutomatic;
    private String carType;
    private String color;
    private String fuelEfficiency;
    private double dailyRate;
    private List<String> images;
    private List<String> features;

    /* List<Reserves> reserves; */

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFuelEfficiency(String fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String getModel() {
        return model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getYear() {
        return year;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public String getCarType() {
        return carType;
    }

    public String getColor() {
        return color;
    }

    public String getFuelEfficiency() {
        return fuelEfficiency;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public List<String> getImages() {
        return images;
    }

    public List<String> getFeatures() {
        return features;
    }


}
