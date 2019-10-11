package com.Matveev.hash;


public class Main {

    public static void main(String[] args) {

        if (args[0].equals("-i")) {

            InteractiveMode im = new InteractiveMode(args);
            im.interactiveTalk();

        }
        else {

            SimpleMode sm = new SimpleMode(args);
            sm.countHash();
        }

    }
}