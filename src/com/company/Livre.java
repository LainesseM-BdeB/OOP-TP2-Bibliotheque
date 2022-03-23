package com.company;

public class Livre extends Volume {
    private static int idLivNum = 1;
    private boolean estDisponible = true;
    private String livID;

    public Livre(String titre, String auteur) {
        super(titre, auteur);
        idLivNum++;
    }

    public void setID() {
        super.setID();
        this.livID = super.getID() + "-L" + idLivNum;
    }

    public void loadID(String ID) {
        this.livID = ID;
    }

    public String getID() {
        return this.livID;
    }

    public boolean getDisponible() {
        return this.estDisponible;
    }

    public void setDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public void printInfo() {
        System.out.printf("Le ID est:\n%s\nLe titre est:\n%s\nL'auteur est:\n%s\nDisponibilité:\n%b\n", getID(), getTitre(), getAuteur(), getDisponible());
    }

    public String toCsv() {
        String csvLine;
        csvLine = this.getClass().getSimpleName();
        csvLine += ";" + this.getID();
        csvLine += ";" + this.getTitre();
        csvLine += ";" + this.getAuteur();
        csvLine += ";" + this.getDisponible();
        return csvLine;
    }

}
