package com.codewhiz;

public class Singleton {
    public String str=null;

    private static Singleton instance=new Singleton();
    private Singleton(){}
    public static Singleton getSingleInstance () {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
