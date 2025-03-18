package command;

import herni_svet.Svet;

public class Prozkoumej implements Command {
    private Svet svet;


    public Prozkoumej(Svet svet) {
        this.svet = svet;
    }

    @Override
    public String execute() {
        if(svet.predme)
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
