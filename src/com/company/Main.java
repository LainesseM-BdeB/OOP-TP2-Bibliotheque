package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {



    public static void main(String[] args) throws CloneNotSupportedException {
        //Testing des classes

        Bibliotheque bibli = new Bibliotheque("BDEB", "123 fake street", "Fakecity", "Fakestate", "555-555-5555", "bdeb@fakemail.com");

        bibli.addDocument(new Livre("Java pour les nuls", "Maxime Lainesse"));
        bibli.addDocument(new BD("Java pour les nuls en dessins!", "Maxime Lainesse", "Vincent Poirier"));


        System.out.println("###################################################################");
        for (Document doc : bibli.getInventaire()) {
            doc.printInfo();
        }
        System.out.println("###################################################################");

        Recherche response = bibli.getDocument("D1");
        if (response.getFound()) {
            bibli.getInventaire().get(response.getDocument()).printInfo();
            bibli.removeDocument(response.getDocument());
        } else {
            System.out.println("There wasn't any Document with this ID");
        }

        System.out.println("###################################################################");
        for (Document doc : bibli.getInventaire()) {
            doc.printInfo();
        }
        System.out.println("###################################################################");



        //ArrayList<Document> inventaire = new ArrayList<>();
        //inventaire.add(new Livre("Java pour les nuls", "Maxime Lainesse"));
        //inventaire.add(new BD("Java pour les nuls en dessins!", "Maxime Lainesse", "Vincent Poirier"));
        //
        //for (Document doc : inventaire) {
        //    doc.printInfo();
        //    System.out.println("==============================");
        //}

        // test de la classe Membre

        //Map<String, Member> members = new HashMap<>();
        //Member tempMemb = new Member("César", "Jules");
        //members.put(tempMemb.getMemID(), tempMemb);
        //System.out.println();
        //
        //Map<String, Emprunt> emprunts = new HashMap<>();
        //Emprunt tempEmp = new Emprunt("01-01-2022", "16-01-2202","1CÉS","RR");
        //emprunts.put(tempEmp.getEmp(), tempEmp);
        //System.out.println();


        //for ( Member ls : members) {

        //   ls.afficher();
        //    System.out.println("_____________________");

        //}

        //Fin testing des classes
    }
}
