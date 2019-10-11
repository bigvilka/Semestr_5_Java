package com.Matveev.hash;

import java.io.IOException;
import java.util.Scanner;

public class InteractiveMode {

    String[] args;
    boolean userWantToStop;

    public InteractiveMode(String[] input) {

        this.args = input;
        this.userWantToStop = false;
    }

    void printHash(String fileName) {

        try {

            CountHash ch = new CountHash(fileName);
            String md5 = ch.countMd5();
            String sha256 = ch.countSha256();
            System.out.println("\nFile : " + fileName + "\nMd5 : " + md5 +
                    "\nSha256 : " + sha256 + "\n");
        }
        catch (IOException e) {
            System.out.println("File does not found!\n");
        }

    }

    void interactiveTalk() {

        while (!userWantToStop) {

            System.out.println("Enter file / files names :");
            Scanner in = new Scanner(System.in);
            for (String str : in.nextLine().split(" "))
                printHash(str);

            boolean badAnswer = true;
            while (badAnswer) {

                System.out.println("Do you want to count hash of another files? [y/n]");
                String response = in.next();
                if (response.equals("n")) {
                    userWantToStop = true;
                    badAnswer = false;
                }
                else if (response.equals("y"))
                    badAnswer = false;
                else
                    System.out.println("Incorrect answer! Try again");
            }
        }
    }
}