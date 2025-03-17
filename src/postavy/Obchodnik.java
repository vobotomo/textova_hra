package postavy;

import java.util.HashMap;

public class Obchodnik extends Postava {

    private HashMap<String, Integer> predmety;

    public Obchodnik(int ID, String jmeno, String dialog, int misto) {
        super(ID, jmeno, dialog, misto);
        predmety = new HashMap<>(predmety);
    }


    //public void obchod(){}


}
