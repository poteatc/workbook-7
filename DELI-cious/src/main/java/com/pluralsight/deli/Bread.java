package com.pluralsight.deli;

public class Bread {
    private BreadType breadType;
    private BreadSize breadSize;
    private boolean isToasted;

    public Bread(BreadType breadType, BreadSize breadSize, boolean isToasted) {
        this.breadType = breadType;
        this.breadSize = breadSize;
        this.isToasted = isToasted;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public BreadSize getBreadSize() {
        return breadSize;
    }

    public void setBreadSize(BreadSize breadSize) {
        this.breadSize = breadSize;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }
}
