package herni_svet;

import java.util.Arrays;

/**
 * Trida pro vytvoreni mistnosti ve hre.
 *
 * @author Tomas Voborny
 */
public class Mistnost {

    private int ID;
    private String jmeno;
    private int[] propojeneMistnosti;



    /**
     * Konstruktor pro vytvoreni mistnosti s urcitym ID, jmenem a propojenimy mistnostmi.
     *
     * @param ID ID mistnosti
     * @param jmeno Nazev mistnosti
     * @param propojeneMistnosti Pole propojenych mistnosti
     */
    public Mistnost(int ID, String jmeno, String[] propojeneMistnosti) {
        this.ID = ID;
        this.jmeno = jmeno;
        this.propojeneMistnosti = new int[4];
        for (int i = 0; i < propojeneMistnosti.length; i++) {
            this.propojeneMistnosti[i] = Integer.parseInt(propojeneMistnosti[i]);
        }
    }

    /**
     * Metoda pro pridani propojeni s jinou mistnosti.
     *
     * @param mistnostID ID mistnosti, kterou chceme propojit
     */
    public void pridatPropojeni(int mistnostID) {
        for (int id : propojeneMistnosti) {
            if (id == mistnostID) {
                return;
            }
        }

        int[] novePropojeni = Arrays.copyOf(propojeneMistnosti, propojeneMistnosti.length + 1);
        novePropojeni[novePropojeni.length - 1] = mistnostID;
        propojeneMistnosti = novePropojeni;
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

    public void setPropojeneMistnosti(int[] propojeneMistnosti) {
        this.propojeneMistnosti = propojeneMistnosti;
    }

    public int[] getPropojeneMistnosti() {
        return propojeneMistnosti;
    }
}