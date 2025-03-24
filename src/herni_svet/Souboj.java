package herni_svet;

import postavy.Hrac;
import postavy.Nepritel;

import java.util.Random;
import java.util.Scanner;

public class Souboj {

    private Hrac hrac;
    private Nepritel nepritel;
    private Scanner sc;

    public Souboj(Hrac hrac, Nepritel nepritel) {
        this.hrac = hrac;
        this.nepritel = nepritel;
        this.sc = new Scanner(System.in);
    }

    public void zahajitSouboj() {
        System.out.println("Narazil jsi na nepritele: " + nepritel.getJmeno());
        System.out.println(nepritel.getDialog());

        while (hrac.getZivoty() > 0 && nepritel.getZivoty() > 0) {
            System.out.println("\nTvoje zivoty: " + hrac.getZivoty() + " | Zivoty nepritele: " + nepritel.getZivoty());
            System.out.println("Vyber akci: 1. Utok | 2. Obrana | 3. Pouzit predmet");
            int volba = sc.nextInt();

            if (volba == 1) {
                int hracUtok = hrac.getSila();
                nepritel.setZivoty(nepritel.getZivoty() - hracUtok);
                System.out.println("Zautocil jsi a zpusobil " + hracUtok + " poskozeni.");
            } else if (volba == 2) {
                System.out.println("Pripravil jsi se na obranu! Poškození nepritele se sníží.");
            } else if (volba == 3) {
                System.out.println("Pouziti predmetu zatim neni implementovano.");
            }

            if (nepritel.getZivoty() > 0) {
                Random random = new Random();
                int nepritelVolba;
                if (random.nextInt(10) < 7) {
                    nepritelVolba = 1;
                } else {
                    nepritelVolba = 2;
                }
                if (nepritelVolba == 1) {
                    int nepritelUtok = nepritel.getSila();
                    if (volba == 2) {
                        nepritelUtok /= 2;
                    }
                    hrac.setZivoty(hrac.getZivoty() - nepritelUtok);
                    System.out.println("Nepritel zautocil a zpusobil " + nepritelUtok + " poskozeni.");
                } else {
                    System.out.println("Nepritel se pripravil na obranu.");
                }
            }
        }

        if (hrac.getZivoty() > 0) {
            System.out.println("Vitezstvi! Porazil jsi " + nepritel.getJmeno());
        } else {
            System.out.println("Prohral jsi... Nepritel te premohl.");
        }
    }
}