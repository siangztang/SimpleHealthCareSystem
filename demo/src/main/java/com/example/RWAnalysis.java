package com.example;

//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;

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
    public String getRw_result(){
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

    public static int validationRWAnalysis(String analysis_date, String rw_result, String aids_date, String aids_result){
        if(analysis_date == null || analysis_date.isEmpty()){
            System.out.println("Analysis date is empty");
            return 0;
        }
        if (rw_result ==null){
            System.out.println("RW result is empty");
            return 0;
        }
        if (aids_result == "null"){
            System.out.println("AIDS result is empty");
            return 0;
        }
        
        // check if aids date is in the future
        if (aids_date == null || aids_date.isEmpty()) {
            System.out.println("AIDS date is empty");
            return 0;
        }

        return 1;
    }
}
