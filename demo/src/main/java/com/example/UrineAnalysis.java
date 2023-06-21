package com.example;

public class UrineAnalysis extends Analysis{

    private String color;
    private double reaction;
    private String transparency;
    private double density;
    
    public UrineAnalysis(String analysis_id, String analysis_date, String color, double reaction, String transparency, double density){
        super(analysis_id, analysis_date);
        this.color = color;
        this.reaction = reaction;
        this.transparency = transparency;
        this.density = density;
    }

    // Normal urine color ranges from pale yellow to amber.
    public String getColor(){
        return color;
    }

    // Normal range: Approximately 4.6-8.0
    public double getReaction(){
        return reaction;
    }

    // Normal range: Urine is typically clear. Cloudiness may indicate the presence of substances such as bacteria, mucus, or crystals.
    public String getTransparency(){
        return transparency;
    }

    // Normal range: Approximately 1.005-1.030
    public double getDensity(){
        return density;
    }
}
