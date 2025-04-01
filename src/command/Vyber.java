package command;

import postavy.Hrac;
import predmety.Zbran;

import java.util.Scanner;

/**
 * Trida, ktera umozni hraci vybrat jeho zbran.
 *
 * @author Tomas Voborny
 */
public class Vyber implements Command {
    private Hrac hrac;

    public Vyber(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Provadi akci pro vybrani zbrane z inventare hrace a zmeni hracovu silu, podle dane zbrane.
     *
     * @param sc Scanner pro cteni vstupu od uzivatele
     * @return Zprava o vybrane zbrani a zvysene sile hrace, nebo informace,
     *         ze zbran neni v inventari
     */
    @Override
    public String execute(Scanner sc) {
        if(hrac.getInventar().getInventar().isEmpty()){
            return "Inventar je prazdny.";
        }


        System.out.println("Jakou zbran chces vybrat?" + "\n" + ">");
        String odpoved = sc.next();

        for (int i = 0; i < hrac.getInventar().getInventar().size(); i++) {
            if (odpoved.equalsIgnoreCase(hrac.getInventar().getInventar().get(i).getJmeno())) {
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
