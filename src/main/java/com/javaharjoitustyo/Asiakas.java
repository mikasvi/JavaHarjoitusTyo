package com.javaharjoitustyo;

import java.util.ArrayList;
import java.util.List;

public class Asiakas {
    private String nimi;
    private List<Kirja> lainassa;

    public Asiakas() {
        lainassa = new ArrayList<>();
    }
    
    public Asiakas(String nimi) {
        this.nimi = nimi;
        lainassa = new ArrayList<>();
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void lainaaKirja(Kirja kirja) {
        lainassa.add(kirja);
    }

    public List<String> getLainatutKirjat() {
        List<String> lainatutKirjat = new ArrayList<>();
        for (Kirja kirja : lainassa) {
            lainatutKirjat.add(kirja.getNimi());
        }
        return lainatutKirjat;
    }
}