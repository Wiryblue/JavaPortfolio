package Concurrency;

import static Concurrency.ThreadColor.*; // removes the need for calling class for accessing methods and variables

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_GREEN+ "Main Thread");//Green Text

        Thread anotherThread = new AnotherThread();//blue text
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread(){//anonymous class
            public void run(){
                System.out.println(ANSI_RED+ "Hello from the anonymous class thread.");
                try{
                    anotherThread.join();
                    System.out.println(ANSI_RED+ "Another thread terminate, so I'm running again.");
                }catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I could wait I was interrupted");
                }
            }
        }.start();

        //How runnables work
        Thread myRunnableThread = new Thread(new MyRunnable());//Purple text
        myRunnableThread.start();
       // anotherThread.interrupt();


        System.out.println(ANSI_GREEN+ "Hello again from the main thread");
    }
}
