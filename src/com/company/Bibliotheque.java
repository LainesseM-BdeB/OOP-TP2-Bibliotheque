package com.company;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
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
    private List<Membre> bottin;
    private List<Emprunt> tracker;

    public Bibliotheque(String nom, String adresse, String ville, String province, String telephone, String courriel) {
        setNom(nom);
        setAdresse(adresse);
        setVille(ville);
        setProvince(province);
        setTelephone(telephone);
        setCourriel(courriel);
        setInventaire();
        setBottin();
        setTracker();

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
                }
                try {
                    if (Integer.parseInt(input) > 0 && Integer.parseInt(input) < this.inventaire.size()) {
                        this.inventaire.get(Integer.parseInt(input) - 1).printInfo();
                        Thread.sleep(3000);
                    } else {
                        System.out.println("Veuillez entrer un chiffre valide.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Une erreur c'est produite. Veuillez entrez un chiffre valide ou Q");
                }
            }while (!exit);
        } else {
            menu.printMenu();
        }
    }

    private void setInventaire() {
        this.inventaire = new ArrayList<>();
    }

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

    public void loadInventaire(Bibliotheque bibli) throws FileNotFoundException, CloneNotSupportedException {
        File file = new File("resources\\inventaire.csv");
        FileReader fread = new FileReader(file.getAbsolutePath());
        BufferedReader bfread = new BufferedReader(fread);
        for (String line : bfread.lines().toList()) {
            String[] test = line.split(";");
            switch (test[0]) {
                case "Livre" -> {
                    Livre tempLivre = new Livre(test[2], test[3]);
                    tempLivre.loadID(test[1]);
                    tempLivre.setDisponible(Boolean.getBoolean(test[4]));
                    bibli.addDocument(tempLivre);
                }
                case "BD" -> {
                    BD tempBD = new BD(test[2], test[3], test[4]);
                    tempBD.loadID(test[1]);
                    bibli.addDocument(tempBD);
                }
                case "Journal" -> {
                    Journal tempJournal = new Journal(test[2], LocalDate.parse(test[3]));
                    tempJournal.loadID(test[1]);
                    bibli.addDocument(tempJournal);
                }
                case "OuvrageReference" -> {
                    OuvrageReference tempOuvRef = new OuvrageReference(test[2], test[3], test[4]);
                    tempOuvRef.loadID(test[1]);
                    bibli.addDocument(tempOuvRef);
                }
                default -> System.out.println("Cannot import:" + Arrays.toString(test));
            }
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
    //Member
    public List<Membre> getBottin() throws CloneNotSupportedException {
        List<Membre> bottin = new ArrayList<>();
        for (Membre mem:this.bottin) {
            bottin.add((Membre) mem.clone());
        }
        return bottin;
    }
    public void showBottin(boolean isInteractive) throws Exception {
        List<Membre> bottin =getBottin();
        List<String> options = new ArrayList<>();
        Scanner inputU = new Scanner(System.in);
        String input;
        boolean exit = false;
        Menu menu = new Menu("bottin", this.getNom(), "Annuaire des adhérent", options);
        options = new ArrayList<>();
        for (Membre mem : bottin) {
            String opt = mem.getNom() + ", " + mem.getPrenom();
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
                System.out.println("Entrer le numéro correspondant pour plus de détails:");
                input = inputU.nextLine().toLowerCase().strip();
                if (input.equals("q")) {
                    exit = true;
                } else if (Integer.parseInt(input) > 0 || Integer.parseInt(input) < this.bottin.size()) {
                    this.bottin.get(Integer.parseInt(input) - 1).printMem();
                    Thread.sleep(3000);
                } else {
                    System.out.println("Une erreur c'est produite");
                }
            } while (!exit);
        } else {
            menu.printMenu();
        }
    }
    private void setBottin() {
        this.bottin = new ArrayList<>();
    }
    public void addMember(com.company.Membre mem) throws CloneNotSupportedException {
        this.bottin.add((Membre) mem.clone());
    }
    public Recherche getMember(String ID) {
        Recherche response = new Recherche();
        for (Membre mem : this.bottin) {
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
        for (Membre mem : this.bottin) {
            String csvLine = mem.toCsv();
            bfwrite.write(csvLine);
            bfwrite.newLine();
        }
        bfwrite.close();
        fwrite.close();
    }
    public void makeMember() throws CloneNotSupportedException {
        Scanner inputU = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String[] infoArr = {"le Nom", "le Prenom"};
        for (String info : infoArr) {
            System.out.printf("Entrez %s de l'adhérent:\n", info);
            input.add(inputU.nextLine().strip());
        }
        this.addMember(new com.company.Membre(input.get(0), input.get(1)));
    }
    public void makeContact() throws CloneNotSupportedException, InterruptedException {
        Scanner inputU = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String[] infoArr = {"Le nom", "le prénom", "Le courriel", "le téléphone"};
        for (String info : infoArr) {
            System.out.printf("Entrez %s de l'adhérent:\n", info);
            input.add(inputU.nextLine().strip());
        }
        this.addMember(new Contact(input.get(0), input.get(1), input.get(2), input.get(3)));
        System.out.println("L'adhérent à été ajouté au registre");
        Thread.sleep(3000);
    }
    public void removeMember(int mem) {
        this.bottin.remove(mem);
    }
    public void destroyMember() throws Exception {
        Scanner inputU = new Scanner(System.in);
        String input;
        int idxD;
        showBottin(false);
        System.out.println("Quel adhérent voulez-vous supprimer?:");
        input = inputU.nextLine().toLowerCase().strip();
        if (input.equals("q")) {
            return;
        }
        idxD = Integer.parseInt(input);
        System.out.printf("Êtes-vous sûr de vouloir annuler l'abonement: %s au nom de %s, %s\nOui ou Non?\n", bottin.get(idxD - 1).getID(), bottin.get(idxD - 1).getNom(), bottin.get(idxD - 1).getPrenom());
        input = inputU.nextLine().toLowerCase().strip();
        if (input.equals("oui")) {
            removeMember(idxD - 1);
            System.out.println("L'adhérent a été retiré du registre");
        } else {
            System.out.println("Aucun adhérent n'a été retiré du registre.");
        }
        Thread.sleep(3000);
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Emprunt

    public List<Emprunt> getTracker() throws CloneNotSupportedException {
        List<Emprunt> tracker = new ArrayList<>();
        for (Emprunt tra : this.tracker) {
            tracker.add((Emprunt) tra.clone());
        }
        return tracker;
    }
    public void showTracker(boolean isInteractive) throws Exception {
        List<Emprunt> tracker = getTracker();
        List<String> options = new ArrayList<>();
        Scanner inputU = new Scanner(System.in);
        String input;
        boolean exit = false;
        Menu menu = new Menu("tracker", this.getNom(), "Suivi des emprunts", options);
        options = new ArrayList<>();
        for (Emprunt tra : tracker) {
            String opt = tra.getEmpID() + ": " + tra.getMemID() + ": " + tra.getDocID() + ": " + tra.getDate_Out() + ": " + tra.getDate_In();
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
                System.out.println("Entrer le numéro correspondant pour plus de détails:");
                input = inputU.nextLine().toLowerCase().strip();
                if (input.equals("q")) {
                    exit = true;
                } else if (Integer.parseInt(input) > 0 || Integer.parseInt(input) < this.tracker.size()) {
                    this.tracker.get(Integer.parseInt(input) - 1).printEmp();
                    Thread.sleep(3000);
                } else {
                    System.out.println("Une erreur c'est produite");
                }
            } while (!exit);
        } else {
            menu.printMenu();
        }
    }
    private void setTracker() {
        this.tracker = new ArrayList<>();
    }
    public void addEmprunt(Emprunt tra) throws CloneNotSupportedException {
        this.tracker.add((Emprunt) tra.clone());
    }
    public Recherche getEmprunt(String ID) {
        Recherche response = new Recherche();
        for (Emprunt tra : this.tracker) {
            if (tra.getDocID().equals(ID)) {
                response.foundMember(this.tracker.indexOf(tra));
                break;
            }
        }
        return response;
    }
    public void loadTracker() throws FileNotFoundException {
        File file = new File("resources\\emprunts.csv");
        FileReader fread = new FileReader(file.getAbsolutePath());
        BufferedReader bfread = new BufferedReader(fread);
        for (String line : bfread.lines().toList()) {
            System.out.println(line);
        }
    }
    public void unloadTracker() throws IOException {
        File file = new File("resources\\emprunts.csv");
        FileWriter fwrite = new FileWriter(file.getAbsolutePath());
        BufferedWriter bfwrite = new BufferedWriter(fwrite);
        for (Emprunt tra : this.tracker) {
            String csvLine = tra.toCsv();
            bfwrite.write(csvLine);
            bfwrite.newLine();
        }
        bfwrite.close();
        fwrite.close();
    }
    public void makeEmprunt () throws Exception {
        boolean menuNum = true;
        String TEXT_YELLOW = "\u001B[33m";
        String TEXT_RESET = "\u001B[0m";
        Scanner inputU = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String[] infoArr = {"le code du document :", "le code de l'adhérant :"};
        String tempDoc = "";
        String tempMem = "";
        boolean exit = false;
        for (String info : infoArr) {
            if (menuNum){
                List<Document> inventaire = getInventaire();
                List<String> options = new ArrayList<>();
                Menu menu = new Menu("Inventaire", this.getNom(), "Inventaire de la bibliothèque", options);
                options = new ArrayList<>();
                for (Document doc : inventaire) {
                    String opt = doc.getID() + ": " + doc.getTitre();
                    if (doc.getClass().getSimpleName().equals("Livre")){
                        if (((Livre) doc).getDisponible()) {
                            options.add(opt);
                        }
                    }
                }
                menu.setOptionsM(options);
                menu.genMenu();
                menu.printMenu();
                System.out.printf("Entrez %s \n", info);
                String inputDoc = inputU.nextLine().toLowerCase().strip();
                if (inputDoc.equals("q")) {
                    exit = true;
                    break;
                }
                tempDoc = options.get(Integer.parseInt(inputDoc) - 1);
                tempDoc = tempDoc.substring(0, tempDoc.indexOf(":"));

            menuNum=false;
            } else  {
                List<Membre> bottin = getBottin();
                List<String> options = new ArrayList<>();
                Menu menu = new Menu("Registre", this.getNom(), "Registre des adhérent", options);
                options = new ArrayList<>();
                for (Membre mem : bottin) {
                    String opt = mem.getID() + ": " + mem.getNom()+ ", " + mem.getPrenom();
                    if (opt.length() > menu.widthMaxTextM) {
                        options.add(opt.substring(0, menu.widthMaxTextM));
                    } else {
                        options.add(opt);
                    }
                }
                menu.setOptionsM(options);
                menu.genMenu();
                menu.printMenu();
                System.out.printf("Entrez %s \n", info);
                String inputMem = inputU.nextLine().toLowerCase().strip();
                if (inputMem.equals("q")) {
                    exit = true;
                    break;
                }
                tempMem = options.get(Integer.parseInt(inputMem));
                tempMem = tempMem.substring(0, tempMem.indexOf(":"));
            }
        }
        if (!exit) {
            this.addEmprunt(new Emprunt(tempMem, tempDoc));
            ((Livre) this.inventaire.get(getDocument(tempDoc).getDocument())).setDisponible(false);
        }
    }

    public String setExtendedEmprunt(int idx) {
        this.tracker.get(idx).setExtend();
        return this.tracker.get(idx).getDate_In();
    }
    public void Extension() throws Exception {
        Scanner inputU = new Scanner(System.in);
        String input;
        int idxD;
        showTracker(false);
        System.out.println("Quel emprunt voulez-vous prolonger?:");
        input = inputU.nextLine().toLowerCase().strip();
        if (input.equals("q")) {
            return;
        }
        idxD = Integer.parseInt(input);
        System.out.printf("Êtes-vous sûr de vouloir prolonger l'emprunt du document: %s \nOui ou Non?\n", tracker.get(idxD - 1).getDocID());
        input = inputU.nextLine().toLowerCase().strip();
        if (input.equals("oui")) {
            String newDate = setExtendedEmprunt(idxD - 1);
            System.out.println("L'emprunt à été prolongé jusqu'au: " + newDate);
        }
        Thread.sleep(3000);
    }

    public void removeEmprunt (int tra){
            this.tracker.remove(tra);
        }

    public void destroyEmprunt () throws Exception {
            Scanner inputU = new Scanner(System.in);
            String input;
            int idxD;
            showTracker(false);
            System.out.println("Quel emprunt voulez-vous supprimer?:");
            input = inputU.nextLine().toLowerCase().strip();
            if (input.equals("q")) {
                return;
            }
            idxD = Integer.parseInt(input);
            System.out.printf("Êtes-vous sûr de vouloir supprimer l'emprunt du document: %s \nOui ou Non?\n", tracker.get(idxD - 1).getDocID());
            input = inputU.nextLine().toLowerCase().strip();
            if (input.equals("oui")) {
                ((Livre) inventaire.get(getDocument(tracker.get(idxD - 1).getDocID()).getDocument())).setDisponible(true);
                removeEmprunt(idxD - 1);
                System.out.println("L'emprunt à été supprimé.");
            } else {
                System.out.println("Aucun emprunt correspondant.");
            }
            Thread.sleep(3000);
        }


    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

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
                default -> {
                    System.out.println("Une erreur c'est produite");
                    wait(3000);
                }
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
        showInventaire(false);
        System.out.println("Quel document voulez-vous supprimer?:");
        input = inputU.nextLine().toLowerCase().strip();
        if (input.equals("q")) {
            return;
        }
        idxD = Integer.parseInt(input);
        System.out.printf("Êtes-vous sûr de vouloir supprimer le document: %s intitulé %s\nOui ou Non?\n", inventaire.get(idxD - 1).getID(), inventaire.get(idxD - 1).getTitre());
        input = inputU.nextLine().toLowerCase().strip();
        if (input.equals("oui")) {
            removeDocument(idxD - 1);
            System.out.println("Le document à été supprimé de l'inventaire");
        } else {
            System.out.println("Aucun document n'a été supprimé de l'inventaire.");
        }
        Thread.sleep(3000);
    }


}

