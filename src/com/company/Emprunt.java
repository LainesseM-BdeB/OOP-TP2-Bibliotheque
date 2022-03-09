package com.company;

import java.time.LocalDate;

public class Emprunt {

    public static LocalDate date=LocalDate.now();

    //attributs

    private String date_Out;
    private String date_In;
    private String memID;
    private String Doc;
    private boolean extend;


    public Emprunt(String pdate_Out, String pdate_In, String pmemID, String pdoc){

        this.setDate_Out(pdate_Out);
        this.setDate_In(pdate_In);
        this.setMemID(pmemID);
        this.setDoc(pdoc);
        this.setExtend(false);
    }

    public String getDate_Out() {
        return date_Out;
    }

    public void setDate_Out(String date_Out) {
        this.date_Out= String.valueOf(date);
    }

    public String getDate_In() {
        return date_In;
    }

    public void setDate_In(String date_In) {
        this.date_In = String.valueOf(date.plusDays(14));
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

    public boolean isExtend() {
        return extend;
    }

    public void setExtend(boolean extend) {
        this.extend = extend;
    }

    }






