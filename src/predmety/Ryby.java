package predmety;

public class Ryby extends Predmet {

    private int zivoty;

    public Ryby(int ID, String jmeno, String popis, int misto, int zivoty) {
        super(ID, jmeno, popis, misto);
        this.zivoty = zivoty;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }
}
