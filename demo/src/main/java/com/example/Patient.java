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

    public static int validationPatient(String name, String ic, String gender, String contact, String department) {
        // Validate name
        // if (name == null || name.isEmpty() || !name.matches("^[A-Z][a-zA-Z '.-]*[A-Za-z][^-]$")) {
        //     return 0;
        // }

        // Validate Malaysia IC
        // if (ic == null || !ic.matches("^\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])\\d{6}$")) {
        //     System.out.println("icfailed");
        //     return 0;
        // } else {
        //     System.out.println("icpass");
        // }

        // Validate gender
        // if (gender == null || (!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f"))) {
        //     return 0;
        // }

        // Validate Malaysia contact
        // if (contact == null || !contact.matches("^(\\+?6?01)[02-46-9]-*[0-9]{7}$|^(\\+?6?01)[1]-*[0-9]{8}$")) {
        //     return 0;
        // }

        // Validate department
        // if (department == null || department.isEmpty()) {
        //     return 0;
        // }

        return 1;
    }
}
