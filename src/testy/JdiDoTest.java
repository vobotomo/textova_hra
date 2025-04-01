package testy;

import command.JdiDo;
import herni_svet.Bludiste;
import herni_svet.Svet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import postavy.Hrac;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class JdiDoTest {
    private Svet svet;
    private Hrac hrac;
    private Bludiste bludiste;
    private JdiDo jdiDo;

    @BeforeEach
    void setUp() {
        svet = new Svet();
        hrac = new Hrac(svet.getPoziceHrace());
        bludiste = new Bludiste(hrac, svet);
        jdiDo = new JdiDo(svet, bludiste);
    }

    @Test
    void testPresunDoPlatneMistnosti() {
        svet.setPoziceHrace(0);
        Scanner sc = new Scanner(new ByteArrayInputStream("1\n".getBytes()));

        String result = jdiDo.execute(sc);
        assertEquals("Presunuli jste se do mistnosti " + svet.getSvet().get(1).getJmeno(), result);
        assertEquals(1, svet.getPoziceHrace());
    }

    @Test
    void testNeplatnyPresun() {
        svet.setPoziceHrace(0);
        Scanner sc = new Scanner(new ByteArrayInputStream("99\n".getBytes()));

        String result = jdiDo.execute(sc);
        assertEquals("Presun neni mozny.", result);
        assertEquals(0, svet.getPoziceHrace());
    }

    @Test
    void testNeplatnyVstup() {
        Scanner sc = new Scanner(new ByteArrayInputStream("abc\n1\n".getBytes()));

        String result = jdiDo.execute(sc);
        assertTrue(result.startsWith("Presunuli jste se do mistnosti"));
    }

    @Test
    void testBludisteBezKlice() {
        String simulatedInput = "vlevo\nvpravo\nvlevo\nvpravo\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sc = new Scanner(System.in);

        String result = bludiste.spustit();
        assertEquals("Dvere jsou zamcene! Potrebujes klic.", result);
    }
}
