package com.example;

public class BioBloodAnalysis extends Analysis{
    
    private int urea;
    private double createnine;
    private int sugar;
    private double biluribin;
    private double direct_biluribin;
    private int AST;
    private int ALT;

    public BioBloodAnalysis(String analysis_id, String analysis_date, int urea, double createnine, int sugar, double biluribin, double direct_biluribin, int AST, int ALT){
        super(analysis_id, analysis_date);
        this.urea = urea;
        this.createnine = createnine;
        this.sugar = sugar;
        this.biluribin = biluribin;
        this.direct_biluribin = direct_biluribin;
        this.AST = AST;
        this.ALT = ALT;
    }
    
    // Normal range: Approximately 7-25 mg/dL
    public int getUrea(){
        return urea;
    }

    // Normal range: Approximately 0.6-1.2 mg/dL for females and 0.7-1.3 mg/dL for males
    public double getCreatenine(){
        return createnine;
    }

    // 70 and 100 mg/dL
    public int getSugar(){
        return sugar;
    }

    // Normal range: Total bilirubin: Approximately 0.1-1.2 mg/dL; Direct bilirubin: Approximately 0.1-0.3 mg/dL
    public double getBiluribin(){
        return biluribin;
    }

    public double getDirect_biluribin(){
        return direct_biluribin;
    }

    // Normal range: Typically below 40 IU/L
    public int getAST(){
        return AST;
    }

    // Normal range: Typically below 40 IU/L
    public int getALT(){
        return ALT;
    }
}
