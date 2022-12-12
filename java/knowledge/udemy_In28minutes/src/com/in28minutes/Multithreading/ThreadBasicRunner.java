package com.in28minutes.Multithreading;

class Task1 extends Thread{
    public void run(){ // SIGNATURE
        for(int i = 101; i<=199; i++){
            System.out.print(i + " ");
        }
    }
}
class Task2 implements Runnable{

    @Override
    public void run() {
        for(int i = 201; i<=299; i++){
            System.out.print(i + " ");
        }
    }
}

public class ThreadBasicRunner {
    public static void main(String[] args){

        // Task1
        Task1 task1 = new Task1();

        task1.run();

        System.out.println("\n Task1 Done");
        // Task2
        Task2 task2 = new Task2();
        Thread task2Thead = new Thread(task2);
        task2Thead.start();

        System.out.println("\n Task2 Done");
        // Task3
        for(int i = 301; i<=399; i++){
            System.out.print(i + " ");
        }
        System.out.println("\n Task3 Done");
        System.out.println("\n Main Done");

    }
}
