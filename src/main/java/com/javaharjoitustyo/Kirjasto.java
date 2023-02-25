package com.javaharjoitustyo;

import java.util.ArrayList;
import java.util.List;

public class Kirjasto {
    private List<Kirja> kirjat;
    private List<Asiakas> asiakkaat;

    public Kirjasto() {
        kirjat = new ArrayList<>();
        asiakkaat = new ArrayList<>();
    }

    public void lisaaAsiakas(Asiakas asiakas) {
        asiakkaat.add(asiakas);
    }

    public List<Asiakas> getAsiakkaat() {
        return asiakkaat;
    }
    
    public void lisaaKirja(Kirja kirja) {
        kirjat.add(kirja);
    }
    
    public void poistaKirja(Kirja kirja) {
        kirjat.remove(kirja);
    }
    
    public List<Kirja> getKirjat() {
        return kirjat;
    }
    public Kirja getKirja(String nimi) {
        for (Kirja kirja : kirjat) {
            if (kirja.getNimi().equals(nimi)) {
                return kirja;
            }
        }
        return null;
    }

    public Asiakas getAsiakas(String nimi) {
        for (Asiakas asiakas : asiakkaat) {
            if (asiakas.getNimi().equals(nimi)) {
                return asiakas;
            }
        }
        return null;
    }
}