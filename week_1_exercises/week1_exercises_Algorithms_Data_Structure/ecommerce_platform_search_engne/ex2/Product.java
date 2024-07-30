package ex2;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category + "]";
    }
    public static Product linearSearch(Product[] products, String target) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(target)) {
                return product;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, String target) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        int left = 0;
        int right = products.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = products[mid].getProductName().compareToIgnoreCase(target);
            
            if (compareResult == 0) {
                return products[mid];
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
    private static Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Tablet", "Electronics"),
            new Product("P004", "Headphones", "Accessories"),
            new Product("P005", "Keyboard", "Accessories")
        };

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
                System.out.println("\nE-Commerce Search System:");
                System.out.println("1. Perform Linear Search");
                System.out.println("2. Perform Binary Search");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                    	 System.out.print("Enter product name to search: ");
                         String target = scanner.nextLine();
                         Product result = linearSearch(products, target);
                         System.out.println("Linear Search Result: " + (result != null ? result : "Product not found"));
                        break;
                    case 2:
                    	System.out.print("Enter product name to search: ");
                        String target1 = scanner.nextLine();
                        Product result1 = binarySearch(products, target1);
                        System.out.println("Binary Search Result: " + (result1 != null ? result1 : "Product not found"));
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
}

