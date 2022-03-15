import java.io.Serializable;

public class Student implements Serializable {
    private String firstName;
    private String dateOfBirth;
    private Address address;

    Student(String firstName, String dateOfBirth, String city, String state, int pinCode, String country) {
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        address = new Address(city,state,pinCode,country);
    }
    public String getFirstName() {
        return this.firstName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
}
