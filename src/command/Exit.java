package command;

import java.util.Scanner;

/**
 * Tato trida slouzi k ukonceni programu.
 *
 * @author Tomas Voborny
 */
public class Exit implements Command {
    @Override
    public String execute(Scanner sc) {
        return "";
    }
    /**
     * Urcuje, zda se ma program ukoncit.
     */
    @Override
    public boolean exit() {
        return true;
    }
}
