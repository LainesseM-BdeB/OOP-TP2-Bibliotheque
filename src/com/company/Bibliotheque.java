package com.company;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bibliotheque {

    private String nom;
    private String adresse;
    private String ville;
    private String province;
    private String telephone;
    private String courriel;
    private List<Document> inventaire;
    private List<Member> bottin;
    private List<Emprunt> emprunts;

    public Bibliotheque(String nom, String adresse, String ville, String province, String telephone, String courriel) {
        setNom(nom);
        setAdresse(adresse);
        setVille(ville);
        setProvince(province);
        setTelephone(telephone);
        setCourriel(courriel);
        setInventaire();
        setBottin();

    }

    public List<Document> getInventaire() throws CloneNotSupportedException {
        List<Document> inventaire = new ArrayList<>();
        for (Document doc : this.inventaire) {
            inventaire.add((Document) doc.clone());
        }
        return inventaire;
    }

    public void showInventaire(boolean isInteractive) throws Exception {
        List<Document> inventaire = getInventaire();
        List<String> options = new ArrayList<>();
        Scanner inputU = new Scanner(System.in);
        String input;
        boolean exit = false;
        Menu menu = new Menu("Inventaire", this.getNom(), "Inventaire de la bibliothèque", options);
        options = new ArrayList<>();
        for (Document doc : inventaire) {
            String opt = doc.getID() + ": " + doc.getTitre();
            if (opt.length() > menu.widthMaxTextM) {
                options.add(opt.substring(0, menu.widthMaxTextM));
            } else {
                options.add(opt);
            }
        }
        menu.setOptionsM(options);
        menu.genMenu();
        if (isInteractive) {
            do {
                menu.printMenu();
                System.out.println("Pour quel document voulez-vous les détails?:");
                input = inputU.nextLine().toLowerCase().strip();
                if (input.equals("q")) {
                    exit = true;
                } else if (Integer.parseInt(input) > 0 || Integer.parseInt(input) < this.inventaire.size()) {
                    this.inventaire.get(Integer.parseInt(input) - 1).printInfo();
                    Thread.sleep(3000);
                } else {
                    System.out.println("Une erreur c'est produite");
                }
            } while (!exit);
        } else {
            menu.printMenu();
        }
    }

    private void setInventaire() {this.inventaire = new ArrayList<>();}

    public void addDocument(Document doc) throws CloneNotSupportedException {
        this.inventaire.add((Document) doc.clone());
    }

    public Recherche getDocument(String ID) {
        Recherche response = new Recherche();
        for (Document doc : this.inventaire) {
            if (doc.getID().equals(ID)) {
                response.foundDoc(this.inventaire.indexOf(doc));
                break;
            }
        }
        return response;
    }

    public void removeDocument(int doc) {
        this.inventaire.remove(doc);
    }

    public void loadInventaire() throws FileNotFoundException {
        File file = new File("resources\\inventaire.csv");
        FileReader fread = new FileReader(file.getAbsolutePath());
        BufferedReader bfread = new BufferedReader(fread);
        for (String line : bfread.lines().toList()) {
            System.out.println(line);
        }
    }

    public void unloadInventaire() throws IOException {
        File file = new File("resources\\inventaire.csv");
        FileWriter fwrite = new FileWriter(file.getAbsolutePath());
        BufferedWriter bfwrite = new BufferedWriter(fwrite);
        for (Document doc : this.inventaire) {
            String csvLine = doc.toCsv();
            bfwrite.write(csvLine);
            bfwrite.newLine();
        }
        bfwrite.close();
        fwrite.close();
    }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public List<Member> getBottin() throws CloneNotSupportedException {
        List<Member> bottin = new ArrayList<>();
        for (Member mem : this.bottin) {
            bottin.add((Member) mem.clone());
        }
        return bottin;
    }
    public void showBottin() throws Exception {
        List<Member> bottin = getBottin();
        List<String> options = new ArrayList<>();
        Menu menu = new Menu("Bottin", this.getNom(), "Registre de la bibliothèque", options);
        options = new ArrayList<>();
        for (Member mem : bottin) {
            String opt = mem.getID() + ": " + mem.getNom() + ": " + mem.getPrenom();
            if (opt.length() > menu.widthMaxTextM) {
                options.add(opt.substring(0, menu.widthMaxTextM));
            } else {
                options.add(opt);
            }
        }
        menu.setOptionsM(options);
        menu.genMenu();
        menu.printMenu();
    }

    private void setBottin() {
        this.bottin = new ArrayList<>();
    }

    public void addMember(Member mem) throws CloneNotSupportedException {
        this.bottin.add((Member) mem.clone());
    }
    public Recherche getMember(String ID) {
        Recherche response = new Recherche();
        for (Member mem : this.bottin) {
            if (mem.getID().equals(ID)) {
                response.foundMember(this.bottin.indexOf(mem));
                break;
            }
        }
        return response;
    }

    public void loadBottin() throws FileNotFoundException {
        File file = new File("resources\\membres.csv");
        FileReader fread = new FileReader(file.getAbsolutePath());
        BufferedReader bfread = new BufferedReader(fread);
        for (String line : bfread.lines().toList()) {
            System.out.println(line);
        }
    }

    public void unloadBottin() throws IOException {
        File file = new File("resources\\membres.csv");
        FileWriter fwrite = new FileWriter(file.getAbsolutePath());
        BufferedWriter bfwrite = new BufferedWriter(fwrite);
        for (Member mem : this.bottin) {
            String csvLine = mem.toCsv();
            bfwrite.write(csvLine);
            bfwrite.newLine();
        }
        bfwrite.close();
        fwrite.close();
    }


    //public List<Emprunt> getEmprunts() {
    //    return emprunts;
    //}

    //public void setEmprunts(List<Emprunt> emprunts) {
    //    this.emprunts = emprunts;
    //}

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourriel() {
        return this.courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void createDocument() throws Exception {
        Scanner inputU = new Scanner(System.in);
        String input;
        boolean exit = false;
        List<String> optM = new ArrayList<>();
        optM.add("Livre");
        optM.add("BD");
        optM.add("Journal");
        optM.add("Ouvrage de référence");
        Menu docM = new Menu("document", "Création de document", "Voici les types de documents disponible", optM);
        docM.genMenu();
        do {
            docM.printMenu();
            System.out.println("Quel type de document voulez vous rajouter?");
            input = inputU.nextLine().toLowerCase().strip();
            switch (input) {

                case "1" -> makeLivre();
                case "2" -> makeBD();
                case "3" -> makeJournal();
                case "4" -> makeReference();
                case "q" -> exit = true;
                default -> {System.out.println("Une erreur c'est produite"); wait(3000);}
            }
        } while (!exit);
    }

    private void makeReference() throws CloneNotSupportedException, InterruptedException {
        Scanner inputU = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String[] infoArr = {"le titre", "l'auteur", "le sujet"};
        for (String info : infoArr) {
            System.out.printf("Entrez %s de l'ouvrage de référence:\n", info);
            input.add(inputU.nextLine().strip());
        }
        this.addDocument(new OuvrageReference(input.get(0), input.get(1), input.get(2)));
        System.out.println("L'ouvrage de référence à été ajouté à l'inventaire");
        Thread.sleep(3000);
    }

    private void makeJournal() throws CloneNotSupportedException, InterruptedException {
        Scanner inputU = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String[] infoArr = {"le titre", "la date de parution(aaaa-mm-jj)"};
        for (String info : infoArr) {
            System.out.printf("Entrez %s du journal:\n", info);
            input.add(inputU.nextLine().strip());
        }
        try {
            this.addDocument(new Journal(input.get(0), LocalDate.parse(input.get(1))));
            System.out.println("Le journal à été ajouté à l'inventaire");
            Thread.sleep(3000);
        } catch (DateTimeParseException e) {
            System.out.println("Le format de la date était incorrect.");
            Thread.sleep(3000);
        }
    }

    private void makeBD() throws CloneNotSupportedException, InterruptedException {
        Scanner inputU = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String[] infoArr = {"le titre", "l'auteur", "le dessinateur"};
        for (String info : infoArr) {
            System.out.printf("Entrez %s de la BD:\n", info);
            input.add(inputU.nextLine().strip());
        }
        this.addDocument(new BD(input.get(0), input.get(1), input.get(2)));
        System.out.println("La BD à été ajouté à l'inventaire");
        Thread.sleep(3000);
    }

    private void makeLivre() throws CloneNotSupportedException, InterruptedException {
        Scanner inputU = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String[] infoArr = {"le titre", "l'auteur"};
        for (String info : infoArr) {
            System.out.printf("Entrez %s du livre:\n", info);
            input.add(inputU.nextLine().strip());
        }
        this.addDocument(new Livre(input.get(0), input.get(1)));
        System.out.println("Le livre à été ajouté à l'inventaire");
        Thread.sleep(3000);
    }

    public void destroyDocument() throws Exception {
        Scanner inputU = new Scanner(System.in);
        String input;
        int idxD;
        String answer;
        showInventaire(false);
        System.out.println("Quel document voulez-vous supprimer?:");
        input = inputU.nextLine().toLowerCase().strip();
        if (input.equals("q")) {
            return;
        }
        idxD = Integer.parseInt(input);
        System.out.printf("Êtes-vous sûr de vouloir supprimer le document: %s intitulé %s\nOui ou Non?\n", inventaire.get(idxD - 1).getID(), inventaire.get(idxD - 1).getTitre());
        answer = inputU.nextLine().toLowerCase().strip();
        if (answer.equals("oui")) {
            removeDocument(idxD - 1);
            System.out.println("Le document à été supprimé de l'inventaire");
        } else {
            System.out.println("Aucun document n'a été supprimé de l'inventaire.");
        }
        Thread.sleep(3000);
    }
    public void makeMembre() throws CloneNotSupportedException {
        Scanner inputU = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String[] infoArr = {"le Nom", "le Prenom"};
        for (String info : infoArr) {
            System.out.printf("Entrez %s de l'adhérent:\n", info);
            input.add(inputU.nextLine().strip());
        }
        this.addMember(new Member(input.get(0), input.get(1)));
    }
    public void removeMember(int mem) {
        this.bottin.remove(mem);
    }
    public void destroyMember() throws Exception {
        Scanner input = new Scanner(System.in);
        showBottin();
        System.out.println("Quel adhérent voulez-vous supprimer?:");
        removeMember(input.nextInt() - 1);
    }
}
