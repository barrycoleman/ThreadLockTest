/*
 * This file is Public Domain.
 */
package com.barrycoleman;

import java.util.Vector;

public class ThreadTest {
    public static final String locker = "My Locker";

    public static void main(String[] args) {
        int numRunners=5;
        Vector<ThreadTestRunner> testrunners = new Vector<ThreadTestRunner>(numRunners);

        System.out.println("Entering main");

        if (args.length == 1) {
            try {
                numRunners = Integer.parseInt(args[0]);
            } catch (NumberFormatException nfe) {
                usage();
            }
        }

        for (int i=0; i<numRunners; i++) {
            ThreadTestRunner t = new ThreadTestRunner("thread"+i);
            testrunners.add(t);
        }

        for (ThreadTestRunner tr : testrunners) {
            System.out.println("Running "+tr.getName());
            tr.start();
        }

        System.out.println("End");

    }

    private static void usage() {
        System.out.println("Usage: Parameter passed needs to be an integer");
    }
}
