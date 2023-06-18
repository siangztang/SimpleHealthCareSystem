package com.example;

import java.util.Date;

public class TreatmentCourse extends PatientHistory {

    private String treatment_course_id;
    private Date start_date;
    private Date end_date;

    public TreatmentCourse(String history_id, String treatment_course_id, Date start_date, Date end_date) {
        super(history_id);
        this.treatment_course_id = treatment_course_id;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public TreatmentCourse(String treatment_course_id) {
        super("");
        this.treatment_course_id = treatment_course_id;
    }

    public String getTreatment_course_id() {
        return treatment_course_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }
}
