package com.example;

public class TreatmentCourse {

    private String history_id;
    private String treatment_course_id;
    private String start_date;
    private String end_date;

    public TreatmentCourse(String history_id, String treatment_course_id, String start_date, String end_date) {
        this.history_id = history_id;
        this.treatment_course_id = treatment_course_id;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getHistory_id() {
        return history_id;
    }

    public String getTreatment_course_id() {
        return treatment_course_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }
}