package com.company;


public class Member {

    public static int num = 1;
    //attributs
    private String nom;
    private String prenom;
    private int memNum;
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = String.valueOf(memNum+init);
    }

    private char init;


    public Member(String p_nom, String p_prenom) {
        this.setNom(p_nom);
        this.setPrenom(p_prenom);
        this.setInit();
        this.memNum = num;
        num++;
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
       this.init = this.nom.charAt(0);
   }

    public void afficher() {
        System.out.printf(

                    "id#: "+this.ID+"%n"
                    +"nom: "+this.nom +"%n"
                    +"prenom: "+this.prenom +"%n");
    }

}



