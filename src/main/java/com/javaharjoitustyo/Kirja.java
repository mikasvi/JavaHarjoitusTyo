package com.javaharjoitustyo;

public class Kirja {
    private String nimi;
    
    public Kirja(String nimi, String kirjoittaja) {
        this.nimi = nimi;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public boolean onkoLainattu() {
        return false;
    }

    public void asetaLainattu(boolean b) {
    }
}
