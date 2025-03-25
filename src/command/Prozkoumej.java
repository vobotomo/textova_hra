package command;

import herni_svet.Svet;
import postavy.Postava;
import predmety.Predmet;

public class Prozkoumej implements Command {
    private Svet svet;


    public Prozkoumej(Svet svet) {
        this.svet = svet;
    }

    @Override
    public String execute() {
        StringBuilder a = new StringBuilder();
        int pocet = 0;

        for (Predmet predmet : svet.getPredmety()) {
            if (svet.getPoziceHrace() == predmet.getMisto()) {
                a.append("V této místnosti se nachází předmět: ").append(predmet.getJmeno()).append("\n");
                pocet++;
            }
        }


        for (Postava postava : svet.getPostavy()) {
            if (svet.getPoziceHrace() == postava.getMisto()) {
                a.append("V této místnosti se nachází postava: ").append(postava.getJmeno()).append("\n");
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
