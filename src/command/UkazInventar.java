package command;

import postavy.Hrac;

import java.util.Scanner;

public class UkazInventar implements Command{

    private Hrac hrac;

    public UkazInventar(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String execute(Scanner sc) {
        String result = "";

        if (hrac.getInventar().getInventar().isEmpty()) {
            result = "Inventar je prazdny.";
        } else {
            result = "Inventar obsahuje:\n";
            for (int i = 0;i < hrac.getInventar().getInventar().size(); i ++) {
                result += hrac.getInventar().getInventar().get(i).getJmeno() + "\n";
            }
        }

        return result + "\n" + "Vlci kosti: " + hrac.getVlciKosti();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
