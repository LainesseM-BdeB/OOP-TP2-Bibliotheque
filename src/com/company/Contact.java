
package com.company;

public class Contact extends Membre {

    private String courriel;
    private String cell;

    public Contact(String p_nom, String p_prenom, String courriel, String cell) {
        super(p_nom,p_prenom);
        setCourriel(courriel);
        setCell(cell);

    }


    public String getCourriel() {
        return courriel;
    }

        public void setCourriel(String courriel) {
            this.courriel = courriel;
        }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getCell() {
        return cell;
    }

    public void printMem() {
        System.out.printf("#ID:\n%s\nNom:\n%s\nPrénom:\n%s\nCourriel:\n%s\nTéléphone:\n%s\n"
                ,getID(),getNom(),getPrenom(),getCourriel(), getCell());
    }

    public String toCsv() {
        String csvline = super.toCsv();
        String[] csvSplit = csvline.split(";");
        csvSplit[0] = this.getClass().getSimpleName();
        csvline = String.join(";", csvSplit);
        csvline += ";" + this.courriel;
        csvline += ";" + this.cell;
        return csvline;
    }
}