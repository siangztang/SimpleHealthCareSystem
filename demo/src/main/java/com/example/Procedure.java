package com.example;

public class Procedure{
    
    private String procedure_id;
    private String type;
    private String procedure_date;
    private String procedure_time;
    private String treatment_course_id;
    private String[] medicine_list;


    public Procedure(String procedure_id, String type, String procedure_date, String procedure_time, String treatment_course_id, String[] medicine_list) {
        this.procedure_id = procedure_id;
        this.type = type;
        this.procedure_date = procedure_date;
        this.procedure_time = procedure_time;
        this.treatment_course_id = treatment_course_id;
        this.medicine_list = medicine_list;
    }

    public String getProcedure_id() {
        return procedure_id;
    }

    public String getType() {
        return type;
    }

    public String getProcedure_date() {
        return procedure_date;
    }

    public String getProcedure_time() {
        return procedure_time;
    }

    public String getTreatment_course_id() {
        return treatment_course_id;
    }

    public String[] getMedicine_list() {
        return medicine_list;
    }
}
