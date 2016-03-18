/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.exceptions;

/**
 *
 * @author Philip
 */
public class BuggyControlException extends Exception {

    public BuggyControlException() {
    }

    public BuggyControlException(String message) {
        super(message);
    }

    public BuggyControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuggyControlException(Throwable cause) {
        super(cause);
    }

    public BuggyControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
