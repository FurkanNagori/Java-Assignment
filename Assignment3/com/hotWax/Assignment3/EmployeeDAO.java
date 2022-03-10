import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class EmployeeDAO {
    public void getAll() {
        try {
            File file = new File("Employees.txt");
            if (!file.exists()) throw new FileNotFoundException();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            String data = randomAccessFile.readLine();
            while (data != null) {
                System.out.println(data);
                data = randomAccessFile.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void add(Employee employee) throws DAOException
    {
        try {
            if(employee==null){ throw new DAOException("Employee is null");}
            String name = employee.getName();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String emailId = employee.getEmailId();
            // parsing age and dateofbirth in String for putting into File
            String dateOfBirth = simpleDateFormat.format(employee.getDateOfBirth());
            String age = String.valueOf(employee.getAge());
            if(name==null || emailId==null || dateOfBirth==null || age==null)
            {
                throw new DAOException("Sorry value can't be null, please provide proper value.");
            }
            int employeeId=0;
            File file = new File("Employees.txt");
            if (!file.exists()) file = new File("Employees.txt");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
            if(randomAccessFile.length()==0)
            {
                employeeId++;
                randomAccessFile.writeBytes(employeeId+",");
                randomAccessFile.writeBytes(name+",");
                randomAccessFile.writeBytes(emailId+",");
                randomAccessFile.writeBytes(age+",");
                System.out.println("Employee added successfully with employee Id : "+employeeId);
            }
            else
            {
                String fString = randomAccessFile.readLine();
                List<String> list = Arrays.asList(fString.split(","));
                employeeId= Integer.parseInt(list.get(list.size()-4));
                employeeId++;
                randomAccessFile.writeBytes(employeeId+",");
                randomAccessFile.writeBytes(name+",");
                randomAccessFile.writeBytes(emailId+",");
                randomAccessFile.writeBytes(age+",");
                System.out.println("Employee added successfully with employee Id : "+employeeId);
            }
            randomAccessFile.close();
        }catch(IOException exception){
            System.out.println(exception.getMessage());
        }catch(DAOException daoException){
            System.out.println(daoException.getMessage());
        }

    }
}

