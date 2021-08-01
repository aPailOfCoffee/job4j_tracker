package ru.job4j.stream;

public class Athlete {
    private String name;
    private int age;
    private double weight;
    private int pullUps;
    private int pushUps;
    private int squats;
    private int burpee;

    @Override
    public String toString() {
        return "Athlete{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", weight=" + weight
                + ", pullUps=" + pullUps
                + ", pushUps=" + pushUps
                + ", squats=" + squats
                + ", burpee=" + burpee
                + '}';
    }

    static class Builder {
        private String name;
        private int age;
        private double weight;
        private int pullUps;
        private int pushUps;
        private int squats;
        private int burpee;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildAge(int age) {
            this.age = age;
            return this;
        }

        Builder buildWeight(double weight) {
            this.weight = weight;
            return this;
        }

        Builder buildPullUps(int pullUps) {
            this.pullUps = pullUps;
            return this;
        }

        Builder buildPushUps(int pushUps) {
            this.pushUps = pushUps;
            return this;
        }

        Builder buildSquats(int squats) {
            this.squats = squats;
            return this;
        }

        Builder buildBurpee(int burpee) {
            this.burpee = burpee;
            return this;
        }

        Athlete build() {
            Athlete athlete = new Athlete();
            athlete.name = name;
            athlete.age = age;
            athlete.weight = weight;
            athlete.pullUps = pullUps;
            athlete.pushUps = pushUps;
            athlete.squats = squats;
            athlete.burpee = burpee;
            return athlete;
        }
    }

    public static void main(String[] args) {
        Athlete athlete = new Builder().buildName("Ivan Ivanov")
                .buildAge(35)
                .buildWeight(90)
                .buildPullUps(100)
                .buildPushUps(50)
                .buildSquats(300)
                .buildBurpee(500)
                .build();
        System.out.println(athlete);
    }
}
