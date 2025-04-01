package predmety;

import java.util.ArrayList;


/**
 * Trida Inventar slouzi pro spravu predmetu, ktere ma hrac k dispozici. Umoznuje pridavat a odebirat predmety.
 *
 * @author Tomas Voborny
 */
public class Inventar {



    private ArrayList<Predmet>inventar = new ArrayList<>(5);

    /**
     * Prida novy predmet do inventare.
     *
     * @param p Predmet, ktery bude pridan do inventare
     * @return true, pokud byl predmet uspesne pridan, jinak false
     */
    public boolean pridaniPredmetu(Predmet p){
        for(Predmet predmet : inventar){
            if(inventar.contains(predmet)){
                return false;
            }
        }
        if(p != null){
            inventar.add(p);
            return true;
        }
        return false;
    }

    /**
     * Odebere predmet z inventare.
     *
     * @param p Predmet, ktery bude odebran z inventare
     * @return true, pokud byl predmet uspesne odebran, jinak false
     */
    public boolean odstraneniPredmetu(Predmet p){
        for (int i = 0; i < inventar.size(); i++) {
            if(p == inventar.get(i)){
                inventar.remove(i);
                return true;
            }
        }
        return false;
    }




    public ArrayList<Predmet> getInventar() {
        return inventar;
    }
}
