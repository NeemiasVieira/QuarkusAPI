package br.com.cars.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;
@Schema(name = "Create Car", description = "DTO to create a new Car")
public class CreateCarDto {
    @NotBlank(message = "model is required")
    @Schema(example = "HB20 1.0 Turbo")
    private String model;

    @NotBlank(message = "plateNumber is required")
    @Schema(example = "FXF9F33")
    private String plateNumber;

    @Min(value = 1900, message = "Year should be greater than or equal to 1900")
    @Schema(example = "2023")
    private int year;

    @NotNull(message = "isAutomatic is required")
    @Schema(example = "true")
    private boolean isAutomatic;

    @NotBlank(message = "carType is required")
    @Schema(example = "Sedan")
    private String carType;

    @NotBlank(message = "color is required")
    @Schema(example = "Black")
    private String color;

    @NotNull(message = "fuelEfficiency is required")
    @Schema(example = "50")
    private String fuelEfficiency;

    @NotNull(message = "dailyRate is required")
    @Min(value = 40, message = "dailyRate should be greater than or equal to 40")
    @Schema(example = "99.90")
    private double dailyRate;

    @NotEmpty(message = "images is required")
    @Schema(example = "[\n" +
            "      \"https://www.localiza.com/brasil-site/geral/Frota/EQBL.png\"\n" +
            "    ]")
    private List<String> images;

    @NotEmpty(message = "features is required")
    @Schema(example = "[\"Air Conditioning\", \"Power Steering\", \"Touchscreen Display\"]")
    private List<String> features;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(String fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }


}
