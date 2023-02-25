package com.javaharjoitustyo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KirjastoRESTController {
    private Kirjasto kirjasto;
    
    public KirjastoRESTController() {
        kirjasto = new Kirjasto();
    }

    private List<Asiakas> asiakkaat = new ArrayList<>();

    // REST-rajapinta, jolla lisätään uusi asiakas
    @PostMapping("/asiakkaat")
    public Asiakas addAsiakas(@RequestBody Asiakas asiakas) {
        asiakkaat.add(asiakas);
        return asiakas;
    }

    // REST-rajapinta, jolla haetaan kaikki asiakkaat
    @GetMapping("/asiakkaat")
    public List<Asiakas> haeKaikkiAsiakkaat() {
        return asiakkaat;
    }

    // REST-rajapinta, jolla haetaan asiakkaan tiedot
    @GetMapping("/asiakas/{nimi}")
    public Asiakas haeAsiakas(@PathVariable String nimi) {
        for (Asiakas asiakas : asiakkaat) {
            if (asiakas.getNimi().equals(nimi)) {
                return asiakas;
            }
        }
        return null;
    }
        /*@GetMapping("/asiakas/{nimi}")
        public List<String> getLainatutKirjat(@PathVariable String nimi) {
            Asiakas asiakas = kirjasto.getAsiakas(nimi);
            return asiakas.getLainatutKirjat();
        }*/
    
    
    @GetMapping("/kirjat")
    public List<Kirja> getKirjat() {
        return kirjasto.getKirjat();
    }
    
    @PostMapping("/lisaaKirja")
    public void lisaaKirja(@RequestBody Kirja kirja) {
        kirjasto.lisaaKirja(kirja);
    }
    
    @DeleteMapping("/poistaKirja/{nimi}")
    public void poistaKirja(@PathVariable String nimi) {
        for (Kirja kirja : kirjasto.getKirjat()) {
            if (kirja.getNimi().equals(nimi)) {
                kirjasto.poistaKirja(kirja);
                break;
            }
        }
    }
    @PostMapping("/lainaa")
    public ResponseEntity<Object> lainaaKirja(@RequestParam String asiakasNimi, @RequestParam String kirjanNimi) {
    Asiakas asiakas = null;
    for (Asiakas a : asiakkaat) {
        if (a.getNimi().equals(asiakasNimi)) {
            asiakas = a;
            break;
        }
    }
    if (asiakas == null) {
        return ResponseEntity.badRequest().body("Asiakasta ei löydy");
    }

    Kirja kirja = kirjasto.getKirja(kirjanNimi);
    if (kirja == null) {
        return ResponseEntity.badRequest().body("Kirjaa ei löydy");
    }
    if (kirja.onkoLainattu()) {
        return ResponseEntity.badRequest().body("Kirja on jo lainassa");
    }

    asiakas.lainaaKirja(kirja);
    kirja.asetaLainattu(true);
    return ResponseEntity.ok("Kirja lainattu onnistuneesti");
}    /*@PostMapping("/lainaa")
    public void lainaaKirja(@RequestParam String kirjanNimi, @RequestParam String asiakasNimi) {
    Asiakas asiakas = kirjasto.getAsiakas(asiakasNimi);
    Kirja kirja = kirjasto.getKirja(kirjanNimi);
    asiakas.lainaaKirja(kirja);
}*/
}


