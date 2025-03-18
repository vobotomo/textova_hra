package predmety;

import java.util.ArrayList;



public class Inventar {



    private ArrayList<Predmet>inventar = new ArrayList<>(5);


    public boolean pridaniPredmetu(Predmet p){
        if(p != null){
            inventar.add(p);
            return true;
        }
        return false;
    }

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
