
public class Student {
  private String Name;
  private int Age;
  private String BirthDate;

  public Student(String name, int age, String birthDate) throws IllegalArgumentException {
    if (!isValidDate(birthDate)) {
      throw new IllegalArgumentException("Nieprawidłowa data urodzenia!");
    }
    Name = name;
    Age = age;
    BirthDate = birthDate;
  }

  private boolean isValidDate(String date) {
    String[] parts = date.split("-");
    if (parts.length != 3) return false;
    
    try {
      int year = Integer.parseInt(parts[0]);
      int month = Integer.parseInt(parts[1]);
      int day = Integer.parseInt(parts[2]);
      
      if (year < 1 || year > 3000) return false;
      if (month < 1 || month > 12) return false;
      if (day < 1 || day > 31) return false;
      
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
  public String GetBirthDate() {return BirthDate;}

  public String ToString() {
    return Name + " " + Integer.toString(Age) + " " + BirthDate;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 3) 
      return new Student("Brak danych", -1, "2000-01-01");
    return new Student(data[0], Integer.parseInt(data[1]), data[2]);
  }
}
