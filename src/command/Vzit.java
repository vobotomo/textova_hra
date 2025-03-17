package command;
import predmety.Predmet;

public class Vzit implements Command {
    private Inventar inventar;
    private Predmet predmet;

    public Vzit(Inventar inventar, Predmet predmet) {
        this.inventar = inventar;
        this.predmet = predmet;
    }

    @Override
    public String execute() {
        if (inventar.pridaniPredmetu(predmet)) {
            return "Predmet " + predmet.getJmeno() + " byl pridan do inventare.";
        } else {
            return "Predmet nelze vzit.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
