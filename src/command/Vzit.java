package command;


import herni_svet.Svet;
import postavy.Hrac;

public class Vzit implements Command {
    private Hrac hrac;
    private Svet svet;

    public Vzit(Svet svet, Hrac hrac) {
        this.hrac = hrac;
        this.svet = svet;
    }

    @Override
    public String execute() {
        for (int i = 0; i < svet.getPredmety().size(); i ++) {
            if (svet.getPoziceHrace() == svet.getPredmety().get(i).getID()) {
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
