package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //Live code for menu DO NOT DELETE OR CHANGE vvvvv
        boolean exit = false;
        Bibliotheque bibli = new Bibliotheque("BDEB", "123 fake street", "Fakecity", "Fakestate", "555-555-5555", "bdeb@fakemail.com");
        bibli.loadInventaire(bibli);
        bibli.loadBottin(bibli);
        bibli.loadTracker(bibli);
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
            switch (input) {
                case "q" -> exit = true;
                case "1" -> traMenu(bibli);
                case "2" -> invMenu(bibli);
                case "3" -> memMenu(bibli);
                case "4" -> System.out.println("Info n'est pas encore fonctionel");
                default -> {
                    System.out.println("Une erreur c'est produite");
                    Thread.sleep(3000);
                }
            }
        } while (!exit);
        bibli.unloadInventaire();
        bibli.unloadBottin();
        bibli.unloadTracker();
        //Live code for menu DO NOT DELETE OR CHANGE ^^^^^
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
            invM.printMenu();
            System.out.println("Choisissez une des options:");
            input = inputU.nextLine().toLowerCase().strip();
            if (input.equals("q")) {
                exit = true;
            } else {
                switch (Integer.parseInt(input)) {
                    case 1 -> bibli.showInventaire(true);
                    case 2 -> bibli.createDocument();
                    case 3 -> bibli.destroyDocument();
                    default -> {
                        System.out.println("Une erreur c'est produite");
                        Thread.sleep(3000);
                    }
                }
            }
        } while (!exit);
    }

    private static void memMenu(Bibliotheque bibli) throws Exception {
        //Generating registre menu
        List<String> memOpt = new ArrayList<>();
        Scanner inputU = new Scanner(System.in);
        String input;
        boolean exit = false;
        memOpt.add("Afficher le registre");
        memOpt.add("Ajouter un adhérent");
        memOpt.add("Retirer un adhérent");
        Menu memM = new Menu("bottin", bibli.getNom(), "Gestion du Registre", memOpt);
        memM.genMenu();
        do {
            memM.printMenu();
            System.out.println("Choisissez une des options:");
            input = inputU.nextLine().toLowerCase().strip();
            if (input.equals("q")) {
                exit = true;
            } else {
                switch (Integer.parseInt(input)) {
                    case 1 -> bibli.showBottin(true);
                    case 2 -> bibli.makeContact();
                    case 3 -> bibli.destroyMember();
                    default -> {
                        System.out.println("Une erreur c'est produite");
                        Thread.sleep(3000);
                    }
                }
            }
        } while (!exit);
    }

    private static void traMenu(Bibliotheque bibli) throws Exception {
        //Generating Emprunt menu
        List<String> traOpt = new ArrayList<>();
        Scanner inputU = new Scanner(System.in);
        String input;
        boolean exit = false;
        traOpt.add("Afficher la liste des Emprunts");
        traOpt.add("Enregistrer un emprunt");
        traOpt.add("Annuler un emprunt");
        traOpt.add("Prolonger un emprunt");
        Menu traM = new Menu("tracker", bibli.getNom(), "Gestion des emprunts", traOpt);
        traM.genMenu();
        do {
            traM.printMenu();
            System.out.println("Choisissez une des options:");
            input = inputU.nextLine().toLowerCase().strip();
            if (input.equals("q")) {
                exit = true;
            } else {
                switch (Integer.parseInt(input)) {
                    case 1 -> bibli.showTracker(true);
                    case 2 -> bibli.makeEmprunt();
                    case 3 -> bibli.destroyEmprunt();
                    case 4 -> bibli.Extension();
                    default -> {
                        System.out.println("Une erreur c'est produite");
                        Thread.sleep(3000);
                    }
                }
            }
        } while (!exit);
    }
}

