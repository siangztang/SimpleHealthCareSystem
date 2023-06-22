package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RWAnalysis extends Analysis{
    
    private String rw_result;
    private String aids_date;
    private String aids_result;

    public RWAnalysis(String analysis_id, String analysis_date, String treatment_course_id, String rw_result, String aids_date, String aids_result){
        super(analysis_id, analysis_date, treatment_course_id);
        this.rw_result = rw_result;
        this.aids_date = aids_date;
        this.aids_result = aids_result;
    }

    // positive or negative
    public String getRw_result() {
        return rw_result;
    }

    // date
    public String getAids_date() {
        return aids_date;
    }

    // postive or false_positive or negative
    public String getAids_result() {
        return aids_result;
    }

    public int validationRWAnalysis(String rw_result, String aids_date, String aids_result){
        if (rw_result == "positive" || rw_result == "negative"){
            return 0;
        }
        if (aids_result == "positive" || aids_result == "false_positive" || aids_result == "negative"){
            return 0;
        }
        LocalDate aids_date = LocalDate.parse(aids_date, DateTimeFormatter.ofPattern("d/M/yyyy"));
        LocalDate currentDate = LocalDate.now();

        if(aids_date.isBefore(currentDate)){
            return 0;
        }
        return 1;
    }
}
