package com.company;

public class Volume extends Document {
    private String auteur;
    private static int idVolNum = 1;
    private String volID;

    public Volume(String titre, String auteur) {
        super(titre);
        setAuteur(auteur);
        idVolNum++;
    }

    public void setID() {
        super.setID();
        this.volID = super.getID() + "-V" + idVolNum;
    }

    public String getID() {
        return this.volID;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public void printInfo() {
        System.out.printf("Le ID est:\n%s\nLe titre est:\n%s\nL'auteur est:\n%s\n", getID(), getTitre(), getAuteur());
    }

    public String toCsv() {
        String csvLine;
        csvLine = this.getClass().getSimpleName();
        csvLine += ";" + this.getID();
        csvLine += ";" + this.getTitre();
        csvLine += ";" + this.getAuteur();
        return csvLine;
    }

}
