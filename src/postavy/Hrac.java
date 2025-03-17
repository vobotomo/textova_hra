package postavy;
import command.Inventar;


public class Hrac {

    private int sila;
    private int zivoty;
    private Inventar inventar;
    private int aktualniMistnost;
    private int vlciKosti;


    public Hrac(int mistnost) {
        this.zivoty = 100;
        this.sila = 10;
        this.inventar = new Inventar();
        this.aktualniMistnost = mistnost;
        this.vlciKosti = 0;
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

    public void setInventar(Inventar inventar) {
        this.inventar = inventar;
    }

    public int getAktualniMistnost() {
        return aktualniMistnost;
    }

    public void setAktualniMistnost(int aktualniMistnost) {
        this.aktualniMistnost = aktualniMistnost;
    }
}
