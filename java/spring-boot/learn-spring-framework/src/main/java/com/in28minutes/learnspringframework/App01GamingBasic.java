package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PacmanGame;

public class App01GamingBasic {
    public static void main(String[] args) {
//		var game = new MarioGame();
//		var game = new SuperContraGame();
        var game = new PacmanGame(); // 1. 객체 생성
        var gameRunner = new GameRunner(game); // 2. 객체 생성 + 종속성 작성

        gameRunner.run();
    }
}
