import java.io.*;

// Step 1: Create a Student class that implements Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes

    private String studentID;
    private String name;
    private double grade;

    // Constructor
    public Student(String studentID, String name, double grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    // Getter methods
    public String getStudentID() { return studentID; }
    public String getName() { return name; }
    public double getGrade() { return grade; }

    @Override
    public String toString() {
        return "StudentID: " + studentID + ", Name: " + name + ", Grade: " + grade;
    }
}

public class StudentSerializationDemo {
    public static void main(String[] args) {
        // Step 2: Create a Student object
        Student student = new Student("S101", "Alice", 9.5);

        // File to store serialized object
        String filename = "student.ser";

        // Step 3: Serialization - Saving the object to a file
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(student);
            System.out.println("Student object has been serialized and saved to " + filename);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 4: Deserialization - Reading the object back from file
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Student deserializedStudent = (Student) ois.readObject(); // Casting required
            System.out.println("Student object has been deserialized:");
            System.out.println(deserializedStudent);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
