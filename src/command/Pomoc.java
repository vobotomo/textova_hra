package command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Pomoc implements Command {

    ArrayList<String> prikazy;

    //nacte prikazy ze souboru
    @Override
    public String execute() {
        prikazy = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\voborny\\textova_hra\\src\\prikazy.txt"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                prikazy.add(line + "\n");
            }
            return prikazy.toString();
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }


    @Override
    public String toString() {
        return prikazy + "";
    }
}
