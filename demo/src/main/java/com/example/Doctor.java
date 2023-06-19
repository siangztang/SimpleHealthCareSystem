package com.example;

public class Doctor {
    
    private String doctor_id;
    private String doctor_name;
    private String doctor_specialization;
    private String qualification;
    private long contact_info;

    public Doctor(String doctor_id, String doctor_name, String doctor_specialization, String qualification, long contact_info){
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.doctor_specialization = doctor_specialization;
        this.qualification = qualification;
        this.contact_info = contact_info;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public String getDoctor_specialization() {
        return doctor_specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public long getContact_info() {
        return contact_info;
    }
}
