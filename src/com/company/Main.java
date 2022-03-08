package com.company;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {



    public static void main(String[] args) throws CloneNotSupportedException {
        //Testing des classes

        Bibliotheque bibli = new Bibliotheque("BDEB", "123 fake street", "Fakecity", "Fakestate", "555-555-5555", "bdeb@fakemail.com");

        bibli.addDocument(new Livre("Java pour les nuls", "Maxime Lainesse"));
        bibli.addDocument(new BD("Java pour les nuls en dessins!", "Maxime Lainesse", "Vincent Poirier"));

        System.out.println(bibli.getInventaire().size());
        for (Document doc : bibli.getInventaire()) {
            doc.printInfo();
        }

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
        //Member tempMemb = new Member("Poirier", "Vincent");
        //members.put(tempMemb.getID, tempMemb);


        //for ( Member ls : members) {

        //   ls.afficher();
        //    System.out.println("_____________________");

        //}

        //Fin testing des classes
    }
}
