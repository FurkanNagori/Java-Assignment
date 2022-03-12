import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment3 {
    public static int CRUDOptions() {
        int option = 0;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. View");
            System.out.println("2. Add");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.print("Enter your choice : ");
            option = sc.nextInt();
        } catch (InputMismatchException imme) {
            System.out.print("only numbers allowed");
        }
        return option;
    }

    public static void main(String[] gg) {
        System.out.println("Employee Management");
        Scanner sc = new Scanner(System.in);
        int option;
        String againOperation;
        int employeeId;
        String name;
        Date dateOfBirth;
        String emailId;
        int age;
        EmployeeDAO employeeDAO;
        do {
            option = CRUDOptions(); //calling method for menu of CRUD.
            switch (option) {
                case 1: //1 for View all employee.
                     employeeDAO = new EmployeeDAO();
                    employeeDAO.getAll();
                    break;

                case 2: //2 for add a employee.
                    try {
                        Employee employee = new Employee();
                        System.out.print("Enter name : ");
                        name = sc.nextLine();
                        System.out.print("Enter date of birth : ");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        dateOfBirth = simpleDateFormat.parse(sc.nextLine());
                        // sc.next();
                        System.out.print("Enter email id : ");
                        emailId = sc.nextLine();
                        System.out.print("Enter age : ");
                        age = sc.nextInt();
                        employee.setName(name);
                        employee.setDateOfBirth(dateOfBirth);
                        employee.setEmailId(emailId);
                        employee.setAge(age);
                       // employee.setDateOfBirth(dateOfBirth);
                        employeeDAO = new EmployeeDAO();
                        employeeDAO.add(employee);
                        break;
                    } catch (ParseException parseException) {
                        //do nothing;
                    } catch (DAOException daoException) {
                        System.out.println(daoException.getMessage());
                    }

                case 3: //3 for delete a employee.
                    System.out.print("Enter employee id for deleting a employee : ");
                    employeeId = sc.nextInt();
                    try{
                        employeeDAO = new EmployeeDAO();
                        employeeDAO.delete(employeeId);

                    }catch(DAOException daoException){
                        System.out.println(daoException.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    break;
                case 4: // for search a employee
                    System.out.print("Search by employee id/name (for searching type eid/name) : ");
                    String choice = sc.nextLine();
                    try {
                        if (choice.equalsIgnoreCase("eId")) {
                            System.out.print("Enter employee id : ");
                            employeeId = sc.nextInt();
                            employeeDAO = new EmployeeDAO();
                            employeeDAO.searchByEmployeeId(employeeId);
                        }
                        if (choice.equalsIgnoreCase("name")) {
                            System.out.print("Enter employee name : ");
                            name = sc.nextLine();
                            employeeDAO = new EmployeeDAO();
                            employeeDAO.searchByName(name);
                        }
                        break;
                    }catch(DAOException daoException){
                        System.out.println(daoException.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
            System.out.print("Do you want to continue (type yes/no) : ");
            sc.nextLine();
            againOperation = sc.nextLine();
        } while (againOperation.equalsIgnoreCase("yes"));
    }
}
