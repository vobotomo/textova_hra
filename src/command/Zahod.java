package command;

import herni_svet.Svet;
import postavy.Hrac;
import predmety.Klic;

import java.util.Scanner;

public class Zahod implements Command {
    private Hrac hrac;
    private Svet svet;
    private Scanner sc = new Scanner(System.in);

    public Zahod(Hrac hrac, Svet svet) {
        this.hrac = hrac;
        this.svet = svet;
    }

    @Override
    public String execute() {
        System.out.println("Zadej jmeno predmetu, ktery chces zahodit." + "\n" + ">");
        String odpoved = sc.next();


        for (int i = 0; i < hrac.getInventar().getInventar().size(); i ++) {
            if(odpoved.equals(hrac.getInventar().getInventar().get(i).getJmeno())) {
                hrac.getInventar().getInventar().remove(i);
                return "Zahodil jsi " + hrac.getInventar().getInventar().get(i).getJmeno();
            }

            if (hrac.getInventar().getInventar().get(i) instanceof Klic) {
                svet.zamknoutTajemnyChram();
            }
        }

        return "Tento predmet bud nemas, anebo jsi ho napsal spatne.";
    }



    @Override
    public boolean exit() {
        return false;
    }
}
