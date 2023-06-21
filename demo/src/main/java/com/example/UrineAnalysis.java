package com.example;

public class UrineAnalysis extends Analysis{

    private String color;
    private String reaction;
    private String transparency;
    private double density;
    
    public UrineAnalysis(String analysis_id, String analysis_date, String color, String reaction, String transparency, double density){
        super(analysis_id, analysis_date);
        this.color = color;
        this.reaction = reaction;
        this.transparency = transparency;
        this.density = density;
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
}
