package postavy;

public class Nepritel extends Postava{

    protected int sila;
    protected int zivoty;

    public Nepritel(int ID, String jmeno, String dialog, int misto, int sila, int zivoty) {
        super(ID, jmeno, dialog, misto);
        this.sila = sila;
        this.zivoty = zivoty;
    }

    public int getSila() {
        return sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }
}
