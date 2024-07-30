package ex6;
import java.util.*;
public class LibraryManagementSystem {
    private List<Book> books;
    public LibraryManagementSystem() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
        books.sort(Comparator.comparing(Book::getTitle));
    }
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    public Book binarySearchByTitle(String title) {
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int comparison = midBook.getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return midBook;
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner sc = new Scanner(System.in);
        library.addBook(new Book("1", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("2", "1984", "George Orwell"));
        library.addBook(new Book("3", "To Kill a Mockingbird", "Harper Lee"));
        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Search Book by Title (Linear Search)");
            System.out.println("2. Search Book by Title (Binary Search)");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Title to search (Linear Search): ");
                    String linearSearchTitle = sc.nextLine();
                    Book linearSearchResult = library.linearSearchByTitle(linearSearchTitle);
                    System.out.println(linearSearchResult != null ? linearSearchResult : "Book not found");
                    break;
                case 2:
                    System.out.print("Enter Title to search (Binary Search): ");
                    String binarySearchTitle = sc.nextLine();
                    Book binarySearchResult = library.binarySearchByTitle(binarySearchTitle);
                    System.out.println(binarySearchResult != null ? binarySearchResult : "Book not found");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
