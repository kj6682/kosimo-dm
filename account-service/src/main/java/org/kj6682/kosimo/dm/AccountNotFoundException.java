package org.kj6682.kosimo.dm;

/**
 * Created by luigi on 23.04.16.
 */
public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String id) {
        super("could not find account '" + id + "'.");
    }

}
