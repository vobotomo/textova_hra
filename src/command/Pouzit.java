package command;

import herni_svet.Svet;
import postavy.Hrac;
import predmety.Klic;
import predmety.Prut;

import java.util.Scanner;

public class Pouzit implements Command {
    private Hrac hrac;
    private Svet svet;

    public Pouzit(Hrac hrac, Svet svet) {
        this.hrac = hrac;
        this.svet = svet;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        switch(sc.next()){
            case "klic":
                    for(int i = 0; i < hrac.getInventar().getInventar().size(); i++){
                        if(hrac.getInventar().getInventar().get(i) instanceof Klic){
                            svet.odemknoutTajemnyChram();
                            hrac.getInventar().getInventar().remove(i);
                            return "Klic byl pouzit.";
                        }
                    }
                break;
            case "prut":
                for(int i = 0; i < hrac.getInventar().getInventar().size(); i++){
                    if(hrac.getInventar().getInventar().get(i) instanceof Prut){
                        //pouzit prut
                        hrac.getInventar().getInventar().remove(i);
                        return "Prut byl pouzit.";
                    }
                }
            case "ryba":
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
