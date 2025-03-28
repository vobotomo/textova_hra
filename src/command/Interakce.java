package command;

import herni_svet.Souboj;
import postavy.Hrac;
import postavy.Nepritel;
import postavy.Obchodnik;
import postavy.Postava;
import herni_svet.Svet;
import java.util.Scanner;
import java.util.ArrayList;

public class Interakce implements Command {

    private Hrac hrac;
    private Svet svet;
    private Scanner scanner = new Scanner(System.in);

    public Interakce(Hrac hrac, Svet svet) {
        this.hrac = hrac;
        this.svet = svet;
    }

    @Override
    public String execute() {
        Postava nalezenaPostava = null;

        for (Postava postava : svet.getPostavy()) {
            if (postava.getMisto() == svet.getPoziceHrace()) {
                nalezenaPostava = postava;
                break;
            }
        }

        if (nalezenaPostava == null) {
            return "V mistnosti neni zadna postava, se kterou bys mohl interagovat.";
        }

        System.out.println("Narazil jsi na: " + nalezenaPostava.getJmeno());

        if (nalezenaPostava instanceof Nepritel) {
            System.out.println(nalezenaPostava.getJmeno() + " se chysta zautocit!");
            System.out.println("Chces bojovat? (ano/ne)");
            String odpoved = scanner.nextLine().toLowerCase();

            if (odpoved.equals("ano")) {
                new Souboj(hrac, (Nepritel) nalezenaPostava, svet).zahajitSouboj();;
            } else {
                return "Rozhodl ses neutocit a ustoupit.";
            }
        } else if (nalezenaPostava instanceof Obchodnik) {
            System.out.println(nalezenaPostava.getJmeno() + " je obchodnik.");
            System.out.println("Chces neco koupit? (ano/ne)");
            String odpoved = scanner.nextLine().toLowerCase();

            if (odpoved.equals("ano")) {
                return ((Obchodnik) nalezenaPostava).obchod(hrac, svet);
            } else {
                return "Rozhodl sis nic nekoupit.";
            }
        } else {
            return nalezenaPostava.getDialog();
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
