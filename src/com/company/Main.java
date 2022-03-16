package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception {
        //Live code for menu DO NOT DELETE OR CHANGE vvvvv
        boolean exit = false;
        Bibliotheque bibli = new Bibliotheque("BDEB", "123 fake street", "Fakecity", "Fakestate", "555-555-5555", "bdeb@fakemail.com");
        //Generating main menu
        List<String> mainOpt = new ArrayList<>();
        mainOpt.add("Emprunt");
        mainOpt.add("Inventaire");
        mainOpt.add("Membres");
        mainOpt.add("Information générale");
        Menu mainM = new Menu("main", bibli.getNom(), "Menu Principal", mainOpt);
        mainM.genMenu();
        Scanner inputU = new Scanner(System.in);
        String input;

        do {
            mainM.printMenu();
            System.out.println("Choisissez une des options:");
            input = inputU.nextLine().toLowerCase().strip();
            if (input.equals("q")) {
                exit = true;
            } else {
                switch (Integer.parseInt(input)) {
                    case 1 -> System.out.println("Emprunt n'est pas encore fonctionel");
                    case 2 -> invMenu(bibli);
                    case 3 -> System.out.println("Membre n'est pas encore fonctionel");
                    case 4 -> System.out.println("Info n'est pas encore fonctionel");
                    default -> System.out.println("Une erreur c'est produite");
                }
            }
        } while (!exit);

        //Live code for menu DO NOT DELETE OR CHANGE ^^^^^


        //TEST POSTGRESQL
        //Recherche pg = new Recherche();
        //pg.testPostgresql();
        //FIN TEST POSTGRESQL


        //Testing des classes
        //LocalDate today = LocalDate.now();
        //System.out.println(today);
        //System.out.println(today.plusDays(14));
        //today = today.minusDays(2);
        //System.out.println(today.getDayOfWeek());
        //System.out.println(today.getDayOfWeek().getValue());
        //Map<Integer, String> semaine = new HashMap<>(7) {{
        //    put(1, "Lundi");
        //    put(2, "Mardi");
        //    put(3, "Mercredi");
        //    put(4, "Jeudi");
        //    put(5, "Vendredi");
        //    put(6, "Samedi");
        //    put(7, "Dimanche");
        //}};
        //System.out.println(semaine.get(today.getDayOfWeek().getValue()));
        //
        //
        //bibli.loadInventaire();
        //bibli.addDocument(new Livre("Java pour les nuls", "Maxime Lainesse"));
        //bibli.addDocument(new BD("Java pour les nuls en dessins!", "Maxime Lainesse", "Vincent Poirier"));
        //bibli.addDocument(new Journal("Le journal de Baie-Comeau", LocalDate.now()));
        //bibli.addDocument(new OuvrageReference("L'atlas des patates", "Madame Brossard", "Alimentation"));
        //
        //bibli.showInventaire();
        //
        //bibli.addDocument(new BD("Tintin et le point-virgule manquant", "Hergé", "Hergé"));
        //
        //bibli.showInventaire();
        //
        //boolean good = false;
        //do {
        //    Scanner inputU = new Scanner(System.in);
        //    System.out.println("Choisissez un des livres:");
        //    int i = inputU.nextInt();
        //    int max = bibli.getInventaire().size();
        //    if (i > max || i < 1) {
        //        System.out.println("Le chiffre entré n'est pas valide.");
        //    } else {
        //        bibli.getInventaire().get(i - 1).printInfo();
        //        good = true;
        //    }
        //} while (!good);
        //
        //bibli.unloadInventaire();
        //
        //System.out.println("###################################################################");
        //for (Document doc : bibli.getInventaire()) {
        //    doc.printInfo();
        //}
        //System.out.println("###################################################################");
        //
        //Recherche response = bibli.getDocument("D3-J1");
        //if (response.getFound()) {
        //    bibli.getInventaire().get(response.getDocument()).printInfo();
        //    bibli.removeDocument(response.getDocument());
        //} else {
        //    System.out.println("There wasn't any Document with this ID");
        //}
        //
        //System.out.println("###################################################################");
        //for (Document doc : bibli.getInventaire()) {
        //    doc.printInfo();
        //}
        //System.out.println("###################################################################");
        //
        //Bibliotheque Memb =new Bibliotheque("BDEB", "123 fake street", "Fakecity", "Fakestate", "555-555-5555", "bdeb@fakemail.com");
        //Memb.loadBottin();
        //Memb.addMember(new Member("Trump","Donald"));
        //Memb.addMember(new Member("Case","Justin"));
        //Memb.unloadBottin();
        //
        //System.out.println();
        //
        //
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

    private static void invMenu(Bibliotheque bibli) throws Exception {
        //Generating inventaire menu
        List<String> invOpt = new ArrayList<>();
        Scanner inputU = new Scanner(System.in);
        String input;
        boolean exit = false;
        invOpt.add("Afficher l'inventaire");
        invOpt.add("Ajouter un document");
        invOpt.add("Retirer un document");
        Menu invM = new Menu("inventaire", bibli.getNom(), "Gestion de l'inventaire", invOpt);
        invM.genMenu();
        do {
            System.out.println("Choisissez une des options:");
            input = inputU.nextLine().toLowerCase().strip();
            if (input.equals("q")) {
                exit = true;
            } else {
                switch (Integer.parseInt(input)) {
                    case 1 -> bibli.showInventaire();
                    case 2 -> bibli.createDocument();
                    case 3 -> bibli.destroyDocument();
                    default -> System.out.println("Une erreur c'est produite");
                }
            }
        } while (!exit);
    }
}
