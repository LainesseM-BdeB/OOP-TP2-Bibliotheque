package com.company;

public class Emprunt {

    //attributs

    private String date_Out;
    private String date_In;
    private String memID;
    private String Doc;
    private String Emp;




    public Emprunt(String date_Out, String date_In, String memID, String doc) {
        this.getDate_Out();
        this.getDate_In();
        this.getMemID();
        this.getDoc();
        this.getEmp();
    }

    public String getDate_Out() {
        return date_Out;
    }
    public void setDate_Out(String date_Out) {
        this.date_Out = date_Out;
    }

    public String getDate_In() {
        return date_In;
    }
    public void setDate_In(String date_In) {
        this.date_In = date_In;
    }

    public String getMemID() {
        return memID;
    }
    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getDoc() {
        return Doc;
    }
    public void setDoc(String doc) {
        Doc = doc;
    }

    public String getEmp() {
        return Emp;
    }

    public void setEmp(String emp) {
        Emp = emp;
    }
}


