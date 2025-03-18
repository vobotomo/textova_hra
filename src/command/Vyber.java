package command;

import postavy.Hrac;
import predmety.Zbran;

import java.util.Scanner;

public class Vyber implements Command {
    private Hrac hrac;
    private Scanner sc = new Scanner(System.in);

    public Vyber(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String execute() {
        System.out.println("Jakou zbran chces vybrat?" + "\n" + ">");
        String odpoved = sc.next();

        for (int i = 0; i < hrac.getInventar().getInventar().size(); i++) {
            if (odpoved.equals(hrac.getInventar().getInventar().get(i).getJmeno())) {
                Zbran vybranaZbran = (Zbran) hrac.getInventar().getInventar().get(i);

                vybranaZbran.setSilaHrace(hrac);

                return "Vybral jsi zbran: " + vybranaZbran.getJmeno() + ". Tvoje sila byla zvysena o " + vybranaZbran.getSila() + ".";
            }
        }

        return "Tuto zbran v inventari nemas.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
