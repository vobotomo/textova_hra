package herni_svet;

import postavy.Nepritel;
import postavy.Postava;
import predmety.Predmet;
import predmety.Ryby;
import predmety.Zbran;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    ArrayList<Predmet> predmety;

    public boolean nacteniPredmetu() {
        predmety = new ArrayList<>();
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

    public boolean presunout(int cilovaMistnost) {
        if (svet.containsKey(cilovaMistnost)) {
            Mistnost aktualniMistnost = svet.get(poziceHrace);

            for (int soused : aktualniMistnost.getPropojeneMistnosti()) {
                if (soused == cilovaMistnost) {
                    poziceHrace = cilovaMistnost;
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