package command;

import herni_svet.Bludiste;
import herni_svet.Svet;

import java.util.Scanner;

public class JdiDo implements Command {


    Scanner sc = new Scanner(System.in);
    private Svet svet;
    private Bludiste bludiste;

    public JdiDo(Svet svet, Bludiste bludiste) {
        this.svet = svet;
        this.bludiste = bludiste;
    }

    @Override
    public String execute() {
        System.out.println("Zadej index mistnosti." + "\n" + ">");
        int index = sc.nextInt();
        String jmenoMistnosti = "";
        if(index == 6){
            bludiste.spustit();
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
