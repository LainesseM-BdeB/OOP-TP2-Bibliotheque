package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {



    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        //TEST POSTGRESQL
        //Recherche pg = new Recherche();
        //pg.testPostgresql();
        //FIN TEST POSTGRESQL


        //Testing des classes
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.plusDays(14));
        today = today.minusDays(2);
        System.out.println(today.getDayOfWeek());
        System.out.println(today.getDayOfWeek().getValue());
        Map<Integer, String> semaine = new HashMap<>(7) {{
            put(1, "Lundi");
            put(2, "Mardi");
            put(3, "Mercredi");
            put(4, "Jeudi");
            put(5, "Vendredi");
            put(6, "Samedi");
            put(7, "Dimanche");
        }};
        System.out.println(semaine.get(today.getDayOfWeek().getValue()));

        Bibliotheque bibli = new Bibliotheque("BDEB", "123 fake street", "Fakecity", "Fakestate", "555-555-5555", "bdeb@fakemail.com");
        bibli.loadInventaire();
        bibli.addDocument(new Livre("Java pour les nuls", "Maxime Lainesse"));
        bibli.addDocument(new BD("Java pour les nuls en dessins!", "Maxime Lainesse", "Vincent Poirier"));
        bibli.addDocument(new Journal("Le journal de Baie-Comeau", LocalDate.now()));
        bibli.addDocument(new OuvrageReference("L'atlas des patates", "Madame Brossard", "Alimentation"));
        bibli.unloadInventaire();

        System.out.println("###################################################################");
        for (Document doc : bibli.getInventaire()) {
            doc.printInfo();
        }
        System.out.println("###################################################################");

        Recherche response = bibli.getDocument("D3-J1");
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

        Bibliotheque Memb =new Bibliotheque("BDEB", "123 fake street", "Fakecity", "Fakestate", "555-555-5555", "bdeb@fakemail.com");
        Memb.loadBottin();
        Memb.addMember(new Member("Trump","Donald"));
        Memb.addMember(new Member("Case","Justin"));
        Memb.unloadBottin();
        
        System.out.println();


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
