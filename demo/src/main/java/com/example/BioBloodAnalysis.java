package com.example;

public class BioBloodAnalysis extends Analysis{
    
    private double urea;
    private double createnine;
    private double sugar;
    private double biluribin;
    private double direct_biluribin;
    private double AST;
    private double ALT;
    private double cholesterol;
    private double triglycerides;
    private double HDL;
    private double LDL;
    private double alkaline_phosphatase;

    public BioBloodAnalysis(String analysis_id, String analysis_date, double urea, double createnine, double sugar, double biluribin, double direct_biluribin, double AST, double ALT, double cholesterol, double triglycerides, double HDL, double LDL, double alkaline_phosphatase){
        super(analysis_id, analysis_date);
        this.urea = urea;
        this.createnine = createnine;
        this.sugar = sugar;
        this.biluribin = biluribin;
        this.direct_biluribin = direct_biluribin;
        this.AST = AST;
        this.ALT = ALT;
        this.cholesterol = cholesterol;
        this.triglycerides = triglycerides;
        this.HDL = HDL;
        this.LDL = LDL;
        this.alkaline_phosphatase = alkaline_phosphatase;
    }

    public double getUrea(){
        return urea;
    }

    public double getCreatenine(){
        return createnine;
    }

    public double getSugar(){
        return sugar;
    }

    public double getBiluribin(){
        return biluribin;
    }

    public double getDirect_biluribin(){
        return direct_biluribin;
    }

    public double getAST(){
        return AST;
    }

    public double getALT(){
        return ALT;
    }

    public double getCholesterol(){
        return cholesterol;
    }

    public double getTriglycerides(){
        return triglycerides;
    }

    public double getHDL(){
        return HDL;
    }

    public double getLDL(){
        return LDL;
    }

    public double getAlkaline_phosphatase(){
        return alkaline_phosphatase;
    }
}
