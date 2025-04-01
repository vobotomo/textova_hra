package postavy;

import herni_svet.Svet;
import predmety.Predmet;

import java.util.Scanner;

public class Obchodnik extends Postava {

    public Obchodnik(int ID, String jmeno, String dialog, int misto) {
        super(ID, jmeno, dialog, misto);
    }


    public String obchod(Hrac hrac, Svet svet, Scanner sc) {
        for(Postava postava : svet.getPostavy()){
            if(svet.getPoziceHrace()== postava.getMisto()){
                postava.getDialog();
            }
        }
        for (Predmet predmet : svet.getPredmetyObchod()) {
            if (predmet.getMisto() == svet.getPoziceHrace()) {
                System.out.println("- " + predmet.getJmeno() + " (" + predmet.getPopis() + ") za 3 vlci kosti");
            }
        }

        System.out.println("Napis nazev predmetu, ktery chces koupit, nebo 'konec' pro ukonceni:");
        String volba = sc.nextLine();

        if (volba.equalsIgnoreCase("konec")) {
            return "Obchod ukoncen.";
        }

        for (Predmet predmet : svet.getPredmetyObchod()) {
            if (volba.equalsIgnoreCase(predmet.getJmeno())) {
                int cena = 3;

                if (hrac.getVlciKosti() >= cena) {
                    hrac.setVlciKosti(hrac.getVlciKosti() - cena);
                    hrac.getInventar().pridaniPredmetu(predmet);
                    return "Zakoupil jsi: " + predmet.getJmeno();

                } else {
                    return "Nemas dost vlcich kosti!";
                }
            }
        }

        return "Tento predmet neni v nabidce.";
    }


}
