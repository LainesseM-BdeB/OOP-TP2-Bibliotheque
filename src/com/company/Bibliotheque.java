package com.company;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        setMembres();
    }

    public List<Document> getInventaire() throws CloneNotSupportedException {
        List<Document> inventaire = new ArrayList<>();
        for (Document doc : this.inventaire) {
            inventaire.add((Document) doc.clone());
        }
        return inventaire;
    }

    public void showInventaire() throws Exception {
        List<Document> inventaire = getInventaire();
        List<String> options = new ArrayList<>();
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
        menu.printMenu();
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

    public List<Member> getMembres() throws CloneNotSupportedException {
        List<Member> Membres = new ArrayList<>();
        for (Member mem : this.bottin) {
            bottin.add((Member) mem.clone());
        }
        return bottin;
    }

    private void setMembres() {
        this.bottin = new ArrayList<>();
    }

    public void addMember(Member mem) throws CloneNotSupportedException {
        this.bottin.add((Member) mem.clone());
    }
    public Recherche getMembres(String ID) {
        Recherche response = new Recherche();
        for (Member mem : this.bottin) {
            if (mem.getID().equals(ID)) {
                response.foundMember(this.bottin.indexOf(mem));
                break;
            }
        }
        return response;
    }
    public void removeMembres(int mem) {
        this.bottin.remove(mem);
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
                case "q" -> exit = true;
                case "1" -> makeLivre();
                case "2" -> makeBD();
                case "3" -> makeJournal();
                case "4" -> makeReference();
                default -> System.out.println("Une erreur c'est produite");
            }
        } while (!exit);
    }

    private void makeReference() throws CloneNotSupportedException {
        Scanner inputU = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String[] infoArr = {"le titre", "l'auteur", "le sujet"};
        for (String info : infoArr) {
            System.out.printf("Entrez %s de l'ouvrage de référence:\n", info);
            input.add(inputU.nextLine().strip());
        }
        this.addDocument(new OuvrageReference(input.get(0), input.get(1), input.get(2)));
    }

    private void makeJournal() throws CloneNotSupportedException {
        Scanner inputU = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String[] infoArr = {"le titre", "la date de parution(aaaa-mm-jj)"};
        for (String info : infoArr) {
            System.out.printf("Entrez %s du journal:\n", info);
            input.add(inputU.nextLine().strip());
        }
        try {
            this.addDocument(new Journal(input.get(0), LocalDate.parse(input.get(1))));
        } catch (DateTimeParseException e) {
            System.out.println("Le format de la date était incorrect.");
        }
    }

    private void makeBD() throws CloneNotSupportedException {
        Scanner inputU = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String[] infoArr = {"le titre", "l'auteur", "le dessinateur"};
        for (String info : infoArr) {
            System.out.printf("Entrez %s de la BD:\n", info);
            input.add(inputU.nextLine().strip());
        }
        this.addDocument(new BD(input.get(0), input.get(1), input.get(2)));
    }

    private void makeLivre() throws CloneNotSupportedException {
        Scanner inputU = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String[] infoArr = {"le titre", "l'auteur"};
        for (String info : infoArr) {
            System.out.printf("Entrez %s du livre:\n", info);
            input.add(inputU.nextLine().strip());
        }
        this.addDocument(new Livre(input.get(0), input.get(1)));
    }

    public void destroyDocument() throws Exception {
        Scanner input = new Scanner(System.in);
        showInventaire();
        System.out.println("Quel document voulez-vous supprimer?:");
        removeDocument(input.nextInt() - 1);
    }
}
