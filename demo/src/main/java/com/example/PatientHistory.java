package com.example;

public class PatientHistory extends Patient{
    private int ward_no;
    private String movement_means;
    private String directed_by;
    private String major_complications;
    private String treatment_results;
    private String speacial_comments;
    private String history_id;

    public PatientHistory(String pat_id, int ward_no, String movement_means, String directed_by, String major_complications, String treatment_results, String speacial_comments, String history_id) {
        super(pat_id);
        this.ward_no = ward_no;
        this.movement_means = movement_means;
        this.directed_by = directed_by;
        this.major_complications = major_complications;
        this.treatment_results = treatment_results;
        this.speacial_comments = speacial_comments;
        this.history_id = history_id;
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

    public String getTreatment_results() {
        return treatment_results;
    }

    public String getSpeacial_comments() {
        return speacial_comments;
    }

    public String getHistory_id() {
        return history_id;
    }
    
}
