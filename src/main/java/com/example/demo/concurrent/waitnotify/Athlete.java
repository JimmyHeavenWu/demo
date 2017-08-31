package com.example.demo.concurrent.waitnotify;

/**
 * Created by wuj42 on 8/14/2017.
 */
public class Athlete implements Runnable {

    public Game game;
    public int id;

    public Athlete (Game game, int id){
        this.game = game;
        this.id = id;
    }

    public String toString() {
        return "Athlete<" + id + ">";
    }


    @Override
    public void run() {
        try {
            game.prepare(this);
        } catch (InterruptedException e) {
            System.out.println(this + " quit the game");
        }
    }
}
