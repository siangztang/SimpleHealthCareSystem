package com.example;

public class Doctor {
    
    private String doctor_id;
    private String doctor_name;
    private String doctor_specialization;
    private String qualification;
    private String contact_info;

    public Doctor(String doctor_id, String doctor_name, String doctor_specialization, String qualification, String contact_info){
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.doctor_specialization = doctor_specialization;
        this.qualification = qualification;
        this.contact_info = contact_info;
    }

    public Doctor() {
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

    public String getContact_info() {
        return contact_info;
    }

    public int validationDoctor(String doctor_name, String doctor_specialization, String qualification, String contact_info){

        // Validate doctor name
        if (doctor_name == null || doctor_name.isEmpty() || !doctor_name.matches("^[A-Z][a-zA-Z '.-]*[A-Za-z][^-]$") && !(doctor_name.length() > 5)) {
            return 0;
        }

        // validate doctor specialization
        if (doctor_specialization == null || doctor_specialization.isEmpty() | !doctor_specialization.matches("^[a-zA-z]+([\\s][a-zA-Z]+)*$") && !(doctor_specialization.length() > 5)) {
            return 0;
        }

        // validate doctor qualification
        if (qualification == null || qualification.isEmpty() | !qualification.matches("^[a-zA-z]+([\\s][a-zA-Z]+)*$") && !(qualification.length() > 3)) {
            return 0;
        }

        // validate doctor contact info
        if (contact_info == null || !contact_info.matches("^(\\+?6?01)[02-46-9]-*[0-9]{7}$|^(\\+?6?01)[1]-*[0-9]{8}$")){
            return 0;
        }

        return 1;
    } 
}
