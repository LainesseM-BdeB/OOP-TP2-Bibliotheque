package com.company;

import java.util.List;

public class Bibliotheque {

    private String nom;
    private String adresse;
    private String ville;
    private String province;
    private String telephone;
    private String courriel;
    private List<Document> inventaire;
    private List<Member> membres;
    private List<Emprunt> emprunts;

    public Bibliotheque() {
        setNom(nom);
        setAdresse(adresse);
        setVille(ville);
        setProvince(province);
        setTelephone(telephone);
        setCourriel(courriel);
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
