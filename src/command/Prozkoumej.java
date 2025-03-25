package command;

import herni_svet.Svet;

public class Prozkoumej implements Command {
    private Svet svet;


    public Prozkoumej(Svet svet) {
        this.svet = svet;
    }

    @Override
    public String execute() {
        String a = "";
        int pocet = 0;
        for (int i = 0; i < svet.getPredmety().size(); i ++) {
            if (svet.getPoziceHrace()==svet.getPredmety().get(i).getID()){
                a += ("V tehle mistnosti se nachazi " + svet.getPredmety().get(i).getJmeno() + "\n");
                pocet++;
            }
            if (svet.getPoziceHrace()==svet.getPostavy().get(i).getID()){
                a += ("V tehle mistnosti se nachazi " + svet.getPredmety().get(i).getJmeno() + "\n");
                pocet++;
            }
        }
        if(pocet == 0){
            return "V mistnosti se nenachazi zadne predmety ani postavy.";
        }
        return a;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
