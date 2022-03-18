package com.company;

import java.time.LocalDate;

public class Emprunt implements Cloneable {

    public static LocalDate date=LocalDate.now();

    //attributs

    private String date_Out;
    private String date_In;
    private String memID;
    private String docId;
    private String EmpID;
    private boolean extend;


    public Emprunt(String pdocID, String pmemID){

        this.setEmpID();
        this.setDocId(pdocID);
        this.setMemID(pmemID);
        this.setDate_Out();
        this.setDate_In();
        this.isExtend();
    }
    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID() {
        EmpID = memID+docId;
    }
    public String getDate_Out() {
        return date_Out;
    }

    public void setDate_Out() {
        this.date_Out= String.valueOf(LocalDate.now());
    }

    public String getDate_In() {
        return date_In;
    }

    public void setDate_In() {
        this.date_In = String.valueOf(date.plusDays(14));
    }

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getDocID() {
        return docId;
    }

    public void setDocId(String doc) {
        docId = doc;
    }

    public boolean isExtend() {
        return extend;
    }

    public void setExtend() {
        if (isExtend()) {
            System.out.println("La durée d'emprunt a déjà été prolongé.");
        }else
        {  this.extend = true;
           this.date_In=LocalDate.parse(this.date_In).plusDays(7).toString();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public String toCsv() {
        String csvLine;
        csvLine = this.getClass().getSimpleName();
        csvLine += ";" + this.getMemID();
        csvLine += ";" + this.getDocID();
        csvLine += ";" + this.getDate_Out();
        csvLine += ";" + this.getDate_In();

        return csvLine;
    }
    }






