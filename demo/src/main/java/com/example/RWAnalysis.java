package com.example;

public class RWAnalysis extends Analysis{
    
    private String rw_result;
    private String adis_date;
    private String aids_result;
    private String syphilis_date;
    private String syphilis_result;
    private String hepatitis_date;
    private String hepatitis_result;

    public RWAnalysis(String analysis_id, String analysis_date, String rw_result, String adis_date, String aids_result, String syphilis_date, String syphilis_result, String hepatitis_date, String hepatitis_result){
        super(analysis_id, analysis_date);
        this.rw_result = rw_result;
        this.adis_date = adis_date;
        this.aids_result = aids_result;
        this.syphilis_date = syphilis_date;
        this.syphilis_result = syphilis_result;
        this.hepatitis_date = hepatitis_date;
        this.hepatitis_result = hepatitis_result;
    }

    public String getRw_result() {
        return rw_result;
    }

    public String getAdis_date() {
        return adis_date;
    }

    public String getAids_result() {
        return aids_result;
    }

    public String getSyphilis_date() {
        return syphilis_date;
    }

    public String getSyphilis_result() {
        return syphilis_result;
    }

    public String getHepatitis_date() {
        return hepatitis_date;
    }

    public String getHepatitis_result() {
        return hepatitis_result;
    }
}
