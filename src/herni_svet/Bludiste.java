package herni_svet;

import postavy.Hrac;
import predmety.Klic;
import predmety.Predmet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

public class Bludiste {
    private static final int VYCHOD = 6;
    private int pozice = 0;
    private Hrac hrac;
    private Svet svet;


    private HashMap<Integer, int[]> mapa;


    public Bludiste(Hrac hrac, Svet svet) {
        this.hrac = hrac;
        this.svet = svet;
        this.mapa = new HashMap<>();
    }
    public boolean nacteniBludiste(){
            try (BufferedReader br = new BufferedReader(new FileReader("bludiste.txt"))) {
                String radek;
                while ((radek = br.readLine()) != null) {
                    String[] casti = radek.split(" ");
                    int klic = Integer.parseInt(casti[0]);
                    int leva = Integer.parseInt(casti[1]);
                    int prava = Integer.parseInt(casti[2]);
                    mapa.put(klic, new int[]{leva, prava});
                }
            } catch (IOException e) {
                return false;
            }

            return true;

    }

    public String spustit() {
        nacteniBludiste();

        Scanner sc = new Scanner(System.in);
        System.out.println("Vstoupil jsi do Zeleneho labyrintu.");
        System.out.println("Pred tebou jsou dvoje dvere – vlevo a vpravo.");

        while (pozice != VYCHOD) {
            System.out.println("\nTvoje aktualni pozice: " + pozice);
            System.out.println("Zivoty: " + hrac.getZivoty());
            System.out.println("Vyber dvere: vlevo / vpravo");
            System.out.print("Zadej prikaz: ");

            String vstup = sc.nextLine().toLowerCase();

            if (vstup.equals("vlevo")) {
                pozice = mapa.get(pozice)[0];
            } else if (vstup.equals("vpravo")) {
                pozice = mapa.get(pozice)[1];
            } else {
                System.out.println("Neplatny prikaz.");
                continue;
            }


            hrac.setZivoty(hrac.getZivoty()-5);
            if (hrac.getZivoty() <= 0) {
                return "Ztratil jsi veskerou energii a bloudis naveky...";

            }


            if (pozice == VYCHOD) {
                for (Predmet predmet : hrac.getInventar().getInventar()) {
                    if (predmet instanceof Klic) {
                        svet.odemknoutTajemnyChram();
                        return "Odemkl jsi dvere a uspesne prosel bludistem!";
                    }
                }
            } else {
                svet.presunout(2);
                return "Dvere jsou zamcene! Potrebujes klic.";

            }
        }
        sc.close();
        return "";
    }

}
