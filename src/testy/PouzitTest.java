package testy;

import command.Pouzit;
import herni_svet.Svet;
import postavy.Hrac;
import predmety.Predmet;
import predmety.Prut;
import predmety.Ryby;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PouzitTest {

    @Test
    public void testInventarJePrazdny() {
        Svet svet = new Svet();
        Hrac hrac = new Hrac(svet.getPoziceHrace());
        Pouzit pouzit = new Pouzit(hrac, svet);

        hrac.getInventar().getInventar().clear();

        Scanner sc = new Scanner("prut");

        String vysledek = pouzit.execute(sc);

        assertEquals("Inventar je prazdny.", vysledek);
    }

    @Test
    public void testPouzitPrutVeSpatneMistnosti() {
        Svet svet = new Svet();
        Hrac hrac = new Hrac(svet.getPoziceHrace());
        Pouzit pouzit = new Pouzit(hrac, svet);

        Prut prut = new Prut(2, "Prut", "", 4);
        hrac.getInventar().getInventar().add(prut);

        svet.setPoziceHrace(4);

        Scanner sc = new Scanner("prut");

        String vysledek = pouzit.execute(sc);

        assertEquals("Prut nelze pouzit. Hrac je ve spatne mistnost.", vysledek);
    }

    @Test
    public void testPouzitPrutVeSpravneMistnosti() {
        Svet svet = new Svet();
        Hrac hrac = new Hrac(svet.getPoziceHrace());
        Pouzit pouzit = new Pouzit(hrac, svet);

        Prut prut = new Prut(2, "Prut", "", 4);
        hrac.getInventar().pridaniPredmetu(prut);

        svet.setPoziceHrace(5);

        Scanner sc = new Scanner("prut");

        String vysledek = pouzit.execute(sc);

        assertEquals("Prut byl pouzit.", vysledek);
    }

    @Test
    public void testPouzitRybu() {
        Svet svet = new Svet();
        Hrac hrac = new Hrac(svet.getPoziceHrace());
        Pouzit pouzit = new Pouzit(hrac, svet);

        Ryby ryba = new Ryby(5, "ryby", "", 5, 15);
        hrac.getInventar().pridaniPredmetu(ryba);

        Scanner sc = new Scanner("ryba");

        String vysledek = pouzit.execute(sc);

        assertEquals("Ryba byla snezena.", vysledek);
    }

    @Test
    public void testPouzitNeznamyPredmet() {
        Svet svet = new Svet();
        Hrac hrac = new Hrac(svet.getPoziceHrace());
        Pouzit pouzit = new Pouzit(hrac, svet);

        Prut prut = new Prut(2, "Prut", "", 4);
        hrac.getInventar().pridaniPredmetu(prut);

        Scanner sc = new Scanner("neexistujiciPredmet");

        String vysledek = pouzit.execute(sc);

        assertEquals("Tento predmet neexistuje.", vysledek);
    }
}