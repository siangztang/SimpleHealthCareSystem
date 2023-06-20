package com.example;

import java.util.Date;

public class Procedure{
    
    private String procedure_id;
    private String type;
    private Date procedure_date;
    private Date procedure_time;
    private String treatment_course_id;


    public Procedure(String procedure_id, String type, Date procedure_date, Date procedure_time, String treatment_course_id) {
        
        this.procedure_id = procedure_id;
        this.type = type;
        this.procedure_date = procedure_date;
        this.procedure_time = procedure_time;
        this.treatment_course_id = treatment_course_id;
    }

    public String getProcedure_id() {
        return procedure_id;
    }

    public String getType() {
        return type;
    }

    public Date getProcedure_date() {
        return procedure_date;
    }

    public Date getProcedure_time() {
        return procedure_time;
    }

    public String getTreatment_course_id() {
        return treatment_course_id;
    }
}
