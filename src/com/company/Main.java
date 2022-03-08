package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        // test de la classe Membre

        //Map<String, Member> members = new HashMap<>();
        //Member tempMemb = new Member("Poirier", "Vincent");
        //members.put(tempMemb.getID, tempMemb);


        //for ( Member ls : members) {

        //   ls.afficher();
        //    System.out.println("_____________________");

        //}

        //Fin testing des classes
    }
}
