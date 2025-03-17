package command;

import predmety.Predmet;
import java.util.ArrayList;
import java.util.Scanner;


    private ArrayList<Predmet>inventar = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


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
}
