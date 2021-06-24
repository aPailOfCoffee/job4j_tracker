package ru.job4j.pojo;

public class Library {

    public static void show(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getPages());
        }
    }

    public static void main(String[] args) {
        Book book01 = new Book("Kolobok", 14);
        Book book02 = new Book("Clean code", 352);
        Book book03 = new Book("Music and Food", 999);
        Book book04 = new Book("Just Book", 10);
        Book[] books = {book01, book02, book03, book04};
        show(books);
        System.out.println();
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        show(books);
        System.out.println();
        for (Book book: books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getPages());
                break;
            }
        }
    }
}
