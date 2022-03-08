package com.company;

public class OuvrageReference extends Volume {

    private String sujet;

    public OuvrageReference(String titre, String auteur, String sujet) {
        super(titre, auteur);
        setSujet(sujet);
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getSujet() {
        return this.sujet;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf("Sujet:\n%s\n", getSujet());
    }

}
