package com.example;

public class UrineAnalysis extends Analysis{

    private String color;
    private String reaction;
    private String transparency;
    private double density;
    private String protein;
    private String glucose;
    private String ketones;
    private String nitrites;
    private String leukocytes;
    
    public UrineAnalysis(String analysis_id, String analysis_date, String color, String reaction, String transparency, double density, String protein, String glucose, String ketones, String nitrites, String leukocytes){
        super(analysis_id, analysis_date);
        this.color = color;
        this.reaction = reaction;
        this.transparency = transparency;
        this.density = density;
        this.protein = protein;
        this.glucose = glucose;
        this.ketones = ketones;
        this.nitrites = nitrites;
        this.leukocytes = leukocytes;
    }

    public String getColor(){
        return color;
    }

    public String getReaction(){
        return reaction;
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

    public String getNitrites(){
        return nitrites;
    }

    public String getLeukocytes(){
        return leukocytes;
    }
}
