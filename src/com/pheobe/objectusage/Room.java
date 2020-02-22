package com.pheobe.objectusage;

public class Room {
    private Building building;
    private int roomNumber;
    private int roomCapacity;

    public Room(Building building, int room, int capacity) {
        this.building = building;
        this.roomNumber = room;
        this.roomCapacity = capacity;
    }

    public Building getBuilding() {
        return building;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int capacity) {
        this.roomCapacity = capacity;
    }

    @Override
    public String toString() {
        return building.getBuildingName() + " building, Room " + roomNumber + "(seats " + roomCapacity + ")";
    }
}
