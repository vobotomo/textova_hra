package testy;

import herni_svet.Svet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SvetTest {

    private Svet svet;

    @BeforeEach
    public void setUp() {
        svet = new Svet();
    }

    @Test
    public void testNacteniMapy() {
        assertFalse(svet.getSvet().isEmpty());
    }

    @Test
    public void testNacteniPredmetu() {
        assertNotNull(svet.getPredmety());
        assertTrue(svet.getPredmety().size() > 0);
    }

    @Test
    public void testNacteniPostav() {
        assertNotNull(svet.getPostavy());
        assertTrue(svet.getPostavy().size() > 0);
    }

    @Test
    public void testPresunout() {
        int cilovaMistnost = 1;
        boolean presun = svet.presunout(cilovaMistnost);
        assertTrue(presun);
    }


}