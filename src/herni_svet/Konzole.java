package herni_svet;

import command.*;
import postavy.Hrac;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Trida Konzole je hlavni herni rozhrani pro komunikaci s hracem.
 *
 * @author Tomas Voborny
 */
public class Konzole {

    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> prikazy;


    /**
     * Metoda pro inicializaci hry a vytvoreni dostupnych prikazu.
     *
     * @param svet Svet, kde probiha hra
     */
    public void inicializace(Svet svet) {
        Hrac hrac = new Hrac(svet.getPoziceHrace());
        hrac.setAktualniMistnost(0);
        Bludiste bludiste = new Bludiste(hrac, svet);
        prikazy = new HashMap<>();
        prikazy.put("exit", new Exit());
        prikazy.put("napoveda", new Napoveda(svet));
        prikazy.put("pomoc", new Pomoc());
        prikazy.put("pouzit", new Pouzit(hrac, svet));
        prikazy.put("prozkoumej", new Prozkoumej(svet));
        prikazy.put("vyber", new Vyber(hrac));
        prikazy.put("vzit", new Vzit(svet, hrac));
        prikazy.put("zahod", new Zahod(hrac, svet));
        prikazy.put("inventar", new UkazInventar(hrac));
        prikazy.put("jdido", new JdiDo(svet, bludiste));
        prikazy.put("interakce", new Interakce(hrac, svet));
        prikazy.put("mluv", new Mluv(svet));
    }

    /**
     * Metoda pro provedeni prikazu zadaneho hracem.
     */
    public void provedPrikaz() {
        System.out.println(">");
        String prikaz = sc.next();
        if (prikazy.containsKey(prikaz)) {
            System.out.println(prikazy.get(prikaz).execute(sc));
            exit = prikazy.get(prikaz).exit();
        } else {
            System.out.println("Neplatny prikaz!");
        }
    }

    /**
     * Metoda pro spusteni cele hry.
     */
    public void start() {
        Svet svet = new Svet();
        inicializace(svet);
        System.out.println(svet.nacteniPribehu());

        do{
            provedPrikaz();
        }while(exit != true);
    }


}
