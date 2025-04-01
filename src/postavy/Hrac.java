package postavy;
import predmety.Inventar;


/**
 * Trida Hrac reprezentuje hrace ve hre.
 *
 * @author Tomas Voborny
 */
public class Hrac {

    private int sila;
    private int zivoty;
    private Inventar inventar;
    private int aktualniMistnost;
    private int vlciKosti;

    /**
     * Konstruktor tridy Hrac, ktery inicializuje hrace se zakladnemi atributy.
     *
     * @param mistnost ID mistnosti, kde se hrac nachazi pri vytvoreni.
     */
    public Hrac(int mistnost) {
        this.zivoty = 100;
        this.sila = 10;
        this.inventar = new Inventar();
        this.aktualniMistnost = mistnost;
        this.vlciKosti = 0;
        inventar = new Inventar();
    }



    public int getSila() {
        return sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public int getZivoty() {
        return zivoty;
    }

    public int getVlciKosti() {
        return vlciKosti;
    }

    public void setVlciKosti(int vlciKosti) {
        this.vlciKosti = vlciKosti;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }

    public Inventar getInventar() {
        return inventar;
    }

    public int getAktualniMistnost() {
        return aktualniMistnost;
    }

    public void setAktualniMistnost(int aktualniMistnost) {
        this.aktualniMistnost = aktualniMistnost;
    }
}
