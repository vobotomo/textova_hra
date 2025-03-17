package herni_svet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Svet {


    public HashMap<Integer, Mistnost> svet = new HashMap<>();
    private int poziceHrace = 0;

    public boolean nacteniMapy() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/mapa.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
                Mistnost mistnost = new Mistnost(
                        Integer.parseInt(lines[0]),
                        lines[1],
                        Arrays.copyOfRange(lines, 2, lines.length)
                );
                svet.put(Integer.valueOf(lines[0]), mistnost);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }


    public boolean presunout() {
        Mistnost mistnost = new Mistnost();
        mistnost.setID(getPoziceHrace());
        if(svet.containsKey(poziceHrace)) {
            for(int soused : mistnost.getPropojeneMistnosti()){
                if(soused == mistnost.getID()){
                    poziceHrace = mistnost.getID();
                    return true;
                }
            }
        }
        return false;
    }


    public HashMap<Integer, Mistnost> getSvet() {
        return svet;
    }

    public int getPoziceHrace() {
        return poziceHrace;
    }
}