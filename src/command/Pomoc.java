package command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Trida pro zobrazeni prikazu ve hre.
 *
 * @author Tomas Voborny
 */
public class Pomoc implements Command {

    ArrayList<String> prikazy;


    /**
     * Provadi cteni prikazu ze souboru "prikazy.txt" a vraci jejich vypis.
     *
     * @param sc Scanner pro cteni vstupu od uzivatele
     * @return Seznam prikazu.
     */
    @Override
    public String execute(Scanner sc) {
        prikazy = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/res/prikazy.txt"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                prikazy.add(line);
            }
            return String.join("\n", prikazy);
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }

}
