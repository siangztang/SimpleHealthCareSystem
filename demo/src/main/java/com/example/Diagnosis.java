package com.example;

import java.util.Date;

public class Diagnosis extends TreatmentCourse{

    private String diagnosis_id;
    private String diagnosis_name;
    private Date diagnosis_date;
    private String doctor_name;
    private String treatment_plan;

    public Diagnosis(String diagnosis_id, String diagnosis_name, Date diagnosis_date, String doctor_name, String treatment_plan, String treatment_course_id) {
        super(treatment_course_id);
        this.diagnosis_id = diagnosis_id;
        this.diagnosis_name = diagnosis_name;
        this.diagnosis_date = diagnosis_date;
        this.doctor_name = doctor_name;
        this.treatment_plan = treatment_plan;
    }

    public String getDiagnosis_id() {
        return diagnosis_id;
    }

    public String getDiagnosis_name() {
        return diagnosis_name;
    }

    public Date getDiagnosis_date() {
        return diagnosis_date;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public String getTreatment_plan() {
        return treatment_plan;
    }
    
}