package ru.job4j.oop;

public class Error {

    private boolean active;

    private int status;

    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error404 = new Error(true, 404, "Page Not Found or File Not Found");
        Error error451 = new Error(true, 451, "Unavailable For Legal Reasons");
        Error error000 = new Error();
        error404.printInfo();
        error451.printInfo();
        error000.printInfo();
    }
}
