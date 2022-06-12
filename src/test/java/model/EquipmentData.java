package model;

public class EquipmentData {

    private String bikeName = "My bike";
    private String bikeBrand = "Giant";
    private String bikeModel = "Classic";
    private int bikeCost = 1000;
    private double bikeStartingDistance = 12.66;
    private String distanceType = "km";

    public String getBikeName() {
        return bikeName;
    }

    public String getBikeBrand() {
        return bikeBrand;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public String getBikeCost() {
        return String.valueOf(bikeCost);
    }

    public String getBikeStartingDistance() {
        return String.valueOf(bikeStartingDistance);
    }

    public String getDistanceType() {
        return distanceType;
    }
}
