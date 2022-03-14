import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        List<Employee> tempList = createArrayList(array);
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
        randomAccessFile.close();

    }
    public void searchByEmployeeId(int employeeId) throws DAOException, IOException {
        if(employeeId<=0){
            throw new DAOException("Invalid employee id.");
        }
         file = new File("Employees.txt");
        if(!file.exists()) throw new DAOException("file not exist");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file,"r");
        String fString = randomAccessFile.readLine();
        String array[] = fString.split(",");
        List<Employee> tempList = createArrayList(array);
        for(int i=0; i<tempList.size(); i++)
        {
            if(tempList.get(i).getEmployeeId().equals(String.valueOf(employeeId))) {
                System.out.print(tempList.get(i).getEmployeeId()+" , ");
                System.out.print(tempList.get(i).getName()+" , ");
                System.out.print(tempList.get(i).getDateOfBirth()+" , ");
                System.out.print(tempList.get(i).getEmailId()+" , ");
                System.out.println(tempList.get(i).getAge());
            }
        }
        randomAccessFile.close();

    }

    public void searchByName(String name) throws DAOException, IOException {
        if(name==null){
            throw new DAOException("Invalid name");
        }
        file = new File("Employees.txt");
        if(!file.exists()) throw new DAOException("file not exist");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file,"r");
        String fString = randomAccessFile.readLine();
        String array[] = fString.split(",");
        List<Employee> tempList = createArrayList(array);
        for(int i = 0; i<tempList.size(); i++)
        {
            if(tempList.get(i).getName().equalsIgnoreCase(name)) {
                System.out.print(tempList.get(i).getEmployeeId()+" , ");
                System.out.print(tempList.get(i).getName()+" , ");
                System.out.print(tempList.get(i).getDateOfBirth()+" , ");
                System.out.print(tempList.get(i).getEmailId()+" , ");
                System.out.println(tempList.get(i).getAge());
            }
        }
        randomAccessFile.close();

    }
    public void sortEmployee(String sortBy)throws DAOException{
        System.out.println(sortBy);
        file = new File("Employees.txt");
        if(!file.exists()) throw new DAOException("file not exist");
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file,"r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String fString = null;
        try {
            fString = randomAccessFile.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String array[] = fString.split(",");
        List<Employee> tempList = createArrayList(array);
        if(sortBy.equals("eid")){

            Collections.sort(tempList,(e1, e2)->{
                 return Integer.parseInt(e1.getEmployeeId()) - Integer.parseInt(e2.getEmployeeId());
            });
//            positive then swap
//            negative no swap
            printArrayList(tempList);
        }

        if(sortBy.equals("name")){

            Collections.sort(tempList,(e1, e2)->{
                return e2.getName().compareTo(e1.getName());
            });
//            positive then swap
//            negative no swap
            printArrayList(tempList);
        }

        if(sortBy.equals("age")){

            Collections.sort(tempList,(e1, e2)->{
                return e1.getAge() - e2.getAge();
            });
//            positive then swap
//            negative no swap
            printArrayList(tempList);
        }


    }
    public void printArrayList(List<Employee> tempList){
        for(int i = 0; i<tempList.size(); i++)
        {
            System.out.print(tempList.get(i).getEmployeeId()+" , ");
            System.out.print(tempList.get(i).getName()+" , ");
            System.out.print(tempList.get(i).getDateOfBirth()+" , ");
            System.out.print(tempList.get(i).getEmailId()+" , ");
            System.out.println(tempList.get(i).getAge());
        }
    }
    public List<Employee> createArrayList(String[] array){
        Employee employee;
        int j=0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<Employee> tempList = new ArrayList<>();
        for(int i=0; i< array.length/5; i++){
            employee = new Employee();
            employee.setEmployeeId(array[j]);
            employee.setName(array[j+1]);
            try {
                employee.setDateOfBirth(simpleDateFormat.parse(array[j+2]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            employee.setEmailId(array[j+3]);
            employee.setAge(Integer.parseInt(array[j+4]));
            tempList.add(employee);
            j = j+5;
        }
        return tempList;
    }
}