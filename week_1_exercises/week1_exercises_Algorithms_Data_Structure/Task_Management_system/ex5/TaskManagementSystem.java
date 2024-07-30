package ex5;
import java.util.Scanner;
public class TaskManagementSystem {
    static class Node {
        Task task;
        Node next;
        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }
    private Node head;
    public TaskManagementSystem() {
        this.head = null;
    }
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false;
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId().equals(taskId)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public static void main(String[] args) {
        TaskManagementSystem taskMgmt = new TaskManagementSystem();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nTask Management System:");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                	System.out.print("Enter Task ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();
                    Task task = new Task(id, name, status);
                    taskMgmt.addTask(task);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                	System.out.print("Enter Task ID to search: ");
                    String id1 = sc.nextLine();
                    Task task1 = taskMgmt.searchTask(id1);
                    if (task1 != null) {
                        System.out.println("Task found: " + task1);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 3:
                    taskMgmt.traverseTasks();
                    break;
                case 4:
                	System.out.print("Enter Task ID to delete: ");
                    String id2 = sc.nextLine();
                    boolean isDeleted = taskMgmt.deleteTask(id2);
                    if (isDeleted) {
                        System.out.println("Task deleted successfully.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

