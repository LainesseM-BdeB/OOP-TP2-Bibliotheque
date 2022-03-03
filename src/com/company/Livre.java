package com.company;

public class Livre extends Volume{
    private boolean estDisponible = true;

    public Livre(String titre, String auteur) {
        super(titre, auteur);
    }

    public void setDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

    public boolean getDisponible() {
        return this.estDisponible;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf("Disponibilité:\n%b\n", getDisponible());
    }

}
