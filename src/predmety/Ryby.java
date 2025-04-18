package predmety;

import postavy.Hrac;

/**
 * Trida reprezentujici ryby jako predmet, ktery muze byt pouzit k leceni.
 * Dedici z tridy {@link Predmet}.
 */
public class Ryby extends Predmet {

    private int zivoty;

    public Ryby(int ID, String jmeno, String popis, int misto, int zivoty) {
        super(ID, jmeno, popis, misto);
        this.zivoty = zivoty;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void setZivotyHrace(Hrac hrac){
        hrac.setZivoty(hrac.getZivoty()+getZivoty());
    }
}
