package com.company;

public class Document implements Cloneable{
    private String titre;
    private static int idDocNum = 1;
    private String docID;

    public Document(String titre) {
        setTitre(titre);
        setID();
        idDocNum++;
    }

    public void setID() {
        this.docID = "D" + idDocNum;
    }

    public String getID() {
        return this.docID;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return this.titre;
    }

    public void printInfo() {
        System.out.printf("Le ID est:\n%s\nLe titre est:\n%s\n", getID(), getTitre());
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toCsv() {
        String csvLine;
        csvLine = this.getClass().getSimpleName();
        csvLine += ";" + this.getID();
        csvLine += ";" + this.getTitre();
        return csvLine;
    }

}
