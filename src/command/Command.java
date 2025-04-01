package command;

import java.util.Scanner;

/**
 * Interface pro prikazy ve hre.
 * Tato trida definuje metody pro vykonani prikazu a urcuje, zda je prikaz ukonceny.
 *
 * @author Tomas Voborny
 */
public interface Command {

    /**
     * Vykona prikaz.
     *
     * @param sc Scanner pro vstup od uzivatele
     */
    String execute(Scanner sc);


    /**
     * Ukonci hru.
     */
    boolean exit();

}
