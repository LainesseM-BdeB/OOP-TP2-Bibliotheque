package com.company;

import java.time.LocalDate;

public class Journal extends Document{

    private LocalDate date;
    private static int idJourNum = 1;
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

    public String getID() {
        return this.id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
