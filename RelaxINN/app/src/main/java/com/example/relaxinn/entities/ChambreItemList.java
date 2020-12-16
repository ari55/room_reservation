package com.example.relaxinn.entities;

public class ChambreItemList {

    int id, id_hotel, single_bed_number, double_bed_number, smoker;
    double price;

    String txt_info;

   
    public ChambreItemList(int id, String description, int id_hotel, int id_view, int single_bed_number, int double_bed_number, double price, int smoker) {
        this.id = id;
        this.id_hotel = id_hotel;
        this.single_bed_number = single_bed_number;
        this.double_bed_number = double_bed_number;
        this.smoker = smoker;
        this.price = price;
        this.txt_info = description;
    }

    public ChambreItemList(int id, int id_hotel, int single_bed_number, int double_bed_number, int smoker, double price, String txt_Chambre) {
        this.id = id;
        this.id_hotel = id_hotel;
        this.single_bed_number = single_bed_number;
        this.double_bed_number = double_bed_number;
        this.smoker = smoker;
        this.price = price;
        this.txt_info = txt_Chambre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getSingle_bed_number() {
        return single_bed_number;
    }

    public void setSingle_bed_number(int single_bed_number) {
        this.single_bed_number = single_bed_number;
    }

    public int getDouble_bed_number() {
        return double_bed_number;
    }

    public void setDouble_bed_number(int double_bed_number) {
        this.double_bed_number = double_bed_number;
    }

    public int getSmoker() {
        return smoker;
    }

    public void setSmoker(int smoker) {
        this.smoker = smoker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTxt_info() {
        return txt_info;
    }

    public void setTxt_info(String txt_info) {
        this.txt_info = txt_info;
    }

    public ChambreItemList() {
    }
}
