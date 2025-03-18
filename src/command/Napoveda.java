package command;

import herni_svet.Svet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Napoveda implements Command{

    private ArrayList<String> napovedy;

    private Svet svet;


    public Napoveda(Svet svet) {
        this.svet = svet;
    }

    @Override
    public String execute() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/napoveda.txt"))) {
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
