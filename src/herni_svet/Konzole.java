package herni_svet;

import command.*;
import postavy.Hrac;

import java.util.HashMap;
import java.util.Scanner;

public class Konzole {

    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> prikazy;


    public void inicializace(Svet svet, Hrac hrac) {
        prikazy = new HashMap<>();
        prikazy.put("exit", new Exit());
        prikazy.put("napoveda", new Napoveda(svet));
        prikazy.put("pomoc", new Pomoc());
        prikazy.put("pouzit", new Pouzit());
        prikazy.put("prozkoumej", new Prozkoumej(svet));
        prikazy.put("vyber", new Vyber(hrac));
        prikazy.put("vzit", new Vzit(svet, hrac));
        prikazy.put("zahod", new Zahod(hrac));
        prikazy.put("inventar", new UkazInventar(hrac));
        prikazy.put("jdiDo", new JdiDo(svet));
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
        Svet svet = new Svet();
        Hrac hrac = new Hrac(svet.getPoziceHrace());
        inicializace(svet, hrac);
        do{
            svet.nacteniMapy();
            svet.nacteniPredmetu();
            svet.nacteniPostav();


            provedPrikaz();
        }while(exit != true);
    }


}
