package com.example;

public class Diagnosis{

    private String diagnosis_id;
    private String diagnosis_name;
    private String diagnosis_date;
    private String doctor_name;
    private String treatment_course_id;

    public Diagnosis(String diagnosis_id, String diagnosis_name, String diagnosis_date, String doctor_name, String treatment_course_id) {
        this.treatment_course_id = treatment_course_id;
        this.diagnosis_id = diagnosis_id;
        this.diagnosis_name = diagnosis_name;
        this.diagnosis_date = diagnosis_date;
        this.doctor_name = doctor_name;
    }

    public String getDiagnosis_id() {
        return diagnosis_id;
    }

    public String getDiagnosis_name() {
        return diagnosis_name;
    }

    public String getDiagnosis_date() {
        return diagnosis_date;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public String getTreatment_course_id() {
        return treatment_course_id;
    }

    public int validationDiagnosis(){
        return 1;
    }
    
}