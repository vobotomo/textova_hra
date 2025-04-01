package testy;

import herni_svet.Souboj;
import herni_svet.Svet;
import org.junit.jupiter.api.Test;
import postavy.Hrac;
import postavy.Nepritel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class SoubojTest {

    @Test
    public void testZahajitSouboj() {
        Nepritel nepritel = new Nepritel(1, "Obr", "", 1, 10, 20);
        Svet svet = new Svet();
        Hrac hrac = new Hrac(svet.getPoziceHrace());
        Scanner sc = new Scanner(System.in);
        Souboj souboj = new Souboj(hrac, nepritel, svet);

        String simulatedInput = "1\n1\n1\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        sc = new Scanner(in);

        String vysledek = souboj.zahajitSouboj(sc);

        assertTrue(vysledek.contains("Vitezstvi!"));
        assertEquals(0, nepritel.getZivoty());
    }
}