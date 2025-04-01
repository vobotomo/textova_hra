package command;


import herni_svet.Svet;
import postavy.Hrac;

import java.util.Scanner;

/**
 * Trida, ktera umoznuje hraci vzit predmet v dane mistnosti.
 *
 * @author Tomas Voborny
 */
public class Vzit implements Command {
    private Hrac hrac;
    private Svet svet;

    public Vzit(Svet svet, Hrac hrac) {
        this.hrac = hrac;
        this.svet = svet;
    }

    /**
     * Provadi akci pro zvednuti predmetu, pokud se nachazi v mistnosti, kde se
     * hrac nachazi, a pridani do jeho inventare.
     *
     * @param sc Scanner pro cteni vstupu od uzivatele
     * @return Zprava o tom, zda byl predmet pridan do inventare, nebo ze
     *         predmet v mistnosti neni
     */
    @Override
    public String execute(Scanner sc) {
        for (int i = 0; i < svet.getPredmety().size(); i ++) {
            if (svet.getPoziceHrace() == svet.getPredmety().get(i).getMisto()) {
                hrac.getInventar().pridaniPredmetu(svet.getPredmety().get(i));
                return "Predmet " + svet.getPredmety().get(i).getJmeno() + " byl pridan do inventare.";
            }

        }

        return "V mistnosti se zadny predmet nenachazi.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
