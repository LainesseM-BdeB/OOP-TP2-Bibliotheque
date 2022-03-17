package com.company;


public class Member implements Cloneable {

    public static int num = 1;
    //attributs
    private String nom;
    private String prenom;
    private int memNum;
    private String ID;


    private String init;


    public Member(String p_nom, String p_prenom) {
        this.setNom(p_nom);
        this.setPrenom(p_prenom);
        this.setInit();
        this.memNum = num;
        this.setID();
        num++;
    }
    public void setID() {
        this.ID = init+memNum;
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

    public void setInit(){
       this.init = nom.substring(0,3);
   }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public void afficher() {
        System.out.printf(

                    "id#: "+this.ID+"%n"
                    +"nom: "+this.nom +"%n"
                    +"prenom: "+this.prenom +"%n");
    }
    public void printMem() {
        System.out.printf(getNom(), getPrenom());
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



