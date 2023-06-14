package com.example;

public class Admin {
    final static String ADMINID = "admin";
    final static String ADMINPASS= "admin123";

    private String Uname;
    private String pwd;
    
    public Admin(String Uname, String pwd) {
        this.Uname = Uname;
        this.pwd = pwd;
    }
    
    
    public String getUname() {
        return Uname;
    }

    public String getPwd() {
        return pwd;
    }

    public int isValidLogin(){
        int valid = 0;
        
        if(Uname.equals(ADMINID) && pwd.equals(ADMINPASS)){
            valid = 1;
        }else{
            valid = 0;
        }
        
        return valid;
      
    }
}
