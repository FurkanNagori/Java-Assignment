import java.io.*;
import java.util.List;

public class DeserializationTest {
    public static void main(String gg[]) {
        try {
            FileInputStream fileInputStream = new FileInputStream("Output1.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<Student> list = (List<Student>) objectInputStream.readObject();
            for(int i=0;i<list.size(); i++) {
                //just printing only name to confirm that it deserialized successfully.
                System.out.println(list.get(i).getFirstName());
            }
            System.out.println("Deserialized successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
