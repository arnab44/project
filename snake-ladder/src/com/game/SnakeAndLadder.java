package com.game;

public class SnakeAndLadder {

    public static void main(String[] args) {
        Game game = GameFactory.createStanderdSnakeLaddeGame();
        game.play();
    }
}


//state pattern practice
//interface  State {
// void action1();
// void action2();
//
//}
//
//class Ball {
//    State state;
//    Ball(State s) {
//        state = s;
//    }
//    public  void transition(State state) {
//        // do something
//        this.state = state;
//    }
//    public void action1() {
//        state.action1();
//    }
//    public void action2() {
//        state.action2();
//    }
//}
//
//class A implements State {
//    String name;
//    Ball b;
//    public void action1() {
//        b.transition(new B());
//    }
//
//    public  void  action2() {
//        b.transition(new C());
//    }
//}
//
//class B implements State {
//    String name;
//    Ball b;
//    @Override
//    public void action1( ) {
//    }
//
//    @Override
//    public void action2() {
//
//    }
//}
//
//
//class C implements State {
//
//}
//
//
//main() {
//    Ball b = new Ball(new A());
//    b.action1();
//    b.action2();
//    b.action1();
//
//}
//
