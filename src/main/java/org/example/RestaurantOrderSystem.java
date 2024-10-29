package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

public class RestaurantOrderSystem {
    private static List<MenuItem> menu = new ArrayList<>();

    static {
        menu.add(new MenuItem("Nasi Goreng", 20000));
        menu.add(new MenuItem("Mie Goreng", 18000));
        menu.add(new MenuItem("Ayam Penyet", 25000));
        menu.add(new MenuItem("Sate Ayam", 30000));
        menu.add(new MenuItem("Es Teh", 5000));
    }

    public static void main(String[] args) throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        String input;

        System.out.println("Selamat datang di Restoran!");
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.printf("%d. %s - Rp %.2f%n", i + 1, menu.get(i).getName(), menu.get(i).getPrice());
        }

        do {
            System.out.print("Pilih menu (1-" + menu.size() + ") atau ketik 'selesai' untuk mengakhiri: ");
            input = scanner.nextLine();

            if (input.matches("\\d+")) {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= menu.size()) {
                    order.addItem(menu.get(choice - 1));
                    System.out.println(menu.get(choice - 1).getName() + " ditambahkan ke pesanan.");
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            } else if (input.equalsIgnoreCase("selesai")) {
                break;
            } else {
                System.out.println("Input tidak valid.");
            }
        } while (true);

        System.out.println("\nNota Pemesanan:");
        for (MenuItem item : order.getItems()) {
            System.out.printf("%s - Rp %.2f%n", item.getName(), item.getPrice());
        }
        System.out.printf("Total: Rp %.2f%n", order.getTotal());
        scanner.close();

        System.out.println("hai");
    }
}