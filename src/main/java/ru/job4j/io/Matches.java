package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            String message = count >= 3 ? " введите число от 1 до 3."
                    : " введите число от 1 до " + count + ".";
            System.out.println(player + message);
            int matches = Integer.parseInt(input.nextLine());
            if (matches <= count && matches >= 1 && matches <= 3) {
                turn = !turn;
                count -= matches;
                System.out.println("Осталось " + count + " спичек.");
            } else {
                System.out.println("Вы ввели некорректное число");
            }
        }
        if (!turn) {
            System.out.println("Выйграл первый игрок.");
        } else {
            System.out.println("Выйграл второй игрок.");
        }
    }
}
