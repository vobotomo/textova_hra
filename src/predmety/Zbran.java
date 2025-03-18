package predmety;

import postavy.Hrac;

public class Zbran extends Predmet {

    private int sila;

    public int getSila() {
        return sila;
    }


    public Zbran(int ID, String jmeno, String popis, int misto, int sila) {
        super(ID, jmeno, popis, misto);
        this.sila = sila;
    }


    public void seSilaHrace(Hrac hrac){
        hrac.setSila(hrac.getSila()+getSila());
    }
}
