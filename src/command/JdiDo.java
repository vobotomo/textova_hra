package command;

import herni_svet.Svet;

import java.util.Scanner;

public class JdiDo implements Command {


    Scanner sc = new Scanner(System.in);
    private Svet svet;

    public JdiDo(Svet svet) {
        this.svet = svet;
    }

    @Override
    public String execute() {
        System.out.println("Zadej index mistnosti." + "\n" + ">");
        int index = sc.nextInt();
        String jmenoMistnosti = "";
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
