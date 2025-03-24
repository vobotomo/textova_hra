package command;

import herni_svet.Svet;
import postavy.Hrac;
import predmety.Klic;
import predmety.Prut;
import predmety.Ryby;

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
        System.out.println("Zadej jmeno predmetu, ktery chces pouzit." + "\n" + ">");
        switch(sc.next()){
            case "klic":
                if(!(svet.getPoziceHrace()==6)){
                    return "Hrac je ve spatne mistnosti. Klic nelze pouzit.";
                }

                    for(int i = 0; i < hrac.getInventar().getInventar().size(); i++){
                        if(hrac.getInventar().getInventar().get(i) instanceof Klic){
                            svet.odemknoutTajemnyChram();
                            hrac.getInventar().getInventar().remove(i);
                            return "Klic byl pouzit.";
                        }
                    }
                break;
            case "prut":
                if(!(svet.getPoziceHrace()==5)){
                    return "Prut nelze pouzit. Hrac je ve spatne mistnost.";
                }

                for(int i = 0; i < hrac.getInventar().getInventar().size(); i++){
                    if(hrac.getInventar().getInventar().get(i) instanceof Prut){
                        hrac.getInventar().getInventar().remove(i);
                        hrac.getInventar().getInventar().add(svet.getPredmety().get(5));
                        return "Prut byl pouzit.";
                    }
                }
            case "ryba":
                for(int i = 0; i < hrac.getInventar().getInventar().size(); i++){
                    if(hrac.getInventar().getInventar().get(i) instanceof Ryby){
                        ((Ryby) hrac.getInventar().getInventar().get(i)).setZivotyHrace(hrac);
                        return "Ryba byla snezena.";
                    }
                }
            default:
                return "Tento predmet neexistuje.";
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
