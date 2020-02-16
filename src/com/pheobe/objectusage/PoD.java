package com.pheobe.objectusage;

/**
 * CSCI 1110
 * @author ASiegel
 */


import java.util.Scanner;

public class PoD {

    public static void main( String [] args ) {


        Scanner in = new Scanner(System.in);

        final int MARINA_SIZE= 10;

        String[] boatNames = new String[MARINA_SIZE];
        Sailboat[] boats = new Sailboat[MARINA_SIZE];

        int i = 0;

        while (in.hasNextLine())
        {
            boatNames[i] = in.nextLine();
            boats[i] = new Sailboat(boatNames[i]);
            System.out.println(boats[i]);
            i++;
        }
    }
}
