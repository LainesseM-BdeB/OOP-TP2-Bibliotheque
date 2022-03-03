package com.company;

import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {
        //Testing des classes
        int compteur=0;
        ArrayList<Document> inventaire = new ArrayList<>();
        inventaire.add(new Livre("Java pour les nuls", "Maxime Lainesse"));
        inventaire.add(new BD("Java pour les nuls en dessins!", "Maxime Lainesse", "Vincent Poirier"));

        for (Document doc : inventaire) {
            doc.printInfo();
            System.out.println("==============================");
        }
        ArrayList<Membre> liste = new ArrayList<>();
        liste.add(new Membre( "Poirier", "Vincent"));
        liste.add(new Membre(  "Lainesse", "Maxime"));
        liste.add(new Membre(  "Poutine", "Vladimir"));
        liste.add(new Membre(  "Washington", "George"));
        liste.add(new Membre(  "Washington", "Henriette"));
        //Fin testing des classes
        //testing
        for ( Membre ls : liste) {
            compteur++;
            System.out.println(compteur);
           ls.afficher();
            System.out.println("_____________________");

        }
    }
}
