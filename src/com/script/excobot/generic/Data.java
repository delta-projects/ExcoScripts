package com.script.excobot.generic;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Data<T> {

    private final T data;

    public Data(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
