package com.vivek.waitnotify;

public class Application {
    public static void main(String[] args) {
        final  Processor processor  = new Processor();

        try {
        Thread t1 = new Thread(()->processor.produce());
        Thread t2 = new Thread(()->processor.consume());

        t1.start();
        t2.start();

            t1.join();
            t2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        catch (Exception e){

        }


    }
}
