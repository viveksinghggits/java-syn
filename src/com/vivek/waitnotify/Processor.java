package com.vivek.waitnotify;


import java.util.Scanner;

public class Processor {
    public void produce()  {
        synchronized (this){
            System.out.println("Produces thread running");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producer is Resumed");
            /******
            resource efficient, can only be called from inside the synchronized block
                it hands over the lock (lose control) and doesnt resume until two things happen
                1. thread regains the control
                2. call notify from another thread that is locked on same object
            */
        }
    }
    public void consume() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        synchronized (this){// same lock
            System.out.println("Enter return to exit");
            scanner.nextLine();
            System.out.println("Return key pressed");
            notify();
            /***
                will notify to the same thread that is locked on same object
                as soon as user presses the return key and producer will start.
                and it will give up the lock so that other thread can gain the lock and get started
            */
        }
    }
}
