package com.company;

import java.util.ArrayList;
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
    //private List<Emprunt> emprunts;

    public Bibliotheque() {
        setNom(nom);
        setAdresse(adresse);
        setVille(ville);
        setProvince(province);
        setTelephone(telephone);
        setCourriel(courriel);
        setInventaire();
    }

    public List<Document> getInventaire() throws CloneNotSupportedException {
        List<Document> inventaire = new ArrayList<>();
        for (Document doc : this.inventaire) {
            inventaire.add((Document) doc.clone());
        }
        return inventaire;
    }

    private void setInventaire() {
        this.inventaire = new ArrayList<>();
    }

    public void addDocument(Document doc) throws CloneNotSupportedException {
        this.inventaire.add((Document) doc.clone());
    }

    public List<Member> getMembres() {
        return membres;
    }

    public void setMembres(List<Member> membres) {
        this.membres = membres;
    }

    //public List<Emprunt> getEmprunts() {
    //    return emprunts;
    //}

    //public void setEmprunts(List<Emprunt> emprunts) {
    //    this.emprunts = emprunts;
    //}

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourriel() {
        return this.courriel;
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
