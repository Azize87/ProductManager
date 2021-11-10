package ru.netology.domain;

public class Smartphone extends Product {
    private String manufacturer;


    public Smartphone(int id, String tatle, int price, String manufacturer) {
        super(id, tatle, price);
        this.manufacturer = manufacturer;

    }

    public String getManufacturer() {
        return manufacturer;
    }

}
