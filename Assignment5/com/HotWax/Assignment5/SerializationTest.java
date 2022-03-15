import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationTest {

    public static void main(String[] gg) {

        Student student1 = new Student("Furkan nagori", "08/03/2001", "Dewas", "mp", 455001, "India");
        Student student2 = new Student("Vladimir putin", "23/06/1968", "Moscow", "anyone", 452001, "Russia");
        Student student3 = new Student("Jac ma", "04/06/1970", "Shanghai", "anyone", 452001, "China");
        Student student4 = new Student("Nusret saltBay", "22/12/1980", "Istanbul", "anyone", 444001, "Turkey");
        Student student5 = new Student("Chris hamesworth", "30/11/1991", "Sydney", "anyone", 466001, "Australia");

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
//serializing list object into output1.ser file.
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("Output1.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);
            objectOutputStream.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data list serialized successfully");
    }
}
