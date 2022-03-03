package com.company;

public class Document {
    private String titre;

    public Document(String titre) {
        setTitre(titre);
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return this.titre;
    }

    public void printInfo() {
        System.out.printf("Le titre est:\n%s\n", getTitre());
    }

}
