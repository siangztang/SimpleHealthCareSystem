package com.example;

public class BloodAnalysis extends Analysis{
    
    private int red_cells;
    private double haemoglobin;
    private String color;
    private boolean parasites;
    private int white_cells;
    private int stab_neuthrophil;
    private int lymphocytes;
    private int ESR;
    private int platelets;
    private double mean_corpuscular_volumn;
    private double mean_corpuscular_haemoglobin;
    private double hematocrit;

    public BloodAnalysis(String analysis_id, String analysis_date, int red_cells, double haemoglobin, String color, boolean parasites, int white_cells, int stab_neuthrophil, int lymphocytes, int ESR, int platelets, double mean_corpuscular_volumn, double mean_corpuscular_haemoglobin, double hematocrit){
        super(analysis_id, analysis_date);
        this.red_cells = red_cells;
        this.haemoglobin = haemoglobin;
        this.color = color;
        this.parasites = parasites;
        this.white_cells = white_cells;
        this.stab_neuthrophil = stab_neuthrophil;
        this.lymphocytes = lymphocytes;
        this.ESR = ESR;
        this.platelets = platelets;
        this.mean_corpuscular_volumn = mean_corpuscular_volumn;
        this.mean_corpuscular_haemoglobin = mean_corpuscular_haemoglobin;
        this.hematocrit = hematocrit;
    }

    public int getRed_cells() {
        return red_cells;
    }

    public double getHaemoglobin() {
        return haemoglobin;
    }

    public String getColor() {
        return color;
    }

    public boolean isParasites() {
        return parasites;
    }

    public int getWhite_cells() {
        return white_cells;
    }

    public int getStab_neuthrophil() {
        return stab_neuthrophil;
    }

    public int getLymphocytes() {
        return lymphocytes;
    }

    public int getESR() {
        return ESR;
    }

    public int getPlatelets() {
        return platelets;
    }

    public double getMean_corpuscular_volumn() {
        return mean_corpuscular_volumn;
    }

    public double getMean_corpuscular_haemoglobin() {
        return mean_corpuscular_haemoglobin;
    }

    public double getHematocrit() {
        return hematocrit;
    }
    
}
