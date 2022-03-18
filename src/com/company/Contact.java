
package com.company;



public class Contact  {

    private String courriel;
    private String cell;

    public Contact(String p_nom, String p_prenom, String courriel, String cell) {

        this.getCourriel();
        this.getCell();

    }


    public String getCourriel() {
        return courriel;
    }

    public String getCell() {
        return cell;
    }

    public void afficher() {
        System.out.printf("Courriel:\n%s\ncell:\n%s\n" , getCourriel(), getCell());
    }
}