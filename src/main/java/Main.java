
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      
      while(true) {
        System.out.println("\n1. Dodaj studenta");
        System.out.println("2. Wyświetl studentów");
        System.out.println("3. Wyjście");
        System.out.print("Wybierz opcję: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        if(choice == 1) {
          System.out.print("Podaj imię studenta: ");
          String name = scanner.nextLine();
          System.out.print("Podaj wiek studenta: ");
          int age = scanner.nextInt();
          s.addStudent(new Student(name, age));
          System.out.println("Student dodany!");
        } 
        else if(choice == 2) {
          var students = s.getStudents();
          for(Student current : students) {
            System.out.println(current.ToString());
          }
        }
        else if(choice == 3) {
          break;
        }
      }
      
      scanner.close();
    } catch (IOException e) {
      System.out.println("Wystąpił błąd: " + e.getMessage());
    }
  }
}
