package command;

import postavy.Hrac;

import java.util.Scanner;

public class Zahod implements Command {
    private Hrac hrac;
    private Scanner sc = new Scanner(System.in);

    public Zahod(Hrac hrac) {
        this.hrac = hrac;
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
        }

        return "Tento predmet bud nemas, anebo jsi ho napsal spatne.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
