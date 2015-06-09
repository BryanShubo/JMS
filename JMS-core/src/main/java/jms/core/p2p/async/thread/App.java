package jms.core.p2p.async.thread;

/**
 * Created by Shubo on 6/7/2015.
 */
public class App {

    public static void main(String[] args) throws Exception{

        thread(new ProducerThread(),false);
        thread(new ProducerThread(),false);
        thread(new ProducerThread(),false);
        thread(new ConsumerThread(),false);
        Thread.sleep(1000);
        thread(new ProducerThread(),false);
        thread(new ProducerThread(),false);
        thread(new ProducerThread(),false);

        thread(new ConsumerThread(),false);
        thread(new ConsumerThread(),false);
        thread(new ConsumerThread(),false);


        Thread.sleep(1000);


    }

    public static void thread(Runnable runnable, boolean daemon) {
        Thread newThread = new Thread(runnable);
        newThread.setDaemon(daemon);
        newThread.start();
    }
}
