package com.example;

public class Analysis {
    
    private String analysis_id;
    private String analysis_date;
    private String treatment_course_id;


    public Analysis(String analysis_id, String analysis_date, String treatment_course_id){
        this.analysis_id = analysis_id;
        this.analysis_date = analysis_date;
        this.treatment_course_id = treatment_course_id;
    }


    public String getAnalysis_id(){
        return analysis_id;
    }

    public String getAnalysis_date() {
        return analysis_date;
    }

    public String getTreatment_course_id() {
        return treatment_course_id;
    }

}
