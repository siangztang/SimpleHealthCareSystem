package com.example;

public class UrineAnalysis extends Analysis{

    private String color;
    private double reaction;
    private String transparency;
    private double density;
    
    public UrineAnalysis(String analysis_id, String analysis_date, String treatment_course_id , String color, double reaction, String transparency, double density){
        super(analysis_id, analysis_date, treatment_course_id);
        this.color = color;
        this.reaction = reaction;
        this.transparency = transparency;
        this.density = density;
    }


    // Normal urine color ranges from pale yellow to amber.
    public String getColor(){
        return color;
    }

    // Normal range: Approximately 4.6-8.0
    public double getReaction(){
        return reaction;
    }

    // Normal range: Urine is typically clear. Cloudiness may indicate the presence of substances such as bacteria, mucus, or crystals.
    public String getTransparency(){
        return transparency;
    }

    // Normal range: Approximately 1.005-1.030
    public double getDensity(){
        return density;
    }

    public static int validationUrineAnalysis(String analysis_date, String color, double reaction, String transparency, double density){
        if(analysis_date == null || analysis_date.isEmpty()){
            System.out.println("Analysis date is empty");
            return 0;
        }

         if(color == null){
            System.out.println(color);
            System.out.println("Color is empty");
            return 0;
        }
        
        if (reaction <= 4.6 || reaction >= 8.0){
            System.out.println(reaction);
            System.out.println("Reaction is not in range");
            return 0;
        }

        if (transparency == null){
            System.out.println(transparency);
            System.out.println("Transparency is empty");
            return 0;
        }

        if (density <= 1.005 || density >= 1.030){
            System.out.println(density);
            System.out.println("Density is not in range");
            return 0;
        }

        return 1;
    }
}
