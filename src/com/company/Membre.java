package com.company;


public class Membre {

    public
    int num=0;
    char init;
    //attributs
    private String nom;
    private String prenom;


    public Membre(String p_nom, String p_prenom) {

        this.setNom(p_nom);
        this.setPrenom(p_prenom);
        this.setInit();
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
        num++;
        System.out.printf(
                     "Numero: "+num+"%n"
                    +"id#: "+ num+init+"%n"
                    +"nom: "+ nom +"%n"
                    +"prenom: "+ prenom +"%n");
    }

}



