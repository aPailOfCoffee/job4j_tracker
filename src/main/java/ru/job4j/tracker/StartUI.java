package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Items ===");
                Item[] items = tracker.findAll();
                for (Item item: items) {
                    System.out.println(item.toString());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.print("Enter item id to edit: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter a new name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                boolean isReplace = tracker.replace(id, item);
                String rsl = isReplace ? "Заявка изменена" : "Заявка с таким id не найдена";
                System.out.println(rsl);
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.print("Enter item id to delete: ");
                int id = Integer.parseInt(scanner.nextLine());
                boolean isDelete = tracker.delete(id); // Validate
                String rsl = isDelete ? "Заявка удалена" : "Заявка с таким id не найдена";
                System.out.println(rsl);
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                String rsl = item != null ? item.toString() : "Заявка с таким id не найдена";
                System.out.println(rsl);
            } else if (select == 5) {
                System.out.println("=== Find item by name ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] found = tracker.findByName(name);
                if (found.length != 0) {
                    for (Item item : found) {
                        System.out.println(item.toString());
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
