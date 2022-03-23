package com.company;

public class BD extends Volume {
    private static int idBDNum = 1;
    private String dessinateur;
    private String id;

    public BD(String titre, String auteur, String dessinateur) {
        super(titre, auteur);
        setDessinateur(dessinateur);
        idBDNum++;
    }

    public void setID() {
        super.setID();
        this.id = super.getID() + "-BD" + idBDNum;
    }

    public void loadID(String ID) {
        this.id = ID;
    }

    public String getID() {
        return this.id;
    }

    public String getDessinateur() {
        return this.dessinateur;
    }

    public void setDessinateur(String dessinateur) {
        this.dessinateur = dessinateur;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf("Le dessinateur est:\n%s\n", getDessinateur());
    }

    public String toCsv() {
        String csvLine;
        csvLine = this.getClass().getSimpleName();
        csvLine += ";" + this.getID();
        csvLine += ";" + this.getTitre();
        csvLine += ";" + this.getAuteur();
        csvLine += ";" + this.getDessinateur();
        return csvLine;
    }

}
