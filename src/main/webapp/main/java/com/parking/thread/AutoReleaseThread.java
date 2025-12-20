package com.parking.thread;

public class AutoReleaseThread extends Thread {
    public void run() {
        while (true) {
            try {
                Thread.sleep(60000);
                System.out.println("Auto cleanup running...");
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
