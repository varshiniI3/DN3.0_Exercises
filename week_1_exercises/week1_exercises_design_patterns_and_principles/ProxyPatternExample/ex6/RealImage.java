package ex6;

public class RealImage implements Image {
 private String filename;

 public RealImage(String filename) {
     this.filename = filename;
     loadImageFromServer();
 }

 private void loadImageFromServer() {
     System.out.println("Loading image: " + filename + " from remote server...");
     try {
         Thread.sleep(2000);
     } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
     }
     System.out.println("Image loaded: " + filename);
 }

 @Override
 public void display() {
     System.out.println("Displaying image: " + filename);
 }
}

