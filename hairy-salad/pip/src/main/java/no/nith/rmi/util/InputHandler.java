package no.nith.rmi.util;

import java.util.Scanner;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
public class InputHandler
{
    /**
     * Gets a single word from the console.
     * @return the word.
     */
    public static String next()
    {
        Scanner in = new Scanner(System.in);

        return in.next();
    }

    /**
     * Gets a line of text from the console.
     * @return the line.
     */
    public static String nextLine()
    {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
