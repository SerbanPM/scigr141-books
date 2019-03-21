package ro.sci.library;

/**
 * <h1>CustomException</h1>
 * <p>
 * This is a user defined exception used to provide information or functionality that is not part of Java’s standard exceptions.
 *
 * @author Serban PM
 * @version 1.0
 * @since 20190122
 */

import java.io.FileNotFoundException;

public class CustomException extends FileNotFoundException {

    public CustomException(String message){
        super(message);
    }

}
