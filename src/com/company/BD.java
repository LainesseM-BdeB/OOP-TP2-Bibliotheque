package com.company;

public class BD extends Volume {
    private String dessinateur;

    public BD(String titre, String auteur, String dessinateur) {
        super(titre, auteur);
        setDessinateur(dessinateur);
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
