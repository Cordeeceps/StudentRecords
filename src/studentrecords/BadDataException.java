/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentrecords;

/**
 *
 * @author Mae
 */
public class BadDataException extends Exception {

    /**
     * an exception for when incorrect data is entered into the student fields. Usually thrown when students without a major are given one.
     */
    public BadDataException() {}

    /**
     *
     * @param message - calls custom message for the specific exception that is thrown.
     */
    public BadDataException(String message)
    {
        super(message);
    }
}
