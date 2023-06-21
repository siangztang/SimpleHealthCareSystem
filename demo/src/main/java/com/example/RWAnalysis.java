package com.example;

public class RWAnalysis extends Analysis{
    
    private String rw_result;
    private String adis_date;
    private String aids_result;

    public RWAnalysis(String analysis_id, String analysis_date, String rw_result, String adis_date, String aids_result){
        super(analysis_id, analysis_date);
        this.rw_result = rw_result;
        this.adis_date = adis_date;
        this.aids_result = aids_result;
    }

    // positive or negative
    public String getRw_result() {
        return rw_result;
    }

    // date
    public String getAdis_date() {
        return adis_date;
    }

    // postive or false_positive or negative
    public String getAids_result() {
        return aids_result;
    }
}
