package command;

import herni_svet.Svet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Trida pro mluveni ve hre.
 *
 * @author Tomas Voborny
 */
public class Mluv implements Command {
    private HashMap<Integer,String> vety;
    private Svet svet;

    public Mluv(Svet svet) {
        vety = new HashMap<>();
        this.svet = svet;
    }

    /**
     * Provadi cteni textu ze souboru "pribeh.txt" a vraci vetu podle pozice hrace.
     *
     * @param sc Scanner pro cteni vstupu od uzivatele
     * @return Veta z textoveho souboru, ktera je prirazena k mistnosti, ve ktere se hrac nachazi.
     */
    @Override
    public String execute(Scanner sc) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/res/mluv.txt"))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                String[] casti = radek.split(",", 2);
                if (casti.length == 2) {
                    int idMistnosti = Integer.parseInt(casti[0]);
                    String veta = casti[1];
                    vety.put(idMistnosti, veta);
                }
            }

            return vety.get(svet.getPoziceHrace());
        } catch (IOException e) {
            return "Doslo k chybe.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
