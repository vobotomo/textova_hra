package command;

import herni_svet.Svet;
import postavy.Hrac;
import predmety.Klic;
import predmety.Predmet;

import java.util.Scanner;

/**
 * Trida umoznujici hraci zahodit predmet z inventare.
 *
 * @author Tomas Voborny
 */
public class Zahod implements Command {
    private Hrac hrac;
    private Svet svet;

    public Zahod(Hrac hrac, Svet svet) {
        this.hrac = hrac;
        this.svet = svet;
    }

    /**
     * Provadi akci pro zahodeni predmetu z inventare a jeho umisteni do
     * mistnosti, kde se hrac nachazi. Pokud je predmet klic, zavola se metoda
     * pro zamknuti tajemneho chramu.
     *
     * @param sc Scanner pro cteni vstupu od uzivatele
     * @return Zprava o tom, zda byl predmet zahoden nebo zda nebyl nalezen
     *         v inventari
     */
    @Override
    public String execute(Scanner sc) {
        if(hrac.getInventar().getInventar().isEmpty()){
            return "Inventar je prazdny.";
        }


        System.out.println("Zadej jmeno predmetu, ktery chces zahodit." + "\n" + ">");
        String odpoved = sc.next();


        for (int i = 0; i < hrac.getInventar().getInventar().size(); i ++) {
            Predmet predmet = hrac.getInventar().getInventar().get(i);
            if(odpoved.equalsIgnoreCase(predmet.getJmeno())) {
                predmet.setMisto(svet.getPoziceHrace());
                svet.getPredmety().add(predmet);

                Predmet predmet1 = hrac.getInventar().getInventar().get(i);
                hrac.getInventar().getInventar().remove(i);


                if (predmet1 instanceof Klic) {
                    svet.zamknoutTajemnyChram();
                }

                return "Zahodil jsi " + predmet1.getJmeno();
            }
        }

        return "Tento predmet bud nemas, anebo jsi ho napsal spatne.";
    }



    @Override
    public boolean exit() {
        return false;
    }
}
