package Concurrency;

import static Concurrency.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread{


    @Override
    public void run() {
        System.out.println(ANSI_BLUE+ "Hello from " + currentThread().getName());
        try{
            sleep(3000);
        }catch (InterruptedException e){
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            return;
        }
        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake");
    }
}
