package com.company;

public class BD extends Volume {
    private String dessinateur;
    private static int idBDNum = 1;
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

    public String getID() {
        return this.id;
    }

    public void setDessinateur(String dessinateur) {
        this.dessinateur = dessinateur;
    }

    public String getDessinateur() {
        return this.dessinateur;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf("Le dessinateur est:\n%s\n", getDessinateur());
    }

}
