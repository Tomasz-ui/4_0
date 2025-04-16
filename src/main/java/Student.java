public class Student {

  private String Name;
  private int Age;
  private String Address;

  public Student(String name, int age, String address) {
    Name = name;
    Age = age;
    Address = address;
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
  public String GetAddress() {return Address;}

  public String ToString() {
    return Name + " " + Integer.toString(Age) + " " + Address;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ", 3);
    if(data.length != 3) 
      return new Student("Parse Error", -1, "Unknown");
    return new Student(data[0], Integer.parseInt(data[1]), data[2]);
  }
}