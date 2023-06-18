package com.example;

import java.util.Date;

public class Analysis {
    
    private String analysis_id;
    private Date analysis_date;

    public Analysis(String analysis_id, Date analysis_date){
        this.analysis_id = analysis_id;
        this.analysis_date = analysis_date;
    }

    public String getAnalysis_id(){
        return analysis_id;
    }

    public Date getAnalysis_date() {
        return analysis_date;
    }
}
