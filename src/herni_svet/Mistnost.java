package herni_svet;

import java.util.Arrays;

public class Mistnost {

    private int ID;
    private String jmeno;
    private int[] propojeneMistnosti;


    public Mistnost() {
    }

    public Mistnost(int ID, String jmeno, String[] propojeneMistnosti) {
        this.ID = ID;
        this.jmeno = jmeno;
        this.propojeneMistnosti = new int[4];
        for (int i = 0; i < propojeneMistnosti.length; i++) {
            this.propojeneMistnosti[i] = Integer.parseInt(propojeneMistnosti[i]);
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    @Override
    public String toString() {
        return "herni_svet.Mistnost{" +
                "ID=" + ID +
                ", jmeno='" + jmeno + '\'' +
                ", propojeneMistnosti=" + Arrays.toString(propojeneMistnosti) +
                '}';
    }


    public int[] getPropojeneMistnosti() {
        return propojeneMistnosti;
    }
}