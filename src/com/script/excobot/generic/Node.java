package com.script.excobot.generic;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public abstract class Node {

    protected abstract boolean check();

    protected abstract void execute();

    public void run() {
        if(check()) {
            execute();
        }
    }

}
