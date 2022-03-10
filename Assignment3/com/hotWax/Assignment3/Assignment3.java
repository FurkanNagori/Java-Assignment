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
            System.out.println("3. Search");
            System.out.println("4. Delete");
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
        String name;
        Date dateOfBirth;
        String emailId;
        int age;
        do {
            option = CRUDOptions(); //calling method for menu of CRUD.
            switch (option) {
                case 1: //1 for View all employee.
                    EmployeeDAO employeeDAO = new EmployeeDAO();
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
                        employeeDAO = new EmployeeDAO();
                        employeeDAO.add(employee);
                        break;
                    } catch (ParseException parseException) {
                        //do nothing;
                    } catch (DAOException daoException) {
                        System.out.println(daoException.getMessage());
                    }

                case 3: //3 for delete a employee.
                    break;
                case 4: // for search a employee
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
            System.out.print("Do you want to continue (type yes/no) : ");
            sc.nextLine();
            againOperation = sc.nextLine();
        } while (againOperation.equalsIgnoreCase("yes"));


    }
}
