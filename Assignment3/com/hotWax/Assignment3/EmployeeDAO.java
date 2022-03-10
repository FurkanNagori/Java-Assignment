import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeDAO {
    List<String> list;
    File file;
    public void add(Employee employee) throws DAOException {
        try {
            if (employee == null) {
                throw new DAOException("Employee is null");
            }
            String name = employee.getName();
            String emailId = employee.getEmailId();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            // parsing age and dateofbirth in String for putting into File
            String dateOfBirth = simpleDateFormat.format(employee.getDateOfBirth());
            String age = String.valueOf(employee.getAge());
            if (name == null || emailId == null || dateOfBirth == null || age == null) {
                throw new DAOException("Sorry value can't be null, please provide proper value.");
            }
            int employeeId = 0;
            file = new File("Employees.txt");
            if (!file.exists()) file = new File("Employees.txt");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            if (randomAccessFile.length() == 0) {
                employeeId++;
                randomAccessFile.writeBytes(employeeId + ",");
                randomAccessFile.writeBytes(name + ",");
                randomAccessFile.writeBytes(dateOfBirth + ",");
                randomAccessFile.writeBytes(emailId + ",");
                randomAccessFile.writeBytes(age + ",");
                System.out.println("Employee added successfully with employee Id : " + employeeId);
            } else {
                String fString = randomAccessFile.readLine();
                list = Arrays.asList(fString.split(","));
                employeeId = Integer.parseInt(list.get(list.size() - 5));
                employeeId++;
                randomAccessFile.writeBytes(employeeId + ",");
                randomAccessFile.writeBytes(name + ",");
                randomAccessFile.writeBytes(dateOfBirth + ",");
                randomAccessFile.writeBytes(emailId + ",");
                randomAccessFile.writeBytes(age + ",");
                System.out.println("Employee added successfully with employee Id : " + employeeId);
            }
            randomAccessFile.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        } catch (DAOException daoException) {
            System.out.println(daoException.getMessage());
        }
    }

    public void getAll() {
        try {
            file = new File("Employees.txt");
            if (!file.exists()) throw new FileNotFoundException();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            String data = randomAccessFile.readLine();

            if(data != null) {
                System.out.println(data);
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void delete(int employeeId) throws DAOException, IOException, ParseException {
         if(employeeId<=0){
             throw new DAOException("Invalid employee Id");
         }
        file = new File("Employees.txt");
        if (!file.exists()) throw new FileNotFoundException();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        String fString = randomAccessFile.readLine();
        String array[] = fString.split(",");
        Employee employee;
        int j=0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<Employee> tempList = new ArrayList<>();
        for(int i=0; i< array.length/5; i++){
            employee = new Employee();
            employee.setEmployeeId(array[j]);
            employee.setName(array[j+1]);
            employee.setDateOfBirth(simpleDateFormat.parse(array[j+2]));
            employee.setEmailId(array[j+3]);
            employee.setAge(Integer.parseInt(array[j+4]));
            tempList.add(employee);
            j = j+5;
        }
        boolean flag=false;
        for(int i=0; i<tempList.size(); i++)
        {
            if(tempList.get(i).getEmployeeId().equals(String.valueOf(employeeId))) {
                tempList.remove(i);
                flag = true;
                randomAccessFile.close();
                file.delete();
                break;
            }
        }
        if(flag==true){System.out.println("employee deleted successfully");}
        file = new File("Employees.txt");
        randomAccessFile = new RandomAccessFile(file,"rw");
        for(int i=0; i<tempList.size(); i++)
        {
            randomAccessFile.writeBytes(tempList.get(i).getEmployeeId()+",");
            randomAccessFile.writeBytes(tempList.get(i).getName()+",");
            randomAccessFile.writeBytes(simpleDateFormat.format(tempList.get(i).getDateOfBirth())+",");
            randomAccessFile.writeBytes(tempList.get(i).getEmailId()+",");
            randomAccessFile.writeBytes(String.valueOf(tempList.get(i).getAge())+",");
        }

    }
}

