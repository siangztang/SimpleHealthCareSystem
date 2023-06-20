package com.example;

import java.util.Date;

public class UrineAnalysis extends Analysis{

    private String color;
    private String transparency;
    private double density;
    private String protein;
    private String glucose;
    private String ketones;
    private String nitriles;
    private String leukocytes;
    
    public UrineAnalysis(String analysis_id, Date analysis_date, String color, String transparency, double density, String protein, String glucose, String ketones, String nitriles, String leukocytes){
        super(analysis_id, analysis_date);
        this.color = color;
        this.transparency = transparency;
        this.density = density;
        this.protein = protein;
        this.glucose = glucose;
        this.ketones = ketones;
        this.nitriles = nitriles;
        this.leukocytes = leukocytes;
    }

    public String getColor(){
        return color;
    }

    public String getTransparency(){
        return transparency;
    }

    public double getDensity(){
        return density;
    }

    public String getProtein(){
        return protein;
    }

    public String getGlucose(){
        return glucose;
    }

    public String getKetones(){
        return ketones;
    }

    public String getNitriles(){
        return nitriles;
    }

    public String getLeukocytes(){
        return leukocytes;
    }
}
