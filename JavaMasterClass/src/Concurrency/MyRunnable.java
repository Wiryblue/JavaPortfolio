package Concurrency;

import static Concurrency.ThreadColor.ANSI_PURPLE;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(ANSI_PURPLE + "Hello from the MyRunnable's implementation of run");
    }
}
