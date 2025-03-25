package command;

import herni_svet.Svet;
import postavy.Hrac;
import predmety.Klic;
import predmety.Predmet;

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
