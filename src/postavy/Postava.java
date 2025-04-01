package postavy;

/**
 * Trida Postava slouzi k vytvoreni postavy ve hre.
 *
 * @author Tomas Voborny
 */
public class Postava {


    protected int ID;
    protected String jmeno;
    protected String dialog;
    protected int misto;


    public Postava(int ID, String jmeno, String dialog, int misto) {
        this.ID = ID;
        this.jmeno = jmeno;
        this.dialog = dialog;
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

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public int getMisto() {
        return misto;
    }

    public void setMisto(int misto) {
        this.misto = misto;
    }
}
