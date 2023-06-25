package com.example;

public class BioBloodAnalysis extends Analysis{
    
    private double createnine;
    private int sugar;
    private double biluribin;
    private double direct_biluribin;
    private int AST;
    private int ALT;
    
    public BioBloodAnalysis(double createnine, int sugar, double biluribin, double direct_biluribin, int AST, int ALT, String analysis_id, String analysis_date, String treatment_course_id){
        super(analysis_id, analysis_date, treatment_course_id);
        this.createnine = createnine;
        this.sugar = sugar;
        this.biluribin = biluribin;
        this.direct_biluribin = direct_biluribin;
        this.AST = AST;
        this.ALT = ALT;
    }
    
    public BioBloodAnalysis() {
        super("", "", "");
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

    //create if statement for validation
        public int validationBioBloodAnalysis(String analysis_date, double createnine, int sugar, double biluribin, double direct_biluribin, int AST, int ALT) {
        //Validate Analysis Date
        if (analysis_date == "" || analysis_date == null) {
             System.out.println("Analysis Date is empty");
            return 0;
        }
        if(createnine < 0.6 || createnine > 1.2){
            System.out.println(createnine);
            System.out.println("Createnine is not in range");
            return 0;
        }
        if(sugar < 70 || sugar > 100){
            System.out.println(sugar);
            System.out.println("Sugar is not in range");
            return 0;
        }
        if(biluribin < 0.1 || biluribin > 1.2){
            System.out.println(biluribin);
            System.out.println("Biluribin is not in range");
            return 0;
        }
        if(direct_biluribin < 0.1 || direct_biluribin > 0.3){
            System.out.println(direct_biluribin);
            System.out.println("Direct Biluribin is not in range");
            return 0;
        }
        if(AST < 40){
            System.out.println(AST);
            System.out.println("AST is not in range");
            return 0;
        }
        if(ALT < 40){
            System.out.println(ALT);
            System.out.println("ALT is not in range");
            return 0;
        }
            return 1;
        }

}
