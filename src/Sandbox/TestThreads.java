package Sandbox;

class MyThread extends Thread {
    MyThread() {
        System.out.print("MyThread ");
    }

    @Override
    public void run() {
        System.out.print("myThread.run() ");
    }

    public void run(String s) {
        System.out.println("myThread.run() with String");
    }
}

public class TestThreads {
    public static void main(String[] args) {
        Thread t = new MyThread() {
            @Override
            public void run() {
                System.out.print("Hi ");
            }
        };
        t.start();
    }
}
