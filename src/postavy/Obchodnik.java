package postavy;

import herni_svet.Svet;
import predmety.Predmet;

import java.util.Scanner;

public class Obchodnik extends Postava {

    Scanner sc = new Scanner(System.in);

    public Obchodnik(int ID, String jmeno, String dialog, int misto) {
        super(ID, jmeno, dialog, misto);
    }


    public String obchod(Hrac hrac, Svet svet) {
        for(Postava postava : svet.getPostavy()){
            if(svet.getPoziceHrace()== postava.getMisto()){
                postava.getDialog();
            }
        }
        for (Predmet predmet : svet.getPredmety()) {
            if (predmet.getMisto() == svet.getPoziceHrace()) {
                System.out.println("- " + predmet.getJmeno() + " (" + predmet.getPopis() + ") za 5 vlcich kosti");
            }
        }

        System.out.println("Napis nazev predmetu, ktery chces koupit, nebo 'konec' pro ukonceni:");
        String volba = sc.nextLine().toLowerCase();

        if (volba.equals("konec")) {
            return "Obchod ukoncen.";
        }

        for (Predmet predmet : svet.getPredmety()) {
            if (predmet.getJmeno().equalsIgnoreCase(volba) && predmet.getMisto() == svet.getPoziceHrace()) {
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
