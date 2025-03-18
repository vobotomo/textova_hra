package predmety;

public class Predmet {

    private int ID;
    private String jmeno;
    private String popis;
    private int misto;

    public Predmet(int ID, String jmeno, String popis, int misto) {
        this.ID = ID;
        this.jmeno = jmeno;
        this.popis = popis;
        this.misto = misto;
    }


    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public int getMisto() {
        return misto;
    }

    public void setMisto(int misto) {
        this.misto = misto;
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


}
