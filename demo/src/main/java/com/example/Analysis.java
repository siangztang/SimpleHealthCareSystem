package com.example;

public class Analysis {
    
    private String analysis_id;
    private String analysis_date;

    public Analysis(String analysis_id, String analysis_date){
        this.analysis_id = analysis_id;
        this.analysis_date = analysis_date;
    }

    public String getAnalysis_id(){
        return analysis_id;
    }

    public String getAnalysis_date() {
        return analysis_date;
    }
}
