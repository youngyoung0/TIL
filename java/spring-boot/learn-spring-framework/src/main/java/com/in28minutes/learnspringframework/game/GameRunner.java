package com.in28minutes.learnspringframework.game;

public class GameRunner {

//   private MarioGame game;
    private final SuperContraGame game;
    public GameRunner(SuperContraGame marioGame) {
        this.game = marioGame;
    }


    public void run() {
        System.out.println("Running gmae: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
