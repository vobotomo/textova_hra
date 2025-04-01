package command;

import herni_svet.Svet;
import postavy.Postava;
import predmety.Predmet;

import java.util.Scanner;

public class Prozkoumej implements Command {
    private Svet svet;


    public Prozkoumej(Svet svet) {
        this.svet = svet;
    }

    @Override
    public String execute(Scanner sc) {
        StringBuilder a = new StringBuilder();
        int pocet = 0;

        for (Predmet predmet : svet.getPredmety()) {
            if (svet.getPoziceHrace() == predmet.getMisto()) {
                a.append("V teto mistnosti se nachazi predmet: ").append(predmet.getJmeno()).append("\n");
                pocet++;
            }
        }


        for (Postava postava : svet.getPostavy()) {
            if (svet.getPoziceHrace() == postava.getMisto()) {
                a.append("V teto místnosti se nachazi postava: ").append(postava.getJmeno()).append("\n");
                pocet++;
            }
        }
        if(pocet == 0){
            return "V mistnosti se nenachazi zadne predmety ani postavy.";
        }
        return a.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
