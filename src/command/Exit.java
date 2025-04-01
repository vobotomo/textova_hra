package command;

import java.util.Scanner;

public class Exit implements Command {
    @Override
    public String execute(Scanner sc) {
        return "";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
