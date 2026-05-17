package financemanager.model;

import financemanager.enums.AssetType;

public class Asset {
    private static int nextId = 1;
    private int id;
    private AssetType type;
    private String description;
    private double value;

    public Asset(AssetType type, String description, double value) {
        this.id = nextId++;
        this.type = type;
        this.description = description;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AssetType getType() {
        return type;
    }

    public void setType(AssetType type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
