/*
 * This file is Public Domain.
 */
package com.barrycoleman;

class ThreadTestRunner extends Thread {
    public ThreadTestRunner(String name) {
        super(name);
    }

    public void run() {
        synchronized (ThreadTest.locker) {
            System.out.println("Entering sleep on "+this.getName());
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Exiting sleep on "+this.getName());
        }
    }
}
