package Concurrency.ConcurrentTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;


import static Concurrency.ConcurrentTest.ProducerAndConsumer.EOF;
import static Concurrency.ThreadColor.*;

public class ProducerAndConsumer {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
//        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer producer = new MyProducer(buffer, ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ANSI_WHITE + "I'm being printed in the callable class.");
                return "This is the callable";
            }
        }
        );

        try{
            System.out.println(future.get());
        }catch (ExecutionException e){
            System.out.println("Something went wrong");
        }catch (InterruptedException e){
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;
    //private ReentrantLock bufferLock;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
     //   this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);
//               bufferLock.lock();
//                try {
//                    buffer.add(num);
//                } finally {
//                   bufferLock.unlock();
//                }


                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println(color + "Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting....");

        //bufferLock.lock();
        try{
            buffer.put("EOF");
        }catch (InterruptedException e){

          //  bufferLock.unlock();
        }




    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;
  //  private ReentrantLock bufferLock;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
     //   this.bufferLock = bufferLock;
    }

    public void run() {
        int counter = 0;
        while (true) {
          // if(bufferLock.tryLock()) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println("The counter = " + counter);
                    counter = 0;
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }

                } catch (InterruptedException e) {

                    // bufferLock.unlock();
                }
                // }
            }



        }
    }
}
