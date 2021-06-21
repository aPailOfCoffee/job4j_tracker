package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare rabit = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        kolobok.tryEat(kolobok);
        rabit.tryEat(kolobok);
        kolobok.sing();
        wolf.tryEat(kolobok);
        kolobok.sing();
        fox.tryEat(kolobok);
    }
}
