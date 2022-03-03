package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    //Testing des classes
        ArrayList<Document> inventaire = new ArrayList<>();
        inventaire.add(new Livre("Java pour les nuls", "Maxime Lainesse"));
        inventaire.add(new BD("Java pour les nuls en dessins!", "Maxime Lainesse", "Vincent Poirier"));

        for (Document doc : inventaire) {
            doc.printInfo();
            System.out.println("==============================");
        }
        //Fin testing des classes
        //testing
    }
}
