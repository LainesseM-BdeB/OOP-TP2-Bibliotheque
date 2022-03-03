package com.company;

public class Volume extends Document {
    String auteur;

    public Volume(String titre, String auteur) {
        super(titre);
        setAuteur(auteur);
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf("L'auteur est:\n%s\n", getAuteur());
    }

}
