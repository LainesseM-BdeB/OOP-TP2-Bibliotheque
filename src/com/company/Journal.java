package com.company;

import java.time.LocalDate;
import java.util.Date;

public class Journal extends Document{

    private LocalDate date;

    public Journal(String titre, LocalDate date) {
        super(titre);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
