package postavy;

import herni_svet.Svet;
import predmety.Predmet;

import java.util.HashMap;
import java.util.Scanner;

public class Obchodnik extends Postava {

    private HashMap<String, Integer> predmety;
    Scanner sc = new Scanner(System.in);

    public Obchodnik(int ID, String jmeno, String dialog, int misto) {
        super(ID, jmeno, dialog, misto);
        predmety = new HashMap<>(predmety);
    }


    public void obchod(Hrac hrac, Svet svet) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vitej v obchode! Nabizime nasledujici predmety:");
        for (Predmet predmet : svet.getPredmety()) {
            if (predmet.getMisto() == svet.getPoziceHrace()) {
                System.out.println("- " + predmet.getJmeno() + " (" + predmet.getPopis() + ") za 5 vlcich kosti");
            }
        }

        System.out.println("Napis nazev predmetu, ktery chces koupit, nebo 'konec' pro ukonceni:");
        String volba = sc.nextLine().toLowerCase();

        if (volba.equals("konec")) {
            System.out.println("Obchod ukoncen.");
            return;
        }

        for (Predmet predmet : svet.getPredmety()) {
            if (predmet.getJmeno().equalsIgnoreCase(volba) && predmet.getMisto() == svet.getPoziceHrace()) {
                int cena = 3;

                if (hrac.getVlciKosti() >= cena) {
                    hrac.setVlciKosti(hrac.getVlciKosti() - cena);
                    hrac.getInventar().pridaniPredmetu(predmet);
                    System.out.println("Zakoupil jsi: " + predmet.getJmeno());
                    return;
                } else {
                    System.out.println("Nemas dost vlcich kosti!");
                    return;
                }
            }
        }

        System.out.println("Tento predmet neni v nabidce.");
    }


}
