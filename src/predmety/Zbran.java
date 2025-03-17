package predmety;

public class Zbran extends Predmet {

    private int sila;

    public int getSila() {
        return sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public Zbran(int ID, String jmeno, String popis, int misto, int sila) {
        super(ID, jmeno, popis, misto);
        this.sila = sila;
    }
}
