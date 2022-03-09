import java.io.*;
import java.util.List;

public class EmployeeDAO {
    public void getAll() {
        try {
            File file = new File("Employees.txt");
            if (!file.exists()) throw new FileNotFoundException();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            //int employeeId=0;
            String data = randomAccessFile.readLine();
            while (data != null) {
                System.out.println(data);
                data = randomAccessFile.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }
}

