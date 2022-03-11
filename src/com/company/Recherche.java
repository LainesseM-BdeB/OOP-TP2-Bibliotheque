package com.company;

import javax.sql.RowSet;
import java.sql.*;

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

    public void testPostgresql() {
        Connection conn;
        ResultSet response;
        ResultSetMetaData responseMeta;
        Statement statement;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pokedex", "postgres", "m#S73y%7");
            statement = conn.createStatement();
            String sql = "SELECT * FROM pokemon ORDER BY national_dex ASC LIMIT 5;";
            response = statement.executeQuery(sql);
            responseMeta = response.getMetaData();
            while (response.next()) {
                for (int i = 1; i <= responseMeta.getColumnCount(); i++) {
                    System.out.printf("%s : %s\n", responseMeta.getColumnName(i), response.getString(i));
                }
                System.out.println("--------------------------------------------------");
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

}
