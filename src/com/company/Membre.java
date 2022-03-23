package com.company;


public class Membre implements Cloneable {

    public static int num = 1;
    private final int memNum;
    private String nom;
    private String prenom;
    private String ID;


    private String init;


    public Membre(String p_nom, String p_prenom) {
        this.setNom(p_nom);
        this.setPrenom(p_prenom);
        this.setInit();
        this.memNum = num;
        this.setID();
        num++;
    }

    public void setID() {
        this.ID = init + memNum;
    }

    public String getID() {
        return this.ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setInit() {
        if (nom.length() < 3) {
            this.init = nom;
        } else {
            this.init = nom.substring(0, 3);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void printMem() {
        System.out.printf(

                "id#: " + this.ID + "%n"
                        + "Nom: " + this.nom + "%n"
                        + "Prénom: " + this.prenom + "%n");
    }

    public String toCsv() {
        String csvLine;
        csvLine = this.getClass().getSimpleName();
        csvLine += ";" + this.getID();
        csvLine += ";" + this.getNom();
        csvLine += ";" + this.getPrenom();
        return csvLine;
    }
}



