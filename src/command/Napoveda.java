package command;

import herni_svet.Svet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Trida pro napovedu ve hre.
 *
 * @author Tomas Voborny
 */
public class Napoveda implements Command{

    private ArrayList<String> napovedy;

    private Svet svet;


    public Napoveda(Svet svet) {
        napovedy = new ArrayList<>();
        this.svet = svet;
    }

    /**
     * Provadi cteni textu ze souboru "napoveda.txt" a vraci napovedu podle pozice hrace.
     *
     * @param sc Scanner pro cteni vstupu od uzivatele
     * @return Napoveda podle pozice hrace v prostredi hry.
     */
    @Override
    public String execute(Scanner sc) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/res/napovedy.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                napovedy.add(line);
            }

            return napovedy.get(svet.getPoziceHrace());
        } catch (IOException e) {
            return "Doslo k chybe.";
        }
    }
    @Override
    public boolean exit() {
        return false;
    }
}
