package predmety;

import postavy.Hrac;

/**
 * Trida reprezentujici zbran jako predmet, ktery muze byt pouzit k zvyseni sily hrace.
 * Dedici z tridy {@link Predmet}.
 */
public class Zbran extends Predmet {

    private int sila;

    public int getSila() {
        return sila;
    }


    public Zbran(int ID, String jmeno, String popis, int misto, int sila) {
        super(ID, jmeno, popis, misto);
        this.sila = sila;
    }

    /**
     * Zvysi silu hrace pri vybery zbrane.
     *
     * @param hrac hrac, ktery vybere zbran
     */
    public void setSilaHrace(Hrac hrac){
        hrac.setSila(hrac.getSila()+getSila());
    }
}
