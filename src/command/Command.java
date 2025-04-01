package command;

import java.util.Scanner;

public interface Command {

    String execute(Scanner sc);
    boolean exit();

}
