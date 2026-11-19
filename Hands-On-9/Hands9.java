import java.io.*;

public class Hands9 {

    static void serialize(Employee e, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(e);
            System.out.println("Serialized: " + e.name);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    static Employee deserialize(String file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Employee) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Employee[] data = {
            new Employee("John", 30),
            new Employee("Siti", 25),
            new Employee("Andi", 41)
        };

        for (int i = 0; i < data.length; i++) {
            serialize(data[i], "emp" + i + ".ser");
        }

        for (int i = 0; i < data.length; i++) {
            Employee r = deserialize("emp" + i + ".ser");
            if (r != null) {
                System.out.println("Deserialized: " + r.name + ", " + r.age);
            }
        }
    }
}

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    Employee(String n, int a) {
        name = n;
        age = a;
    }
}
