package command;

import java.util.Scanner;

public class Pouzit implements Command {

    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        switch(sc.next()){
            case "klic":

            case "prut":

            case "ryba":
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
