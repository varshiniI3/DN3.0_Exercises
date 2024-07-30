package ex3;

import java.util.Scanner;

public class Order {
    String orderId;
    String customerName;
    double totalPrice;

    public Order(String string, String customerName, double totalPrice) {
        this.orderId = string;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public static void bubbleSort(Order[] orders, int size) {
        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(orders, low, high);

            quickSort(orders, low, partitionIndex - 1);
            quickSort(orders, partitionIndex + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot.totalPrice) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void display(Order[] orders) {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.orderId + ", Customer Name: " + order.customerName + ", Total Price: $" + order.totalPrice);
        }
    }
    private static Order[] orders = {
            new Order("O001", "Alice", 150.75),
            new Order("O002", "Bob", 99.99),
            new Order("O003", "Charlie", 250.00),
            new Order("O004", "David", 50.50),
            new Order("O005", "Eve", 200.00)
        };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size=5;

        System.out.println("The array before sorting...");
        display(orders);

        System.out.println("The array after bubble sort...");
        bubbleSort(orders, size);
        display(orders);

        System.out.println("The array after quick sort...");
        quickSort(orders, 0, size - 1);
        display(orders);

        sc.close();
    }
}