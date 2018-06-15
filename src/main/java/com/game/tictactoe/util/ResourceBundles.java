package com.game.tictactoe.util;

/**
 * Created by riham.y.abdelmaksoud on 6/15/2018.
 * Created for the same of adding other resource bundles in the future
 * All Messages and Errors in application should be places in properties file "messages" and "errors" respectively.
 */
public enum ResourceBundles {

    MESSAGES("messages"),
    ERRORS("errors"),
    CONFIG("game");

    private String bundleName;

    ResourceBundles(String bundleName) {
        this.bundleName = bundleName;
    }

    public String getBundleName() {
        return bundleName;
    }

    @Override
    public String toString() {
        return bundleName;
    }
}
