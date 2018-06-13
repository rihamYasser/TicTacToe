package com.game.tictactoe.util;

import java.util.Scanner;

/**
 * Created by riham.y.abdelmaksoud on 6/12/2018.
 */
public class InputScanner {

    private InputScanner() {
    }
    private static Scanner screenScanner =  new Scanner(System.in);

    public static Scanner getScanner() {
        return screenScanner ;
    }

    //Other Scanner types can be added later in the same class


}
