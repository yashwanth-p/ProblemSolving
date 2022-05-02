package DSA.Misc;

public class OddEvenThreads {
    public static void main(String[] args) {

        Counter counter = new Counter(1);

        Thread oddThread = new Thread(new OddThread(10, counter));
        Thread evenThread = new Thread(new EvenThread(10, counter));

        oddThread.start();
        evenThread.start();
    }
}

class OddThread implements Runnable {

    int n;
    final Counter counter;
    public OddThread(int n, Counter counter) {
        this.n = n;
        this.counter = counter;
    }

    @Override
    public void run() {
        while(counter.count <= n) {
            synchronized(counter) {
                try {
                    wait();
                    if(counter.count % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + " " + counter.count);
                    }
                    counter.count++;
                    notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}


class EvenThread implements Runnable {
    int n;
    final Counter counter;
    public EvenThread(int n, Counter counter) {
        this.n = n;
        this.counter = counter;
    }

    @Override
    public void run() {
        while(counter.count <= n) {
            synchronized(counter) {
                try {
                    notify();
                    if(counter.count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " " + counter.count);
                    }
                    counter.count++;
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

class Counter {
    int count;
    Counter(int count) {
        this.count = count;
    }
}
