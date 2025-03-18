package herni_svet;

import command.*;
import postavy.Hrac;
import postavy.Postavy;
import predmety.Predmety;

import java.util.HashMap;
import java.util.Scanner;

public class Konzole {

    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> prikazy;


    public void inicializace() {
        prikazy = new HashMap<>();
        prikazy.put("exit", new Exit());
        prikazy.put("mluv", new Mluv());
        prikazy.put("napoveda", new Napoveda());
        prikazy.put("pomoc", new Pomoc());
        prikazy.put("pouzit", new Pouzit());
        prikazy.put("prozkoumej", new Prozkoumej());
        prikazy.put("vyber", new Vyber());
        prikazy.put("vzit", new Vzit());
        prikazy.put("zahod", new Zahod());
        prikazy.put("inventar", new UkazInventar());
        //prikazy.put("jdiDo", new JdiDo());
    }

    public void provedPrikaz() {
        System.out.println(">");
        String prikaz = sc.next();
        if (prikazy.containsKey(prikaz)) {
            System.out.println(prikazy.get(prikaz).execute());
            exit = prikazy.get(prikaz).exit();
        } else {
            System.out.println("Neplatny prikaz!");
        }
    }


    public void start() {
        inicializace();
        do{
            Svet svet = new Svet();
            svet.nacteniMapy();
            Postavy postavy = new Postavy();
            postavy.nacteniPostav();
            Predmety predmety = new Predmety();
            predmety.nacteniPredmetu();
            Hrac hrac = new Hrac(svet.getPoziceHrace());

            provedPrikaz();
        }while(exit != true);
    }


}
