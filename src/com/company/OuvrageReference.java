package com.company;

public class OuvrageReference extends Volume {

    private static int idOuvNum = 1;
    private String sujet;
    private String id;

    public OuvrageReference(String titre, String auteur, String sujet) {
        super(titre, auteur);
        setSujet(sujet);
        idOuvNum++;
    }

    public void setID() {
        super.setID();
        this.id = super.getID() + "-R" + idOuvNum;
    }

    public void loadID(String ID) {
        this.id = ID;
    }

    public String getID() {
        return this.id;
    }

    public String getSujet() {
        return this.sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf("Sujet:\n%s\n", getSujet());
    }

    public String toCsv() {
        String csvLine;
        csvLine = this.getClass().getSimpleName();
        csvLine += ";" + this.getID();
        csvLine += ";" + this.getTitre();
        csvLine += ";" + this.getAuteur();
        csvLine += ";" + this.getSujet();
        return csvLine;
    }

}
