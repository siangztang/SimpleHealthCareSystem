package com.example;

public class Patient {

    private String patient_id;
    private String name;
    private long ic;
    private int age;
    private char gender;
    private long contact_info;
    private String department;



    public Patient(String patient_id, String name, long ic, int age, char gender, long contact_info, String department) {
        this.patient_id = patient_id;
        this.name = name;
        this.ic = ic;
        this.age = age;
        this.gender = gender;
        this.contact_info = contact_info;
        this.department = department;
    }

    public Patient(String patient_id) {
        this.patient_id = patient_id;
    }
    
    public String getPatient_id() {
        return patient_id;
    }

    public String getName() {
        return name;
    }

    public long getIc() {
        return ic;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public long getContact_info() {
        return contact_info;
    }

    public String getDepartment() {
        return department;
    }
}
