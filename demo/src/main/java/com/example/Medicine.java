package com.example;

public class Medicine {
    
    private String medicine_id;
    private String medicine_name;
    private String medicine_description;
    private int medicine_amount;
    
    public Medicine(String medicine_id, String medicine_name, String medicine_description, int medicine_amount){
        this.medicine_id = medicine_id;
        this.medicine_name = medicine_name;
        this.medicine_description = medicine_description;
        this.medicine_amount = medicine_amount;
    }

    public Medicine(){

    }

    public Medicine(String medicine_name){
        this.medicine_name = medicine_name;
    }

    public String getMedicine_id() {
        return medicine_id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public String getMedicine_description() {
        return medicine_description;
    }

    public int getMedicine_amount() {
        return medicine_amount;
    }

    public int validationMedicine(String medicine_name, String medicine_description, int medicine_amount){

        if (!medicine_name.matches("^[a-zA-z]+([\\s][a-zA-Z]+)*$") && !(medicine_name.length() > 5)) {
            return 0;
        }

        if (!(medicine_description.length() > 3)) {
            return 0;
        }

        if (medicine_amount <= -1) {
            return 0;
        }

        return 1;
    }

}
