package com.Matveev.hash;

import java.io.IOException;
import java.util.Scanner;


public class SimpleMode {

    String[] args;
    String hashType;

    public SimpleMode(String[] input) {

        this.args = input;
        this.hashType = args[0];
    }

    void countHash() {

        switch (hashType) {

            case ("-md5"):
                for (int i = 2; i < args.length; i++) {
                    String fileName = args[i];
                    try {

                        CountHash ch = new CountHash(fileName);
                        String md5 = ch.countMd5();
                        System.out.println("\nFile : " + fileName + "\nMd5 : " + md5 + "\n");
                    }
                    catch (IOException e) {
                        System.out.println("File does not found!\n");
                    }
                }
                break;

            case ("-sha256"):
                for (int i = 2; i < args.length; i++) {
                    String fileName = args[i];
                    try {

                        CountHash ch = new CountHash(fileName);
                        String sha256 = ch.countSha256();
                        System.out.println("\nFile : " + fileName + "\nSha256 : " + sha256 + "\n");
                    }
                    catch (IOException e) {
                        System.out.println("File does not found!\n");
                    }
                }
                break;
        }
    }
}