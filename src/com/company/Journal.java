package com.company;

import java.time.LocalDate;

public class Journal extends Document {

    private static int idJourNum = 1;
    private LocalDate date;
    private String id;

    public Journal(String titre, LocalDate date) {
        super(titre);
        this.date = date;
        idJourNum++;
    }

    public void setID() {
        super.setID();
        this.id = super.getID() + "-J" + idJourNum;
    }

    public void loadID(String ID) {
        this.id = ID;
    }

    public String getID() {
        return this.id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf("Date de parution:\n%s\n", getDate());
    }

    public String toCsv() {
        String csvLine;
        csvLine = this.getClass().getSimpleName();
        csvLine += ";" + this.getID();
        csvLine += ";" + this.getTitre();
        csvLine += ";" + this.getDate();
        return csvLine;
    }

}
