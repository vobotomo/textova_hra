package postavy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Postavy {

    ArrayList<Postava> postavy;


    public boolean nacteniPostav() {
        postavy = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/postavy.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                int ID = Integer.parseInt(data[1]);
                String jmeno = data[2];
                String dialog = data[3];
                int misto = Integer.parseInt(data[4]);

                if (data[0].equals("nepritel")) {
                    int sila = Integer.parseInt(data[5]);
                    int zivoty = Integer.parseInt(data[6]);
                    postavy.add(new Nepritel(ID, jmeno, dialog, misto, sila, zivoty));
                } else {
                    postavy.add(new Postava(ID, jmeno, dialog, misto));
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
