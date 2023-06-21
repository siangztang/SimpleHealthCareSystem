package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class BioBloodAnalysis extends Analysis{
    
    private double urea;
    private double createnine;
    private double sigar;
    private double biluribin;
    private double direct_biluribin;
    private double AST;
    private double ALT;
    private double cholesterol;
    private double triglycerides;
    private double HDL;
    private double LDL;
    private double alkaline_phosphatase;

    public BioBloodAnalysis(String analysis_id, String analysis_date, double urea, double createnine, double sigar, double biluribin, double direct_biluribin, double AST, double ALT, double cholesterol, double triglycerides, double HDL, double LDL, double alkaline_phosphatase){
        super(analysis_id, analysis_date);
        this.urea = urea;
        this.createnine = createnine;
        this.sigar = sigar;
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

    public double getSigar(){
        return sigar;
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

    public int validationBioBloodAnalysis(String analysis_date, double urea, double createnine, double sigar, double biluribin, double direct_biluribin, double AST, double ALT, double cholesterol, double triglycerides, double HDL, double LDL, double alkaline_phosphatase){
        
        try {
            LocalDate.parse(analysis_date);
        } catch (DateTimeParseException e) {
            return 0;
        }

        if (urea < 7 || urea > 25) {
            return 0;
        }

        if (createnine < 0.6 || createnine > 1.2) {
            return 0;
        }

        if (sigar < 0.2 || sigar > 1.2) {
            return 0;
        }

        if (biluribin < 0.1 || biluribin > 1.2) {
            return 0;
        }

        if (direct_biluribin < 0.1 || direct_biluribin > 0.3) {
            return 0;
        }

        if (AST < 10.0 || AST > 40.0) {
            return 0;
        }

        if (ALT < 7.0 || ALT > 56.0) {
            return 0;
        }

        if (cholesterol < 125.0 || cholesterol > 200.0) {
            return 0;
        }

        if (triglycerides < 50.0 || triglycerides > 150.0) {
            return 0;
        }

        if (HDL < 40.0) {
            return 0;
        }

        if (LDL < 70.0 || LDL > 130.0) {
            return 0;
        }

        if (alkaline_phosphatase < 40.0 || alkaline_phosphatase > 120.0) {
            return 0;
        }

        return 1;
    }
}
