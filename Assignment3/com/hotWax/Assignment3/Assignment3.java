import java.util.*;

public class Assignment3 {
    public static int CRUDOptions() {
        int option = 0;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. View");
            System.out.println("Enter your choice : ");
            option = sc.nextInt();
        } catch (InputMismatchException imme) {
            System.out.print("only numbers allowed");
        }
        return option;
    }

    public static void main(String gg[]) {
        System.out.println("Employee Management");
        Scanner sc = new Scanner(System.in);
         int option=0;
         String againOperation="";
         String name="";
         String dateOfBirth="";
         String emailId="";
         int age=0;
        do {
            option = CRUDOptions(); //calling method for menu of CRUD.
            switch (option) {
                case 1: //1 for View all employee.
                    EmployeeDAO employeeDAO = new EmployeeDAO();
                    employeeDAO.getAll();
                    break;

                case 2: //2 for add a employee.
                    break;
                case 3: //3 for delete a employee.
                    break;
                case 4: // for search a employee
                    break;
            }
            System.out.print("Do you want to continue (type yes/no) : ");
            sc.nextLine();
            againOperation = sc.nextLine();
        } while (againOperation.equalsIgnoreCase("yes"));


    }
}
