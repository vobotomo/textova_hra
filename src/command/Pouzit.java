package command;

import herni_svet.Svet;
import postavy.Hrac;
import predmety.Prut;
import predmety.Ryby;

import java.util.Scanner;

/**
 * Trida, ktera hraci umozni pouzit predmet.
 *
 * @author Tomas Voborny
 */
public class Pouzit implements Command {
    private Hrac hrac;
    private Svet svet;

    public Pouzit(Hrac hrac, Svet svet) {
        this.hrac = hrac;
        this.svet = svet;
    }


    /**
     * Provadi akci pri pouziti predmetu z inventare hrace.
     *
     * @param sc Scanner pro cteni vstupu od uzivatele
     * @return Vysledek akce, zda se predmet podarilo pouzit nebo ne.
     */
    @Override
    public String execute(Scanner sc) {
        if(hrac.getInventar().getInventar().isEmpty()){
            return "Inventar je prazdny.";
        }


        System.out.println("Zadej jmeno predmetu, ktery chces pouzit." + "\n" + ">");
        switch(sc.next()){
            case "prut":
                if(!(svet.getPoziceHrace()==5)){
                    return "Prut nelze pouzit. Hrac je ve spatne mistnost.";
                }

                for(int i = 0; i < hrac.getInventar().getInventar().size(); i++){
                    if(hrac.getInventar().getInventar().get(i) instanceof Prut){
                        hrac.getInventar().getInventar().remove(i);
                        hrac.getInventar().getInventar().add(svet.getPredmety().get(4));
                        return "Prut byl pouzit.";
                    }
                }
            case "ryba":
                for(int i = 0; i < hrac.getInventar().getInventar().size(); i++){
                    if(hrac.getInventar().getInventar().get(i) instanceof Ryby){
                        ((Ryby) hrac.getInventar().getInventar().get(i)).setZivotyHrace(hrac);
                        return "Ryba byla snezena.";
                    }
                }
            default:
                return "Tento predmet neexistuje.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
