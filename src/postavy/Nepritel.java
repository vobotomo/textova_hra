package postavy;

/**
 * Trida Nepritel reprezentuje nepratelskou postavu ve hre.
 *
 * @author Tomas Voborny
 */
public class Nepritel extends Postava{

    protected int sila;
    protected int zivoty;

    /**
     * Konstruktor tridy Nepritel, ktery inicializuje noveho Nepratele.
     *
     * @param ID ID nepritele
     * @param jmeno Jmeno nepritele
     * @param dialog Dialog nepritele
     * @param misto Misto, kde se nepritel nachazi
     * @param sila Sila nepritele
     * @param zivoty Pocet zivotu nepritele
     */
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
