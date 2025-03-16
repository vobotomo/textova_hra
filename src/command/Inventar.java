package command;

import predmety.Predmet;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventar implements Command{

    private ArrayList<Predmet>inventar = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String execute() {
        if(inventar.isEmpty()){
            System.out.println("Inventar je prazdny.");
        }
    }

    @Override
    public boolean exit() {
        return false;
    }

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
