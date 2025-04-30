
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      
      while(true) {
        System.out.println("\n1. Dodaj nowego studenta");
        System.out.println("2. Wyświetl listę studentów");
        System.out.println("3. Wyjście");
        System.out.print("Wybierz co chcesz zrobić: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if(choice == 1) {
          System.out.print("Podaj imię nowego studenta: ");
          String name = scanner.nextLine();
          System.out.print("Podaj wiek nowego studenta: ");
          int age = scanner.nextInt();
          scanner.nextLine();
          System.out.print("Podaj datę urodzenia (RRRR-MM-DD): ");
          String birthDate = scanner.nextLine();
          
          try {
            s.addStudent(new Student(name, age, birthDate));
            System.out.println("Nowy student dodany");
          } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
          }
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
      System.out.println("Wystąpił błąd, spróbuj ponownie: " + e.getMessage());
    }
  }
}
