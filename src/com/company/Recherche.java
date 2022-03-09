package com.company;

import javax.print.Doc;

public class Recherche {

    private Boolean found = false;
    private int document;
    private Member member;
    private Emprunt emprunt;

    public Recherche() {}

    public void foundDoc(int doc) {
        this.found = true;
        this.document = doc;
    }

    public void foundMember(Member mem) {
        this.found = true;
        this.member = mem;
    }

    public void foundEmprunt(Emprunt emp) {
        this.found = true;
        this.emprunt = emp;
    }

    public Boolean getFound() {
        return this.found;
    }

    public int getDocument() {
        return this.document;
    }

}
