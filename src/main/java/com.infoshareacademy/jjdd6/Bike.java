package com.infoshareacademy.jjdd6;

import javax.xml.bind.annotation.XmlAttribute;

public class Bike {
    private int number;
    private int bikeType;
    private String lockType;
    private int active;
    private String state;
    private int electricLock;
    private String boardComputer;
    private int pedelecBattery;

    public Bike() {
    }

    public Bike(int number, int bikeType) {
        this.number = number;
        this.bikeType = bikeType;
    }

    @XmlAttribute(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @XmlAttribute(name = "bike_type")
    public int getBikeType() {
        return bikeType;
    }

    public void setBikeType(int bikeType) {
        this.bikeType = bikeType;
    }

    public String getLockType() {
        return lockType;
    }

    public void setlockType(String lockType) {
        this.lockType = lockType;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getElectricLock() {
        return electricLock;
    }

    public void setElectricLock(int electricLock) {
        this.electricLock = electricLock;
    }

    public String getBoardComputer() {
        return boardComputer;
    }

    public void setBoardComputer(String boardComputer) {
        this.boardComputer = boardComputer;
    }

    public int getPedelecBattery() {
        return pedelecBattery;
    }

    public void setPedelecBattery(int pedelecBattery) {
        this.pedelecBattery = pedelecBattery;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "number=" + number +
                ", bikeType=" + bikeType +
                '}';
    }
}
