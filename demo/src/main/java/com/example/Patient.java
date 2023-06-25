package com.example;

public class Patient {

    private String patient_id;
    private String name;
    private String ic;
    private int age;
    private char gender;
    private String contact_info;
    private String department;

    public Patient(String patient_id, String name, String ic, int age, char gender, String contact_info, String department) {
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
    
    public Patient() {
    }

    public String getPatient_id() {
        return patient_id;
    }

    public String getName() {
        return name;
    }

    public String getIc() {
        return ic;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getContact_info() {
        return contact_info;
    }

    public String getDepartment() {
        return department;
    }

    public int validationPatient(String name, String ic, char gender, String contact, String department) {
        // Validate name
        if (name == null || name.isEmpty() || !name.matches("^[A-Z][a-zA-Z '.-]*[A-Za-z][^-]$")) {
            return 0;
        }

        // Validate Malaysia IC
        if (ic == null || !ic.matches("^\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])\\d{6}$")) {
            return 0;
        }

        // Validate gender
        if (gender == '\u0000' || (!Character.valueOf(gender).equals('M') && !Character.valueOf(gender).equals('F'))) {
            return 0;
        }

        // Validate Malaysia contact
        if (contact == null || !contact.matches("^(\\+?6?01)[02-46-9]-*[0-9]{7}$|^(\\+?6?01)[1]-*[0-9]{8}$")){
            return 0;
        }

        // Validate department
        if (department == null || department.isEmpty()) {
            return 0;
        }

        return 1;
    }
}