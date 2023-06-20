package com.example;

public class PatientHistory{

    private String pat_id;
    private int ward_no;
    private String movement_means;
    private String directed_by;
    private String major_complications;
    private String results;
    private String special_comments;
    private String history_id;

    public PatientHistory(String history_id, String pat_id, int ward_no, String movement_means, String directed_by, String major_complications, String results, String special_comments) {
        this.pat_id = pat_id;
        this.ward_no = ward_no;
        this.movement_means = movement_means;
        this.directed_by = directed_by;
        this.major_complications = major_complications;
        this.results = results;
        this.special_comments = special_comments;
        this.history_id = history_id;
    }

    public String getPat_id() {
        return pat_id;
    }

    public int getWard_no() {
        return ward_no;
    }

    public String getMovement_means() {
        return movement_means;
    }

    public String getDirected_by() {
        return directed_by;
    }

    public String getMajor_complications() {
        return major_complications;
    }

    public String getResults() {
        return results;
    }

    public String getSpecial_comments() {
        return special_comments;
    }

    public String getHistory_id() {
        return history_id;
    }
    
}
