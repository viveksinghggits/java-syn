package com.vivek.blockingqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Application {
    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args){
        System.out.println("Started");
        Thread t1 = new Thread(() -> {
            producer();
        });

        /*Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });*/

        Thread t2 = new Thread(() -> {
            consumer();
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private static void producer(){
        Random rnd = new Random();
        while (true){
            try {
                Integer r = rnd.nextInt(100);
                queue.put(r);
                System.out.println("have put "+ r+" in the queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consumer(){
        Random rnd = new Random();
        while (true){
            try {
                Thread.sleep(5000);

                    Integer value = queue.take();
                    System.out.println("Taken value "+ value+" and the size now is "+ queue.size());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
