package com.finalproject.carrentalsv2;

public class CarData {
    int Carimage;
    String CarName,CarYear,CarDescription;

    public int getCarimage() {
        return Carimage;
    }

    public void setCarimage(int carimage) {
        this.Carimage = carimage;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getCarYear() {
        return CarYear;
    }

    public void setCarYear(String carYear) {
        CarYear = carYear;
    }

    public String getCarDescription() {
        return CarDescription;
    }

    public void setCarDescription(String carDescription) {
        CarDescription = carDescription;
    }

    public CarData(int carimage, String carName, String carYear, String carDescription) {
        this.Carimage = carimage;
        CarName = carName;
        CarYear = carYear;
        CarDescription = carDescription;
    }


}

