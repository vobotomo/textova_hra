package predmety;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Predmety {

    ArrayList<Predmet> predmety;

    public boolean nacteniPredmetu() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/prikazy.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length >= 5) {
                    try {
                        String typ = data[0];
                        int ID = Integer.parseInt(data[1]);
                        String jmeno = data[2];
                        String popis = data[3];
                        int misto = Integer.parseInt(data[4]);

                        switch (typ.toLowerCase()) {
                            case "zbran":
                                if (data.length == 6) {
                                    int sila = Integer.parseInt(data[5]);
                                    predmety.add(new Zbran(ID, jmeno, popis, misto, sila));
                                } else {
                                    return false;
                                }
                                break;
                            case "ryby":
                                if (data.length == 6) {
                                    int zivoty = Integer.parseInt(data[5]);
                                    predmety.add(new Ryby(ID, jmeno, popis, misto, zivoty));
                                } else {
                                    return false;
                                }
                                break;
                            case "predmet":
                                predmety.add(new Predmet(ID, jmeno, popis, misto));
                                break;
                            default:
                                return false;
                        }
                    } catch (NumberFormatException e) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
