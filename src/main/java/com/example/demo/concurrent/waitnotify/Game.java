package com.example.demo.concurrent.waitnotify;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wuj42 on 8/14/2017.
 */
public class Game implements Runnable {

    List<Athlete> athletes;

    public boolean start = false;

    public Game(){
        athletes = new ArrayList<>();
    }

    public void addAthlete(Athlete athlete){
        this.athletes.add(athlete);
    }

    public List<Athlete> getAthletes(){
        return this.athletes;
    }


    public void prepare(Athlete athlete) throws InterruptedException {
        System.out.println(athlete + " ready!");
        synchronized (this) {
            while (!start) {
                System.out.println(athlete + " ready****!");
                wait();
            }
            if (start)
                System.out.println(athlete + " go!");
        }
    }

    public synchronized void go() {
        notifyAll();
    }

    public void ready() {
        Iterator<Athlete> iter = getAthletes().iterator();
        while (iter.hasNext())
            new Thread(iter.next()).start();
    }

    @Override
    public void run() {
        start = false;
        System.out.println("Ready......");
        System.out.println("Ready......");
        System.out.println("Ready......");
        ready();
        start = true;
        System.out.println("Go!");
        go();
    }

    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 10; i++)
            game.addAthlete(new Athlete(game, i));
        new Thread(game).start();
    }
}
