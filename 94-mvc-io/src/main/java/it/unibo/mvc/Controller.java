package it.unibo.mvc;

import java.util.List;

/**
 * This interface models a simple controller responsible of I/O acces
 * It considers only the standard output, and it is able to print on it.
 */
public interface Controller {
    /**
     * This method set the next string to print
     * 
     * @param newNext is the new string to be setted as next string
     * @throws NullPointerException if the passed String is null
     */
    public void setString(String newNext);
    
    /**
     * This method get the next string to print
     * 
     * @return the next string to print
     */
    public String getNextString();
    
    /**
     * This method is used to get the history of printed Strings
     * @return the history of the printed strings (in form of a `List` of `Strings`)
     */
    public List<String> getHistory();

    /**
     * This method is used to print the current string on stdout
     * @throws IllegalStateException if the current string is unset
     */
    public void printCurrent();
}
