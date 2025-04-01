package testy;

import herni_svet.Svet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovaci trida pro tridu Svet.
 *
 *  @author Tomas Voborny
 */
public class SvetTest {

    private Svet svet;

    @BeforeEach
    public void setUp() {
        svet = new Svet();
    }

    /**
     * Testuje, ze svet neni prazdny po nacteni mapy.
     * Ocekava, ze mapa obsahuje alespon jednu mistnost.
     */
    @Test
    public void testNacteniMapy() {
        assertFalse(svet.getSvet().isEmpty());
    }

    /**
     * Testuje, ze seznam predmetu neni prazdny.
     * Ocekava, ze svet obsahuje alespon jeden predmet.
     */
    @Test
    public void testNacteniPredmetu() {
        assertNotNull(svet.getPredmety());
        assertTrue(svet.getPredmety().size() > 0);
    }

    /**
     * Testuje, ze seznam postav neni prazdny.
     * Ocekava, ze svet obsahuje alespon jednu postavu.
     */
    @Test
    public void testNacteniPostav() {
        assertNotNull(svet.getPostavy());
        assertTrue(svet.getPostavy().size() > 0);
    }

    /**
     * Testuje, ze presunuti hrace do jine mistnosti je mozne.
     * Ocekava, ze presunuti do zadane mistnosti probehne uspesne.
     */
    @Test
    public void testPresunout() {
        int cilovaMistnost = 1;
        boolean presun = svet.presunout(cilovaMistnost);
        assertTrue(presun);
    }


}