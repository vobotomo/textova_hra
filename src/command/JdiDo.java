package command;

import herni_svet.Bludiste;
import herni_svet.Svet;

import java.util.Scanner;

/**
 * Trida pro presun do jine mistnosti ve hre.
 *
 * @author Tomas Voborny
 */
public class JdiDo implements Command {


    private Svet svet;
    private Bludiste bludiste;

    public JdiDo(Svet svet, Bludiste bludiste) {
        this.svet = svet;
        this.bludiste = bludiste;
    }

    /**
     * Provadi presun hrace do zadane mistnosti podle indexu.
     * Pokud je index 6, spusti se bludiste.
     *
     * @param sc Scanner pro cteni vstupu od uzivatele
     * @return Vysledek presunu do mistnosti nebo zprava o chybe
     */
    @Override
    public String execute(Scanner sc) {
        System.out.println("Zadej index mistnosti." + "\n" + ">");
        int index = -1;

        while (true) {
            if (sc.hasNextInt()) {
                index = sc.nextInt();
                break;
            } else {
                System.out.println("To není platný index. Zadejte celé číslo.");
                sc.next();
            }
        }

        String jmenoMistnosti = "";
        if(index == 6){
            return bludiste.spustit();
        }
        if (svet.presunout(index)) {
            jmenoMistnosti += svet.getSvet().get(index).getJmeno();
            return "Presunuli jste se do mistnosti " + jmenoMistnosti;
        }else {
            return "Presun neni mozny.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }

}
