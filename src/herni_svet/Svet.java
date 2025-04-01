package herni_svet;

import postavy.Nepritel;
import postavy.Obchodnik;
import postavy.Postava;
import predmety.Klic;
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


    private HashMap<Integer, Mistnost> svet = new HashMap<>();
    private int poziceHrace = 0;


    public Svet() {
        nacteniMapy();
        nacteniPredmetu();
        nacteniPredmetuObchod();
        nacteniPostav();
    }

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

    private ArrayList<Predmet> predmety;

    public boolean nacteniPredmetu() {
        predmety = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/predmety.txt"))) {
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
                            case "klic":
                                predmety.add(new Klic(ID, jmeno, popis, misto));
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

    private ArrayList<Predmet> predmetyObchod;

    public boolean nacteniPredmetuObchod() {
        predmetyObchod = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/predmetyObchod.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length >= 5) {
                    try {
                        int ID = Integer.parseInt(data[0]);
                        String jmeno = data[1];
                        String popis = data[2];
                        int misto = Integer.parseInt(data[3]);

                        predmetyObchod.add(new Predmet(ID, jmeno, popis, misto));
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


    private ArrayList<Postava> postavy;


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


                if (data[0].equals("obchodnik")) {
                    postavy.add(new Obchodnik(ID, jmeno, dialog, misto));
                }
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
                    setPoziceHrace(cilovaMistnost);
                    return true;
                }
            }
        }
        return false;
    }

    public String odemknoutTajemnyChram() {
        Mistnost labyrint = svet.get(6);
        labyrint.pridatPropojeni(7);
        return "Tajemny chram je nyni pristupny!";
    }

    public String zamknoutTajemnyChram() {
        svet.get(6).setPropojeneMistnosti(new int[]{2});
        return "Tajemny chram je opet nepristupny.";
    }

    public HashMap<Integer, Mistnost> getSvet() {
        return svet;
    }

    public ArrayList<Predmet> getPredmetyObchod() {
        return predmetyObchod;
    }

    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }

    public ArrayList<Postava> getPostavy() {
        return postavy;
    }

    public int getPoziceHrace() {
        return poziceHrace;
    }

    public void setPoziceHrace(int poziceHrace) {
        this.poziceHrace = poziceHrace;
    }

    public void setPostavy(ArrayList<Postava> postavy) {
        this.postavy = postavy;
    }

    public void setPredmetyObchod(ArrayList<Predmet> predmetyObchod) {
        this.predmetyObchod = predmetyObchod;
    }

    public void setPredmety(ArrayList<Predmet> predmety) {
        this.predmety = predmety;
    }

    public void setSvet(HashMap<Integer, Mistnost> svet) {
        this.svet = svet;
    }
}