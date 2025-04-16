import java.io.IOException;
import java.util.Scanner;

class Student {
    String name;
    int age;
    String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String ToString() {
        return "Imię: " + name + ", Wiek: " + age + ", Adres: " + address;
    }
}

class Service {
    java.util.ArrayList<Student> students = new java.util.ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public java.util.ArrayList<Student> getStudents() {
        return students;
    }
}


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
          scanner.nextLine(); // consume newline
          System.out.print("Podaj adres studenta: ");
          String address = scanner.nextLine();
          s.addStudent(new Student(name, age, address));
          System.out.println("Nowy student dodany.");
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