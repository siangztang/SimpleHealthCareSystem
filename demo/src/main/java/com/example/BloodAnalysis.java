package com.example;

public class BloodAnalysis extends Analysis{
    
    private double red_cells;
    private double haemoglobin;
    private String color;
    private String parasites;
    private int white_cells;
    private int stab_neuthrophil;
    private int lymphocytes;
    private int ESR;

    public BloodAnalysis(String analysis_id, String analysis_date, String treatment_course_id, double red_cells, double haemoglobin, String color, String parasites, int white_cells, int stab_neuthrophil, int lymphocytes, int ESR){
        super(analysis_id, analysis_date, treatment_course_id);
        this.red_cells = red_cells;
        this.haemoglobin = haemoglobin;
        this.color = color;
        this.parasites = parasites;
        this.white_cells = white_cells;
        this.stab_neuthrophil = stab_neuthrophil;
        this.lymphocytes = lymphocytes;
        this.ESR = ESR;
    }

    // Normal range: Approximately 4.5-5.5 million cells/mcL (male), 4.0-5.0 million cells/mcL (female)
    public double getRed_cells() {
        return red_cells;
    }

    // Normal range: Approximately 13.5-17.5 g/dL (male), 12.0-15.5 g/dL (female)
    public double getHaemoglobin() {
        return haemoglobin;
    }

    // such as anemia or infections
    public String getColor() {
        return color;
    }

    // Postive or Negative
    public String getParasites() {
        return parasites;
    }

    // Normal range: Approximately 5,000-11,000 cells/mcL
    public int getWhite_cells() {
        return white_cells;
    }

    // 0 - 3%
    public int getStab_neuthrophil() {
        return stab_neuthrophil;
    }

    // Normal range: Approximately 20-40% of the total white blood cell count
    public int getLymphocytes() {
        return lymphocytes;
    }

    // Normal range: Varies with age and sex, but typically below 20 mm/hr for men and below 30 mm/hr for women
    public int getESR() {
        return ESR;
    }
    
}
