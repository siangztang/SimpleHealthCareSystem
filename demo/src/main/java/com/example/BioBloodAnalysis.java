package com.example;

public class BioBloodAnalysis extends Analysis{
    
    private double urea;
    private double createnine;
    private double sigar;
    private double biluribin;
    private double direct_biluribin;
    private double AST;
    private double ALT;

    public BioBloodAnalysis(String analysis_id, String analysis_date, double urea, double createnine, double sigar, double biluribin, double direct_biluribin, double AST, double ALT){
        super(analysis_id, analysis_date);
        this.urea = urea;
        this.createnine = createnine;
        this.sigar = sigar;
        this.biluribin = biluribin;
        this.direct_biluribin = direct_biluribin;
        this.AST = AST;
        this.ALT = ALT;
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
}
