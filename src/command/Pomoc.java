package command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Pomoc implements Command {

    ArrayList<String> prikazy;


    @Override
    public String execute() {
        prikazy = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/prikazy.txt"))) {
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
