package testy;

import command.Zahod;
import herni_svet.Svet;
import postavy.Hrac;
import predmety.Klic;
import predmety.Predmet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

/**
 * Testovaci trida pro tridu Zahod.
 *
 *  @author Tomas Voborny, ChatGPT pomohlo s praci se scannerem
 */
public class ZahodTest {
    private Hrac hrac;
    private Svet svet;
    private Zahod zahod;

    @BeforeEach
    void setUp() {
        svet = new Svet();
        hrac = new Hrac(svet.getPoziceHrace());
        zahod = new Zahod(hrac, svet);
    }

    /**
     * Testuje, ze predmet je uspesne zahozen, odstraneny z inventare.
     */
    @Test
    void testZahodPredmetUspech() {
        Predmet predmet = new Predmet(1, "Mec", "Silna zbran", 0);
        hrac.getInventar().pridaniPredmetu(predmet);

        Scanner sc = new Scanner(new ByteArrayInputStream("Mec\n".getBytes()));

        String result = zahod.execute(sc);
        assertEquals("Zahodil jsi Mec", result);
        assertFalse(hrac.getInventar().getInventar().contains(predmet), "Predmet by mel byt odstranen z inventare.");
        assertTrue(svet.getPredmety().contains(predmet), "Predmet by mel byt pridan do sveta.");
    }

    /**
     * Testuje, ze se vypise zprava, pokud se hrac pokusi zahodit predmet, ktery se nenachazi v inventari.
     */
    @Test
    void testZahodNeexistujiciPredmet() {
        Scanner sc = new Scanner(new ByteArrayInputStream("NehmotnyMec\n".getBytes()));

        String result = zahod.execute(sc);
        assertEquals("Inventar je prazdny.", result);
    }

    /**
     * Testuje, ze po zahodeni zamykaciho klice je tajemny chram pro hrace nedostupny.
     */
    @Test
    void testZahodZamykaciKlic() {
        Klic klic = new Klic(2, "Klic", "Odemkne chram", 0);
        hrac.getInventar().pridaniPredmetu(klic);

        Scanner sc = new Scanner(new ByteArrayInputStream("Klic\n".getBytes()));

        String result = zahod.execute(sc);
        assertEquals("Zahodil jsi Klic", result);
        assertEquals(svet.zamknoutTajemnyChram(), "Tajemny chram je opet nepristupny.");
    }

    /**
     * Testuje, ze se vypise zprava, pokud je inventar prazdny.
     */
    @Test
    void testZahodPrazdnyInventar() {
        Scanner sc = new Scanner(new ByteArrayInputStream("Mec\n".getBytes()));

        String result = zahod.execute(sc);
        assertEquals("Inventar je prazdny.", result);
    }
}
