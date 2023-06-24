package com.example;

public class Department {

    private String id;
    private String name;

    public Department(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Department() {
    }

    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int validationDepartment(String name){

        if (!name.matches("^[a-zA-z]+([\\s][a-zA-Z]+)*$") || name.length() < 5) {
            return 0;
        }

        return 1;
    }
}
