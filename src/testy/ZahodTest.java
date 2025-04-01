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

    @Test
    void testZahodNeexistujiciPredmet() {
        Scanner sc = new Scanner(new ByteArrayInputStream("NehmotnyMec\n".getBytes()));

        String result = zahod.execute(sc);
        assertEquals("Inventar je prazdny.", result);
    }

    @Test
    void testZahodZamykaciKlic() {
        Klic klic = new Klic(2, "Klic", "Odemkne chram", 0);
        hrac.getInventar().pridaniPredmetu(klic);

        Scanner sc = new Scanner(new ByteArrayInputStream("Klic\n".getBytes()));

        String result = zahod.execute(sc);
        assertEquals("Zahodil jsi Klic", result);
        assertEquals(svet.zamknoutTajemnyChram(), "Tajemny chram je opet nepristupny.");
    }

    @Test
    void testZahodPrazdnyInventar() {
        Scanner sc = new Scanner(new ByteArrayInputStream("Mec\n".getBytes()));

        String result = zahod.execute(sc);
        assertEquals("Inventar je prazdny.", result);
    }
}
