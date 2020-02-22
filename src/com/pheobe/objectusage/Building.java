package com.pheobe.objectusage;

public class Building {
    private String buildingName;
    private int numberFloors;
    private String campusLocation;

    public Building(String name, int floors, String campus) {
        this.buildingName = name;
        this.numberFloors = floors;
        this.campusLocation = campus;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public String getCampus() {
        return campusLocation;
    }

    public int hasMoreFloors(Building otherBuilding) {
        return numberFloors - otherBuilding.numberFloors;
    }

    @Override
    public String toString() {
        return buildingName + " building (" + numberFloors + " floors), " + campusLocation + " campus";
    }
}
