package testy;

import herni_svet.Svet;
import postavy.Hrac;
import postavy.Obchodnik;
import postavy.Postava;
import command.Interakce;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import predmety.Predmet;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InterakceTest {
    private Hrac hrac;
    private Svet svet;
    private Interakce interakce;

    @BeforeEach
    void setUp() {
        svet = new Svet();
        hrac = new Hrac(svet.getPoziceHrace());
        svet.setPoziceHrace(1);
        interakce = new Interakce(hrac, svet);
    }

    @Test
    void testInterakceSNepritelem() {
        String simulatedInput = "ne\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner sc = new Scanner(in);

        String vysledek = interakce.execute(sc);

        assertEquals("Rozhodl ses neutocit a ustoupit.", vysledek);
    }

    @Test
    void testInterakceSObchodnikem() {
        Obchodnik obchodnik = new Obchodnik(1, "Vila", "ahoj", 4);
        Predmet predmet = new Predmet(1, "Lektvar odvahy", " ", 4);
        svet.getPostavy().add(obchodnik);
        svet.getPredmetyObchod().add(predmet);
        svet.setPoziceHrace(4);
        hrac.setVlciKosti(3);

        InputStream originalIn = System.in;
        ByteArrayInputStream testInput = new ByteArrayInputStream("ano\nLektvar odvahy\n".getBytes());
        System.setIn(testInput);

        Scanner scanner = new Scanner(System.in);
        String vysledek = interakce.execute(scanner);

        System.setIn(originalIn);

        assertEquals("Zakoupil jsi: Lektvar odvahy", vysledek);
    }

    @Test
    void testZadnaPostavaVMistnosti() {
        svet.setPoziceHrace(99);
        String vysledek = interakce.execute(new Scanner(System.in));
        assertEquals("V mistnosti neni zadna postava, se kterou bys mohl interagovat.", vysledek);
    }

    private void nastavitVstup(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        System.setIn(stdin);
    }
}