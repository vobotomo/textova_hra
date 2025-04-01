package command;

import herni_svet.Svet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Mluv implements Command {
    private HashMap<Integer,String> vety;
    private Svet svet;

    public Mluv(Svet svet) {
        vety = new HashMap<>();
        this.svet = svet;
    }

    @Override
    public String execute(Scanner sc) {
        try (BufferedReader br = new BufferedReader(new FileReader("pribeh.txt"))) {
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
